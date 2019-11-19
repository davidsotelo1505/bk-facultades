package com.co.facultad.model.service;

import java.util.List;

import com.co.facultad.model.Facultad;

public interface FacultadService {
	
	List<Facultad> findAll() throws Exception;
	
	Facultad save(Facultad facultad) throws Exception;
	
	Facultad getFindById(Long id) throws Exception;
	
}
