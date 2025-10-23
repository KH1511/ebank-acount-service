package org.sid.bank_acount_service.repositories;

import org.hibernate.query.criteria.JpaSearchedCase;
import org.sid.bank_acount_service.entities.BankAccount;
import org.sid.bank_acount_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}