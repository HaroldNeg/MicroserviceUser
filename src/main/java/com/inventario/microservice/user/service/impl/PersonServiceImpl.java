package com.inventario.microservice.user.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventario.microservice.user.entity.Person;
import com.inventario.microservice.user.mapper.UserMapper;
import com.inventario.microservice.user.model.PersonModel;
import com.inventario.microservice.user.model.PersonVerifyModel;
import com.inventario.microservice.user.repository.PersonRepository;
import com.inventario.microservice.user.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public ResponseEntity<?> verify(String documentNumber, String email) {
		PersonVerifyModel verifyModel = new PersonVerifyModel();
		if(!documentNumber.isEmpty()) {
			verifyModel.setDocumentType(!personRepository.existsByDocumentNumber(documentNumber));
		}
		if (!email.isEmpty()) {
			verifyModel.setEmail(!personRepository.existsByEmail(email));
		}
		return ResponseEntity.status(200).body(verifyModel);
	}

	@Override
	public ResponseEntity<?> create(PersonModel model) {
		personRepository.save(mapper.PersonIn(model));
		return ResponseEntity.status(201).build();
	}

	@Override
	public ResponseEntity<?> list(Pageable pageable) {
		return ResponseEntity.status(200).body(mapper.PersonOut(personRepository.findAll(pageable)));
	}

	@Override
	public ResponseEntity<?> list(Pageable pageable, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> detail(String id) {
		PersonModel model = mapper.PersonOut(personRepository.findById(UUID.fromString(id)).orElse(new Person()));
		if (model.getId() != null) {
			return ResponseEntity.status(200).body(model);
		} else {
			//falta el modelo(Dto) del Error para el 404
			return ResponseEntity.status(404).build();
		}
	}

	@Override
	public ResponseEntity<?> update(PersonModel model) {
		personRepository.save(mapper.PersonIn(model));
		return ResponseEntity.status(204).build();
	}

	@Override
	public ResponseEntity<?> delete(String id) {
		personRepository.deleteById(UUID.fromString(id));
		return ResponseEntity.status(204).build();
	}

}
