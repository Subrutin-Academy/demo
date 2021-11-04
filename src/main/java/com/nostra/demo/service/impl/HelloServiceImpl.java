package com.nostra.demo.service.impl;

import org.springframework.stereotype.Service;

import com.nostra.demo.dto.HelloDTO;
import com.nostra.demo.service.HelloService;

@Service(value = "hello_service")
public class HelloServiceImpl implements HelloService{

	@Override
	public HelloDTO sayHello() {
		HelloDTO dto = new HelloDTO();
		dto.setMessage("hello world");
		return dto;
	}

}
