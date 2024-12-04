package com.example.applicationregisterservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.applicationregisterservice.entity.ApplicatonRegister;

public interface ApplicationRegisterServiceRepo extends JpaRepository<ApplicatonRegister,Integer>{
	
	

}
