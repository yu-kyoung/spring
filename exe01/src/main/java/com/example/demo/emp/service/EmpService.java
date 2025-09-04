package com.example.demo.emp.service;

import java.util.List;
/**
 * 사용자의 시스템 기능이 서비스가 됨(use case diagram)
 * 
 * 	서비스				메퍼
 * 설명: 시스템기능			데이터베이스처리
 * 예시
 * 
 * */
//use case diagram
public interface EmpService {

	//건수조회 
	Long selectCount(EmpVO empVO); 	
	//전체조회
	List<EmpVO> selectEmp(EmpVO empVO);
	//단건조회
	EmpVO selectEmpById(Long employeeId);//이름달라도 상관은없다.
	//등록
	int insertEmp(EmpVO empVO);
	
	//수정
	
	//삭제
	
	
	//퇴사
	
}
