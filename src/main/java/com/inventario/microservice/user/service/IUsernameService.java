package com.inventario.microservice.user.service;

import org.springframework.http.ResponseEntity;

import com.inventario.microservice.user.model.PersonModel;

public interface IUsernameService {

	public abstract ResponseEntity<?> verify(String username);
	
	public abstract ResponseEntity<?> update(PersonModel model);
	
	public abstract ResponseEntity<?> status(PersonModel model);
	
	public abstract ResponseEntity<?> delete(String id);
}
