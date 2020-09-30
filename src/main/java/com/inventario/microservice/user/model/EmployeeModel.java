package com.inventario.microservice.user.model;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(Include.NON_DEFAULT)
public class EmployeeModel implements Serializable {

	private static final long serialVersionUID = 1148844852818390863L;
	
	private UUID id;
	
	@NotBlank
	@Size(max = 30)
	private String jobPosition;
	
	@NotNull
	private double salary;
	
	private UsernameModel username;
}
