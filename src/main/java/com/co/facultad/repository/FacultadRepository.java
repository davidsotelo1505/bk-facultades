package com.co.facultad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.facultad.model.Facultad;

public interface FacultadRepository extends JpaRepository<Facultad, Long>{
	
	Facultad getFindById(Long id);
	Facultad findByName(String name);
}
