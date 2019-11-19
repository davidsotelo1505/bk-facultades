package com.co.facultad.model.service;

import java.util.List;

import com.co.facultad.model.Asignatura;


public interface AsignaturaService {

	List<Asignatura> findAll() throws Exception;
	
	Asignatura save(Asignatura asignatura) throws Exception;
	
	Asignatura getFindById(Long id) throws Exception;
}
