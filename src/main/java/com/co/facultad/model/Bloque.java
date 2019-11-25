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
@Table(name = "SAA_BLOQUE")
public class Bloque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931865316037408382L;
	

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(name = "bloque_seq", sequenceName = "bloque_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bloque_seq")
	Long id;
	@Column
	String name;
	
	
	
	public Bloque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bloque(Long id, String name) {
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
