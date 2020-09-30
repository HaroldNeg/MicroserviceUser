package com.inventario.microservice.user.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.inventario.microservice.user.entity.Employee;
import com.inventario.microservice.user.entity.Person;
import com.inventario.microservice.user.entity.Telephone;
import com.inventario.microservice.user.entity.Username;
import com.inventario.microservice.user.model.EmployeeModel;
import com.inventario.microservice.user.model.PersonModel;
import com.inventario.microservice.user.model.TelephoneModel;
import com.inventario.microservice.user.model.UsernameModel;

@Component
public class UserMapper {

	public Person PersonIn(PersonModel model) {
		Person entity = Person.builder()
				.id(model.getId())
				.firstName(model.getFirstName())
				.lastName(model.getLastName())
				.documentType(model.getDocumentType())
				.documentNumber(model.getDocumentNumber())
				.email(model.getEmail())
				.build();
		if (model.getTelephone() != null) {
			entity.setTelephoneList(new ArrayList<>());
			for (TelephoneModel telephoneModel : model.getTelephone()) {
				Telephone telephone = Telephone.builder()
						.id(telephoneModel.getId())
						.type(telephoneModel.getType())
						.indicative(Integer.toString(telephoneModel.getIndicative()))
						.extension(Integer.toString(telephoneModel.getExtension()))
						.number(telephoneModel.getNumber().toString())
						.build();
				entity.getTelephoneList().add(telephone);
			}
		}
		if (model.getEmployee() != null) {
			entity.setEmployee(Employee.builder()
					.person(entity)
					.jobPosition(model.getEmployee().getJobPosition())
					.salary(BigDecimal.valueOf(model.getEmployee().getSalary()))
					.build());
			if (model.getEmployee().getUsername() != null) {
				entity.getEmployee().setUsername(Username.builder()
						.employee(entity.getEmployee())
						.username(model.getEmployee().getUsername().getUsername())
						.password(model.getEmployee().getUsername().getPassword())
						.active(model.getEmployee().getUsername().isActive())
						.nonbloqued(model.getEmployee().getUsername().isNonbloqued())
						.tries(model.getEmployee().getUsername().getTries())
						.build());
			}
		}
		return entity;
	}
	
	public PersonModel PersonOut(Person entity) {
		PersonModel model = PersonModel.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.documentType(entity.getDocumentType())
				.documentNumber(entity.getDocumentNumber())
				.email(entity.getEmail())
				.build();
		if (entity.getTelephoneList() != null) {
			model.setTelephone(new ArrayList<>());
			for (Telephone telephone : entity.getTelephoneList()) {
				TelephoneModel telephoneModel = TelephoneModel.builder()
						.id(telephone.getId())
						.type(telephone.getType())
						.indicative(Integer.parseInt(telephone.getIndicative()))
						.extension(Integer.parseInt(telephone.getExtension()))
						.number(BigInteger.valueOf(Long.parseLong(telephone.getNumber())))
						.build();
				model.getTelephone().add(telephoneModel);
			}
		}
		if (entity.getEmployee() != null) {
			model.setEmployee(EmployeeModel.builder()
					.jobPosition(entity.getEmployee().getJobPosition())
					.salary(Double.parseDouble(entity.getEmployee().getSalary().toString()))
					.build());
			if (entity.getEmployee().getUsername() != null) {
				model.getEmployee().setUsername(UsernameModel.builder()
						.username(entity.getEmployee().getUsername().getUsername())
						.password(entity.getEmployee().getUsername().getPassword())
						.active(entity.getEmployee().getUsername().isActive())
						.nonbloqued(entity.getEmployee().getUsername().isNonbloqued())
						.tries(entity.getEmployee().getUsername().getTries())
						.build());
			}
		}
		return model;
	}
	
	public List<PersonModel> PersonOut(List<Person> entityList) {
		List<PersonModel> modelList = new ArrayList<>();
		for (Person entity : entityList) {
			modelList.add(PersonOut(entity));
		}
		return modelList;
	}
	
	public List<PersonModel> PersonOut(Page<Person> entityList) {
		List<PersonModel> modelList = new ArrayList<>();
		for (Person entity : entityList) {
			modelList.add(PersonOut(entity));
		}
		return modelList;
	}
}
