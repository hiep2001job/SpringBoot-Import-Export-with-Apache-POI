package com.student.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.student.entity.Student;

public class ReadExcelFile {
	public static List<Student> readFile(File file) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet datatypeSheet = workbook.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();

		List<Student> students = new ArrayList<>();

		int rowPos = 6;
		Row curRow = datatypeSheet.getRow(rowPos++);
		Student student;
		while (curRow != null) {

			try {
				student = new Student(curRow.getCell(1).getStringCellValue(), curRow.getCell(2).getStringCellValue(),
						curRow.getCell(3).getStringCellValue(), curRow.getCell(4).getStringCellValue(),
						curRow.getCell(5).getStringCellValue(), curRow.getCell(6).getStringCellValue(),
						curRow.getCell(7).getStringCellValue(), curRow.getCell(8).getStringCellValue());
				students.add(student);
			} catch (Exception e) {
				break;
			}

			curRow = datatypeSheet.getRow(rowPos++);
		}
		return students;
	}
}
