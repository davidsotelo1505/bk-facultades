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
@Table(name = "SAA_LABORATORIO")
public class Laboratorio implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1584722724706839411L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(name = "laboratory_seq", sequenceName = "laboratory_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laboratory_seq")
	Long id;
	
	@Column
	String name;
	
	

	public Laboratorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laboratorio(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}
