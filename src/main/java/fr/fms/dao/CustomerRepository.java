package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
 