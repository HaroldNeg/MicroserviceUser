package com.inventario.microservice.user.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.inventario.microservice.user.enums.TelephoneType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_DEFAULT)
public class TelephoneModel implements Serializable {

	private static final long serialVersionUID = -5284342404016114769L;

	private UUID id;

	@NotBlank
	@Size(max = 12)
	private TelephoneType type;

	@Max(value = 3)
	private int indicative;
	
	@Max(value = 7)
	private int extension;
	
	@NotBlank
	@Size(max = 10)
	private BigInteger number;
	
	
}
