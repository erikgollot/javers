package org.javers.core.model;

import javax.persistence.Id;

import org.javers.core.metamodel.annotation.DiffIgnore;

public abstract class ShouldUseRegisterAndNotIdObject {
	@Id
	@DiffIgnore
	Long id;
	String businessReference;
	String name;

	public ShouldUseRegisterAndNotIdObject() {

	}

	public ShouldUseRegisterAndNotIdObject(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessReference() {
		return businessReference;
	}

	public void setBusinessReference(String businessReference) {
		this.businessReference = businessReference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
