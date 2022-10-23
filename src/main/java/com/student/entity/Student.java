package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 20)
	private String dateOfBirth;
	
	@Column(length = 20)
	private String gender;
	
	@Column(length = 20)
	private String studentClass;
	
	@Column(length = 20)
	private String ethnic;
	
	@Column(length = 100)
	private String fatherName;
	
	@Column(length = 100)
	private String motherName;
	
	@Column(length = 100)
	private String currentAddress;

	public Student(String name, String dateOfBirth, String gender, String studentClass, String ethnic,
			String fatherName, String motherName, String currentAddress) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.studentClass = studentClass;
		this.ethnic = ethnic;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.currentAddress = currentAddress;
	}
	
	
}
