package com.tcs.service.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.service.customer.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long>{

}
