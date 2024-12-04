package com.example.applicationregisterservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.applicationregisterservice.dto.ApplicationRegisterDto;
import com.example.applicationregisterservice.serviceImpl.ArServiceImpl;

@RestController
public class ApplicationRegisterController {
	
	@Autowired
	private ArServiceImpl service;
	
	@PostMapping("/register")
	private ResponseEntity<String> register(@RequestBody ApplicationRegisterDto applicationRegisterDto){
		
		boolean isSaved=service.registerApplication(applicationRegisterDto);
		
		if(isSaved) {
			return ResponseEntity.ok("application register sucess");
		}else {
			return ResponseEntity.badRequest().body("Failed to register application. Invalid SSN or citizen not from Rhode Island.");
		}
		
	}
	
	//view all applications
	@GetMapping("/viewApplications")
	private ResponseEntity<List<ApplicationRegisterDto>> viewApplications(ApplicationRegisterDto applicationRegisterDto){
		List<ApplicationRegisterDto> applications=service.viewApplications();
		return ResponseEntity.ok(applications);
	}

}
