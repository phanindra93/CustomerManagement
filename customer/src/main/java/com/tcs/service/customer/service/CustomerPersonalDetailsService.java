package com.tcs.service.customer.service;



import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.service.customer.model.ContactDetails;
import com.tcs.service.customer.model.CustomerContactDetailsDto;
import com.tcs.service.customer.model.CustomerPersonalDetails;
import com.tcs.service.customer.repository.ContactDetailsRepository;
import com.tcs.service.customer.repository.CustomerPersonalDetailsRepository;

@Service
public class CustomerPersonalDetailsService {
@Autowired
CustomerPersonalDetailsRepository repo;
@Autowired
ContactDetailsRepository repo2;
public CustomerPersonalDetails getCustomerPersonalDetailsById(Long id) {
    return repo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PersonalDetails with id " + id + " not found"));
}

public CustomerPersonalDetails createCustomerPersonalDetails(CustomerPersonalDetails personalDetails) {
    return repo.save(personalDetails);
}


public CustomerPersonalDetails updateCustomerPersonalDetails( CustomerPersonalDetails personalDetails) {

    CustomerPersonalDetails previous =repo.findById(personalDetails.getCustomerId()).get();
    if(previous!=null) {
    	previous=repo.save(personalDetails);
    }else {
    	throw new EntityNotFoundException("PersonalDetails with id " + personalDetails.getCustomerId() + " not found");
    }
   
    return previous;
}


//private Long customerId;
//private String firstName;
//private String lastName;
//private String dob;
//private String sex;
//private String citizenship;
//private String maritalStatus;
//private String occupation;
//private String jobRole;
//private double salary;
//private double netWorth;
//private String drivingLicenseNo;
//private Long contactId;
//private String address;
//private String phoneNumber;
//private String emailAddress;

public CustomerContactDetailsDto createCustomerAndContactDetails(CustomerContactDetailsDto request) {
	CustomerContactDetailsDto response = new CustomerContactDetailsDto();
	CustomerPersonalDetails cpd=new CustomerPersonalDetails();
	cpd.setFirstName(request.getFirstName());
	cpd.setLastName(request.getLastName());
	cpd.setDob(request.getDob());
	cpd.setSex(request.getSex());
	cpd.setCitizenship(request.getCitizenship());
	cpd.setMaritalStatus(request.getMaritalStatus());
	cpd.setOccupation(request.getOccupation());
	cpd.setJobRole(request.getJobRole());
	cpd.setSalary(request.getSalary());
	cpd.setNetWorth(request.getNetWorth());
	cpd.setDrivingLicenseNo(request.getDrivingLicenseNo());
	cpd=repo.save(cpd);
	ContactDetails cd=new ContactDetails();
	cd.setCustomerId(cpd.getCustomerId());
	cd.setPhoneNumber(request.getPhoneNumber());
	cd.setEmailAddress(request.getEmailAddress());
	cd.setAddress(request.getAddress());
	cd=repo2.save(cd);
	response.setFirstName(cpd.getFirstName());
	response.setCustomerId(cpd.getCustomerId());
	response.setContactId(cd.getContactId());
	response.setAddress(cd.getAddress());
	response.setLastName(cpd.getLastName());
	
	return response;
}
public CustomerContactDetailsDto getCustomerContactDetailsById(Long id) {
	CustomerContactDetailsDto response = new CustomerContactDetailsDto();
	CustomerPersonalDetails cpd=repo.findById(id).get();
	
	if(cpd!=null) {
		response.setCustomerId(cpd.getCustomerId());
		response.setFirstName(cpd.getFirstName());
		response.setLastName(cpd.getLastName());
		ContactDetails cd=repo2.findByCustomerId(cpd.getCustomerId());
		if(cd!=null) {
			response.setAddress(cd.getAddress());
			response.setContactId(cd.getContactId());
			
		}
	}
	
	
	
	return response;
}

public CustomerContactDetailsDto updateCustomerContactDetails(CustomerContactDetailsDto request) {
	CustomerContactDetailsDto response = new CustomerContactDetailsDto();
	CustomerPersonalDetails cpd=repo.findById(request.getCustomerId()).get();
	ContactDetails cd=repo2.findById(request.getContactId()).get();
	if(cpd!=null) {
		cpd.setFirstName(request.getFirstName());
		cpd.setLastName(request.getLastName());
		repo.save(cpd);
	}
	if(cd!=null) {
		if(request.getAddress()!=null) {
			cd.setAddress(request.getAddress());
		}
		
		repo2.save(cd);
	}
	response.setCustomerId(cpd.getCustomerId());
	response.setFirstName(cpd.getFirstName());
	response.setLastName(cpd.getLastName());
	response.setAddress(cd.getAddress());
	response.setContactId(cd.getContactId());
	
	
	
	
	return response;
	
}


}
