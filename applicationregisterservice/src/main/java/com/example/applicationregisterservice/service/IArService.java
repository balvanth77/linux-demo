package com.example.applicationregisterservice.service;

import java.util.List;

import com.example.applicationregisterservice.dto.ApplicationRegisterDto;

public interface IArService {
	
	public boolean registerApplication(ApplicationRegisterDto applicationRegisterDto);
	
	public List<ApplicationRegisterDto> viewApplications();

}
