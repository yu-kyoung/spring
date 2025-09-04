package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
//생성자 (@RequiredArgConstructor + final)
//setter(@Setter(onMethod_={@Autowired}))
public class SampleHotel {
	@Autowired
	Chef chef;
}
