package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Setter;


@Lazy//지연로딩
@Scope("singleton")

@Component
@AllArgsConstructor
public class SamsungTV implements TV {
	@Setter(onMethod_ = {@Autowired})
	Speaker speaker;
	

	
	@Override
	public void powerOn() {
		System.out.println("삼성 TV--전원 on");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성 TV--전원 off");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
