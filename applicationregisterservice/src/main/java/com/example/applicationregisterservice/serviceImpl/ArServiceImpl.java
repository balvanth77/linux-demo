package com.example.applicationregisterservice.serviceImpl;

import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.applicationregisterservice.dto.ApplicationRegisterDto;
import com.example.applicationregisterservice.entity.ApplicatonRegister;
import com.example.applicationregisterservice.repo.ApplicationRegisterServiceRepo;
import com.example.applicationregisterservice.service.IArService;

@Service
public class ArServiceImpl implements IArService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ApplicationRegisterServiceRepo repo;

    @Autowired
    private RestTemplate restTemplate; // For calling SSN API

    private static final String SSN_API_URL = "http://localhost:8081/validate"; 

    @Override
    public boolean registerApplication(ApplicationRegisterDto applicationRegisterDto) {
        String ssn = String.valueOf(applicationRegisterDto.getSsn());
        
        // Check if SSN is valid (6 digits and starts with '5')
        if (!isValidSSN(ssn)) {
            System.err.println("Invalid SSN: SSN must be 6 digits and start with 5.");
            return false;
        }

        // Call SSN API for further validation
        boolean isRhodeIslandCitizen = callSsnApi(ssn);
        if (!isRhodeIslandCitizen) {
            System.err.println("SSN validation failed: User is not a Rhode Island citizen.");
            return false;
        }
        

        


        // Map DTO to Entity and save to the database
        ApplicatonRegister register = modelMapper.map(applicationRegisterDto, ApplicatonRegister.class);

        // Generate 9-digit unique caseNumber
        String caseNumber = generateCaseNumber();
        register.setCaseNumber(caseNumber);

        try {
            repo.save(register);
            return true;
        } catch (Exception e) {
            System.err.println("Error saving application: " + e.getMessage());
            return false;
        }
    }

    private boolean isValidSSN(String ssn) {
        // Validate that the SSN is 6 digits and starts with '5'
        return ssn.matches("^5\\d{5}$");
    }

    private boolean callSsnApi(String ssn) {
        try {
            // Send SSN to external API and return validation result
            String url = SSN_API_URL + "?ssn=" + ssn;
            Boolean isValid = restTemplate.getForObject(url, Boolean.class);
            return isValid != null && isValid;
        } catch (Exception e) {
            System.err.println("Error communicating with SSN API: " + e.getMessage());
            return false;
        }
    }
    private String generateCaseNumber() {
        Random random = new Random();
        int caseNumber = 100_000_000 + random.nextInt(900_000_000); // Ensure 9 digits
        return String.valueOf(caseNumber);
    }
    //list of applications
	@Override
	public List<ApplicationRegisterDto> viewApplications() {
		// TODO Auto-generated method stub
		List<ApplicatonRegister> applications=repo.findAll();
		return applications.stream()
				.map(application->modelMapper.map(application, ApplicationRegisterDto.class))
				.toList();
	}
}
