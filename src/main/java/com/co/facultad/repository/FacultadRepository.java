package com.co.facultad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.facultad.model.Facultad;

@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Long>{
	
	Facultad getFindById(Long id);
	Facultad findByName(String name);
}
