package com.example.demo.emp.service;

//import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.common.SearchVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//BigDecimal
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO extends SearchVO{
  private Long employeeId;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private Date hireDate;
  private String jobId;
  private Double salary;
  private Double commissionPct;
  private Long managerId;
  private Long departmentId;
  
  DeptVO deptVO;
}
