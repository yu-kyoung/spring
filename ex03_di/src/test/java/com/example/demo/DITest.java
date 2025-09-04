package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DITest {

	@Autowired TV tv;
	@Autowired SampleHotel hotel;
	//@Test
public void test() {
	//TV tv = new SamsungTV();
	tv.powerOn();
	tv.volumeUp();
}

@Test
public void hotel_test() {
	System.out.println(hotel.getChef());
}
}
