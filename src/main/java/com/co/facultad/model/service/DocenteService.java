package com.co.facultad.model.service;

import java.util.List;


import com.co.facultad.model.Docente;

public interface DocenteService {
	
	
	List<Docente> findAll() throws Exception;

	Docente save(Docente docente) throws Exception;

	Docente getFindById(Long id) throws Exception;

}
