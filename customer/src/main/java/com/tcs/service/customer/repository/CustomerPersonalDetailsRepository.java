package com.tcs.service.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.service.customer.model.CustomerPersonalDetails;
@Repository
public interface CustomerPersonalDetailsRepository extends JpaRepository<CustomerPersonalDetails, Long>{

}
