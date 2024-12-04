package com.example.applicationregisterservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApplicationRegisterDto {

    private String fullName;
    private String email;
    private Long mobileNumber;
    private String gender;
    private String dateOfBirth;
    private Long ssn;
    private String caseNumber;

    
    
    
    
}
