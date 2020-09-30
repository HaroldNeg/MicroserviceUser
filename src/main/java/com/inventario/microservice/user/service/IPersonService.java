package com.inventario.microservice.user.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.inventario.microservice.user.model.PersonModel;

public interface IPersonService {
	
	public abstract ResponseEntity<?> verify(String documentNumber, String email);

	public abstract ResponseEntity<?> create(PersonModel model);
	
	public abstract ResponseEntity<?> list(Pageable pageable);
	
	public abstract ResponseEntity<?> list(Pageable pageable, String search);
	
	public abstract ResponseEntity<?> detail(String id);
	
	public abstract ResponseEntity<?> update(PersonModel model);
	
	public abstract ResponseEntity<?> delete(String id);
}
