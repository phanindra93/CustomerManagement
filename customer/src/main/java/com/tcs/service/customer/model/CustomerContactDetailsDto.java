package com.tcs.service.customer.model;

import lombok.Data;

@Data

public class CustomerContactDetailsDto {
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
	private Long contactId;
	private String address;
    private String phoneNumber;
    private String emailAddress;
    
}
