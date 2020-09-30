package com.inventario.microservice.user.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.inventario.microservice.user.enums.TelephoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "telephones")
public class Telephone implements Serializable {

	private static final long serialVersionUID = 65626530293264349L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 16)
	private UUID id;

	@Column(length = 12, nullable = false, 
			columnDefinition = "enum('MÓVIL', 'CASA', 'TRABAJO', 'FAX', 'LOCALIZADOR', 'OTRO')")
	@Enumerated(value = EnumType.STRING)
	
	private TelephoneType type;

	@Column(length = 3)
	private String indicative;
	
	@Column(length = 7)
	private String extension;
	
	@Column(length = 10, nullable = false)
	private String number;
	
	
}
