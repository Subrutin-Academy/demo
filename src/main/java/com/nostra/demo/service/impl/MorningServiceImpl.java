package com.nostra.demo.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nostra.demo.dto.HelloDTO;
import com.nostra.demo.service.HelloService;

@Service(value = "morning_service")
public class MorningServiceImpl implements HelloService {

	@Override
	public HelloDTO sayHello() {
		HelloDTO dto = new HelloDTO();
		dto.setMessage("good morning");
		return dto;
	}

}
