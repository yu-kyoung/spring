package com.example.demo.emp.service.impl;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;
import com.example.demo.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // = @Component
public class EmpServiceImpl implements EmpService {
	final EmpMapper empMapper;

	@Override
	public Long selectCount(EmpVO empVO) {
		return empMapper.selectCount(empVO);
	}

	@Override
	public List<EmpVO> selectEmp(EmpVO empVO) {
		return empMapper.selectEmp(empVO);
	}

	@Override
	public EmpVO selectEmpById(Long employeeId) {
		return empMapper.selectEmpById(employeeId);
	}

	@Override
	public int insertEmp(EmpVO empVO) {
		return empMapper.insertEmp(empVO);
	}
}
