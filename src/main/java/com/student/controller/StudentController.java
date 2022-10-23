package com.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.entity.Student;
import com.student.model.ReadExcelFile;
import com.student.model.StudentExporter;
import com.student.repository.IStudentRepository;
import com.student.service.IStudentService;
import com.student.util.ConvertObject;
import com.student.util.SlugHandler;

@Controller
public class StudentController {

	@Autowired
	private IStudentService studentService;
	@Autowired
	private IStudentRepository studentRepository;

	@GetMapping()
	public String home(){
		
		return "index";
	}
	
	@GetMapping("/student/export")
	public @ResponseBody ResponseEntity<?> exportToExcel(@RequestParam(defaultValue = "") String address,HttpServletResponse res) throws IOException {
		res.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachement; filename="+SlugHandler.toSlug(address)+".xlsx";
		res.setHeader(headerKey, headerValue);

		// data
		List<Student> students = studentService.findByAddress(address);

		StudentExporter studentExcelExporter = new StudentExporter(students);
		studentExcelExporter.export(res);

		return ResponseEntity.status(200).body(students.size());
	}

	@PostMapping("/student/import")
	public @ResponseBody ResponseEntity<?> importExcelFile(@RequestParam(name = "files") MultipartFile[] files) throws IOException {
		List<Student> students = new ArrayList<>();
		
		Arrays.asList(files).stream().forEach(file -> {
			try {
				students.addAll(ReadExcelFile.readFile(ConvertObject.convertMultipartToFile(file)));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		});
		studentRepository.saveAll(students);
		return ResponseEntity.status(200).body(students);

	}

	public class ResponseStudentList {
		List<Student> students;
		int size;

		public ResponseStudentList(List<Student> students, int size) {

			this.students = students;
			this.size = size;
		}

	}
}
