package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.School;
import com.example.demo.domain.Student;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class SchoolRepositoryTest {
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	StudentRepository studentRepository;

	@Test
	@Transactional
	@Rollback(false)
	void manytoOneTest() {
		School school = new School("예담고등학교");
		Student s1 = new Student("홍길동");
		Student s2 = new Student("이몽룡");
		school.addStudent(s1);
		school.addStudent(s2);
		// school 저장 시 students 도 함께 persist 됨 (CascadeType.ALL 덕분에)
		schoolRepository.save(school);

		studentRepository.findAll().forEach(std -> {
			log.info(std);
		});
	}
}