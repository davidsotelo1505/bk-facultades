package com.co.facultad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.facultad.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

	Docente findByName(String name);
	Docente getFindById(Long id);
	
}
