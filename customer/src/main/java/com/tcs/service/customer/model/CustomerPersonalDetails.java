package com.tcs.service.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPersonalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String firstName;
	private String lastName;
	private String dob;
	private String sex;
	private String citizenship;
	private String maritalStatus;
	private String occupation;
	private String jobRole;
	private double salary;
	private double netWorth;
	private String drivingLicenseNo;
//	private ContactDetails contactDetails;
	
	
	

}
