package com.co.facultad.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.facultad.model.Laboratorio;
import com.co.facultad.repository.LaboratorioRepository;


@Service(value = "laboratorioService")
public class LaboratorioServiceImpl implements LaboratorioService {

	
	final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LaboratorioRepository laboratorioRepository;	
	
	@Override
	public List<Laboratorio> findAll() throws Exception {
		List<Laboratorio> laboratorioList = new ArrayList<>();
		laboratorioList = laboratorioRepository.findAll();
		return laboratorioList;
	}

	@Override
	public Laboratorio save(Laboratorio laboratorio) throws Exception {
		Laboratorio laboratorioFind = laboratorioRepository.findByName(laboratorio.getName());
		try {
			if (null == laboratorioFind) {
				laboratorioRepository.save(laboratorio);
				return laboratorio;
			} else {
				throw new ServiceException("Laboratorio ya existe");
			}

		} catch (Exception e) {
			log.info("Laboratorio ya existe");
			if (e instanceof ServiceException) {
				throw e;
			} else {
				throw new ServiceException("ocurrio un error al guardar");
			}
		}
	}

	@Override
	public Laboratorio getFindById(Long id) throws Exception {
		Laboratorio laboratorio = laboratorioRepository.getFindById(id);
		return laboratorio;
	}

}
