package com.inventario.microservice.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usernames")
public class Username implements Serializable {

	private static final long serialVersionUID = 1318842949613921259L;
	
	@EmbeddedId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Employee employee;
	
	@Column(length = 30, nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	private boolean active;
	
	private boolean nonbloqued;
	
	private int tries;
}
