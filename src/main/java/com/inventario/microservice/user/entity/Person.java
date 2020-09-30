package com.inventario.microservice.user.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.inventario.microservice.user.enums.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
@Embeddable
public class Person implements Serializable {

	private static final long serialVersionUID = 9181618666513455033L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 16)
	private UUID id;
	
	@Column(length = 100, nullable = false)
	private String firstName;
	
	@Column(length = 100, nullable = false)
	private String lastName;
	
	@Column(length = 2, nullable = false, 
			columnDefinition = "enum('CC', 'TI', 'CE', 'PA', 'MS', 'AS', 'PE')")
	@Enumerated(value = EnumType.STRING)
	private DocumentType documentType;
	
	@Column(length = 16, nullable = false, unique = true)
	private String documentNumber;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person")
	private List<Telephone> telephoneList;
	
	@Column(unique = true)
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
	private Employee employee;
}
