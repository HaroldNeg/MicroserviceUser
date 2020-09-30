package com.inventario.microservice.user.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventario.microservice.user.model.PersonModel;
import com.inventario.microservice.user.service.IUsernameService;

@Service
public class UsernameServiceImpl implements IUsernameService {

	@Override
	public ResponseEntity<?> verify(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(PersonModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> status(PersonModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
