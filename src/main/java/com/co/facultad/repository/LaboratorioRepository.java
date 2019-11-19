package com.co.facultad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.facultad.model.Laboratorio;

@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {
	
	Laboratorio findByName(String name);
	Laboratorio getFindById(Long id);

}
