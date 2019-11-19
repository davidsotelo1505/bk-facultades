package com.co.facultad.model.service;

import java.util.List;

import com.co.facultad.model.Laboratorio;

public interface LaboratorioService {
	List<Laboratorio> findAll() throws Exception;

	Laboratorio save(Laboratorio laboratorio) throws Exception;

	Laboratorio getFindById(Long id) throws Exception;
}
