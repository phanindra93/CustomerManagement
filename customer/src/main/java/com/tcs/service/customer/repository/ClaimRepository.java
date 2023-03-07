package com.tcs.service.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.service.customer.model.Claim;
@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
