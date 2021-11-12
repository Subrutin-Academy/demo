package com.nostra.demo.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nostra.demo.dto.HelloDTO;
import com.nostra.demo.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloResource {
	
	
	private HelloService helloService;


	public HelloResource(@Qualifier("morning_service") HelloService helloService) {
		super();
		this.helloService = helloService;
	}


	@GetMapping("/hello")
	public ResponseEntity<HelloDTO> hello(){
		log.info("start method");
		return ResponseEntity.ok(helloService.sayHello());
	}

	
	
}
