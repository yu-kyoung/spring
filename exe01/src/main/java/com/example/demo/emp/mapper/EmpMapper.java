package com.example.demo.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.emp.service.EmpVO;

@Mapper // 인터페이스 구현클래스를 생성(싱글톤)에서 스프링 컨테이너 빈 등록
public interface EmpMapper {
//	List<Map<String,Object>> selectEmp();
	//건수조회 Long = long
	Long selectCount(EmpVO empVO); 	
	//전체조회
	List<EmpVO> selectEmp(EmpVO empVO);
	//단건조회
	EmpVO selectEmpById(Long employeeId);//이름달라도 상관은없다.
	//등록
	int insertEmp(EmpVO empVO);
}
