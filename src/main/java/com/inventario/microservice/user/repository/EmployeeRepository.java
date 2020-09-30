package com.inventario.microservice.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.microservice.user.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>{

}
