package com.co.facultad.model.service;

import java.util.List;

import com.co.facultad.model.Bloque;


public interface BloqueService {
	List<Bloque> findAll() throws Exception;

	Bloque save(Bloque bloque) throws Exception;

	Bloque getFindById(Long id) throws Exception;
}
