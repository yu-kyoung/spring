package com.example.demo.emp.mapper;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpVO {

	
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private Double salary;
	private Double commissionPct;
	private String managerId;
	private String departmentId;
}
