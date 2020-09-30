package com.inventario.microservice.user.model;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@JsonInclude(Include.NON_DEFAULT)
public class UsernameModel implements Serializable {

	private static final long serialVersionUID = 3052818716538916622L;
	
	private UUID id;

	@NotBlank
	@Size(max = 30)
	private String username;
	
	@NotBlank
	private String password;
	
	private boolean active;
	
	private boolean nonbloqued;
	
	@NotNull
	@Max(3)
	private int tries;
}
