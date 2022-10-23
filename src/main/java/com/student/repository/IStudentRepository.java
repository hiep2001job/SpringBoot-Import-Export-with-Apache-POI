package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByCurrentAddressContaining(String currentAddress);
 
	@Query(value="SELECT * FROM student s WHERE LOWER(REPLACE(s.current_address,' ','')) LIKE %:hamlet%",nativeQuery = true)
	List<Student> findByAddressNonSpaceLowerCase(@Param("hamlet") String hamlet);
}
