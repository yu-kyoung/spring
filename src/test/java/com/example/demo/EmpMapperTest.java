package com.example.demo;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.mapper.EmpVO;

@SpringBootTest
public class EmpMapperTest {
	@Autowired
	EmpMapper empMapper;

	@DisplayName("전체조회")
	//@Test
	public void selectEmp() {
		empMapper.selectEmp()
		.forEach(emp -> System.out.println(emp.getFirstName()));
	}
	
	
	@DisplayName("단건조회")
	//@Test
	public void selectEmpById() {
		EmpVO empVO= empMapper.selectEmpById(100L);
		System.out.println(empVO.getFirstName());
	}
	
	@DisplayName("등록")
	@Test
	public void insertEmp() {
		EmpVO empVO=EmpVO.builder()
				.employeeId(400L)
				.email("a@a.aa")
				.lastName("길동")
				.jobId("IT_PROG")
				.hireDate(new Date())
				.build();
		int result =empMapper.insertEmp(empVO);
		System.out.println(result +" 건이 처리됨");
	}
	
}
