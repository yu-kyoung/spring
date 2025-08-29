package com.example.demo.emp.wep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.emp.mapper.EmpMapper;

@Controller
public class EmpController {
	@Autowired
	EmpMapper empMapper;// new X

	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList", empMapper.selectEmp());
		return "empList";  //empList.html
	}
}
