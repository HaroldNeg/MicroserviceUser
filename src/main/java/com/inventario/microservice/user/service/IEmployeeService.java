package com.inventario.microservice.user.service;

import org.springframework.http.ResponseEntity;

public interface IEmployeeService {
	
	public abstract ResponseEntity<?> delete(String id);
}
