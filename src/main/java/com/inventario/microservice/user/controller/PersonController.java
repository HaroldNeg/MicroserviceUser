package com.inventario.microservice.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.microservice.user.model.PersonModel;
import com.inventario.microservice.user.service.IPersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private IPersonService service;

	@GetMapping("/valid")
	public ResponseEntity<?> validatePerson(
			@RequestParam(value = "documentNumber", required = false, defaultValue = "") String documentNumber,
			@RequestParam(value = "email", required = false, defaultValue = "") String email) {
		return service.verify(documentNumber, email);
	}

	@PostMapping
	public ResponseEntity<?> createPerson(@RequestBody @Valid PersonModel model) {
		return service.create(model);
	}

	@GetMapping
	public ResponseEntity<?> listPerson(
			@RequestParam(value = "search", required = false, defaultValue = "") String search, Pageable pageable) {
		if (search.isEmpty()) {
			return service.list(pageable);
		} else {
			return service.list(pageable, search);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> detailPerson(@PathVariable(value = "id") String id) {
		return service.detail(id);
	}

	@PutMapping
	public ResponseEntity<?> updatePerson(@RequestBody @Valid PersonModel model) {
		return service.update(model);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") String id) {
		return service.delete(id);
	}
}
