package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CustomerRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AddressRepository addressRepository;
	
	// @Test
	public void list() {
		List<Customer> list = customerRepository.findAll();
		list.forEach(System.out::println);
	}

	// 단건조회
	// @Test
	public void get() {
		Customer customer = customerRepository.findById(1L).get();
		System.out.println(customer);
	}

	// 삭제(지금 오류있음)
	// @Test
	public void delete() {
		// 단건조회
		Customer customer = customerRepository.findById(1L).get();
		// 삭제
		customerRepository.delete(customer);
	}

	// 등록
	// @Test
	public void insert() {
		Customer customer = new Customer("kim", "010-2222-2222", null);
		customerRepository.save(customer);
		customerRepository.findAll().forEach(System.out::println);
	}

	// 업데이트/수정
	// @Test
//	public void update() {
//		// 단건조회
//		Customer customer = customerRepository.findById(1L).get();
//		// 이름변경
//		customer.setName("유경");
//		// save
//		customerRepository.save(customer);
//		// 단건조회 결과 출력
//		Customer customer1 = customerRepository.findById(1L).get();
//		System.out.println(customer1);
//	}

	// @Test
	public void findName() {
		customerRepository.findByNameLike("%im").forEach(System.out::println);
	}

	// @Test
	public void findPhone() {
		customerRepository.findByPhone("1").forEach(System.out::println);
	}
	@Test
	public void	onetoOneCustomerOwnerTest()	{
		 //	given(준비)
		 Address addressEntity = Address.
				 builder().zipcode("04411").address("대구").build();	
		addressRepository.save(addressEntity);
		 Customer	customerentity	=	Customer.builder()
		.name("길동")
		.phone("001")
		.address(addressEntity)
		.build();
		 customerRepository.save(customerentity);
		 
		 
		 //when(실행)
		 Customer customer=customerRepository.findById(1L).get();
		 log.info(customer.getName()+":"+customer.getAddress().getZipcode());
		 
		 //then(검증)
		 assertEquals("04411",	customer.getAddress().getZipcode());
	
	}
}
