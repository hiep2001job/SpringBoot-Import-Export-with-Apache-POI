package com.student.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.IStudentRepository;
import com.student.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public List<Student> findAll(){
		
		return studentRepository.findAll();
	}
	
	@Override
	public List<Student> findByAddress(String address) {
		return studentRepository.findByAddressNonSpaceLowerCase(address.replaceAll(" ", "").toLowerCase());
	}
}
