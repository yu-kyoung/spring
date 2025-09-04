package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpMapperTest {
@Autowired EmpMapper empMaPeer;
@DisplayName("전체조회")
//@Test
public void selectEmp() {
	EmpVO vo = new EmpVO();
	vo.setDepartmentId(50L);
	vo.setFirstName("peter");
	vo.setFirst(1);
	vo.setLast(10);
	List<EmpVO> list = empMaPeer.selectEmp(vo);
	System.out.println("count" + list.size());
	list.forEach(emp->System.out.println(emp));
	//키값
//	empMaPeer.selectEmp().forEach(emp -> System.out.println(emp.get("FRIST_NAME")));
//	empMaPeer.selectEmp().forEach(emp -> System.out.println(emp.get("firstName")));
//	empMaPeer.selectEmp().
//	forEach(emp -> System.out.println(emp.getFirstName()));
 }
//.getFirstName()
@DisplayName("단건조회")
@Test
public void selectEmpById() {
	EmpVO empVO = empMaPeer.selectEmpById(100L);
	log.warn(empVO.getDeptVO().getDepartmentName());
}
@DisplayName("등록")
//@Test
public void insertEmp() {
//	EmpVO empVO = new EmpVO();
	EmpVO empVO = EmpVO.builder()
			      .employeeId(401L)
			      .email("aaa_ab")
			      .lastName("길순")
			      .jobId("IT_PROG")
			      .hireDate(new Date())
			      .build();
			      
//	empVO.setEmail(null);
	int result = empMaPeer.insertEmp(empVO);
	System.out.println(result + " 건이 처리됨");
}
}
