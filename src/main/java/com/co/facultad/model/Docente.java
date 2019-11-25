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
@Table(name = "SAA_DOCENTE")
public class Docente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5321465389707694501L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(name = "docente_seq", sequenceName = "docente_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docente_seq")
	Long id;
	@Column
	String name;
	
	
	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Docente(Long id, String name) {
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
