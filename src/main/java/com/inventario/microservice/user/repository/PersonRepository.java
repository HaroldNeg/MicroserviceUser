package com.inventario.microservice.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.microservice.user.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

	public abstract Person findByDocumentNumber(String documentNumber);
	
	public abstract boolean existsByDocumentNumber(String documentNumber);
	
	public abstract boolean existsByEmail(String email);
		
}
