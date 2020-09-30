package com.inventario.microservice.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
@IdClass(Person.class)
public class Employee implements Serializable {

	private static final long serialVersionUID = 1318842949613921259L;
	
	@EmbeddedId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Person person;
	
	@Column(length = 30, nullable = false)
	private String jobPosition;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal salary;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
	private Username username;
	
}
