package com.tcs.service.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.service.customer.model.CustomerContactDetailsDto;
import com.tcs.service.customer.service.CustomerPersonalDetailsService;

@RestController

public class CustomerPersonalDetailsController {
	
	@Autowired
	CustomerPersonalDetailsService service;
	
	@PostMapping("/saveCustomerContactDetails")
	public CustomerContactDetailsDto saveDetails(@RequestBody CustomerContactDetailsDto details){
		return service.createCustomerAndContactDetails(details);
	}
	
	@GetMapping("getCustomerContactDetails/{id}" )
	public CustomerContactDetailsDto getDetailsbyId(@PathVariable Long id) {
		return service.getCustomerContactDetailsById(id);
	}
	
	@PutMapping("/updateCustomerContactDetails")
	public CustomerContactDetailsDto updateDetails(@RequestBody CustomerContactDetailsDto details){
		return service.updateCustomerContactDetails(details);
	}

}
