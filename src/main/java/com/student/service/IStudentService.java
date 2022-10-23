package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface IStudentService {

	List<Student> findAll();
	List<Student> findByAddress(String address);
}
