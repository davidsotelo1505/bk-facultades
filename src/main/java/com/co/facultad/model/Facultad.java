package com.co.facultad.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "SAA_FACULTAD")
public class Facultad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4147854639913972622L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	Long id;
	@Column
	String name;
	@Column
	String location;

	public Facultad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facultad(Long id, String name, String ubicacion) {
		super();
		this.id = id;
		this.name = name;
		this.location = ubicacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUbicacion() {
		return location;
	}

	public void setUbicacion(String ubicacion) {
		this.location = ubicacion;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
