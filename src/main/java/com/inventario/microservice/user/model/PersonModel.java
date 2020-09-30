package com.inventario.microservice.user.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.inventario.microservice.user.enums.DocumentType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_DEFAULT)
public class PersonModel implements Serializable {

	private static final long serialVersionUID = -4535371503197413633L;

	private UUID id;
	
	@NotBlank
	@Size(max = 100)
	private String firstName;
	
	@NotBlank
	@Size(max = 100)
	private String lastName;
	
	@NotBlank
	@Size(max = 2)
	private DocumentType documentType;
	
	@NotBlank
	@Size(max = 16)
	private String documentNumber;
	
	private List<TelephoneModel> telephone;
	
	@Email
	private String email;
	
	private EmployeeModel employee;
}
