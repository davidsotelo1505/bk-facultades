package com.co.facultad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.facultad.model.Bloque;

@Repository
public interface BloqueRepository extends JpaRepository<Bloque, Long> {
	
	Bloque findByName(String name);
	Bloque getFindById(Long id);
	

}
