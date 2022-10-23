package com.student.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.student.entity.Student;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentRepositotyTest {
	@Autowired
	private IStudentRepository studentRepository;
	@Test
	public void testStudentAddressQuery() {
		String name="Phương Bình 2";
		List<Student> res=studentRepository.findByAddressNonSpaceLowerCase(name.replaceAll(" ", "").toLowerCase());
		System.out.println(res.size());
	}
	@Test
	public void toNonSpaceLowerCase() {
		String name="Phương Bình 2";
		System.out.println(name.replaceAll(" ", "").toLowerCase());
	}
}
