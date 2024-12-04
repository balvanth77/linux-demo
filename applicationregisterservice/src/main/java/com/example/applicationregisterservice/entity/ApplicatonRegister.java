package com.example.applicationregisterservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class ApplicatonRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String email;
    private Long mobileNumber;
    private String gender;
    private String dateOfBirth;
    private Long ssn;
    private String caseNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Long getSsn() {
		return ssn;
	}
	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	@Override
	public String toString() {
		return "ApplicatonRegister [id=" + id + ", fullName=" + fullName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", ssn=" + ssn
				+ ", caseNumber=" + caseNumber + "]";
	}
	public ApplicatonRegister(int id, String fullName, String email, Long mobileNumber, String gender,
			String dateOfBirth, Long ssn, String caseNumber) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.ssn = ssn;
		this.caseNumber = caseNumber;
	}
	public ApplicatonRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
}
