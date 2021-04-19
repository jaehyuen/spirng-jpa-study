package com.study.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.jpa.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {

	final private TestService testService;
	
	@GetMapping(path="/test")
	public String init() {
		
		testService.testInit();
		return "zzz";
	}
	
	@GetMapping("/find/school")
	public Object findeSchool() {
		
		return testService.findeSchool();
		
	}
	
	@GetMapping("/find/teacher")
	public Object findTeacher() {
		
		return testService.findTeacher();
		
	}
}
