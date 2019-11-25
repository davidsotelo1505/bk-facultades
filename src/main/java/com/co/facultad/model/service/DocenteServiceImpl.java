package com.co.facultad.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.facultad.model.Docente;
import com.co.facultad.repository.DocenteRepository;

@Service(value = "docenteService")
public class DocenteServiceImpl implements DocenteService {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DocenteRepository docenteRepository;

	@Override
	public List<Docente> findAll() throws Exception {
		List<Docente> docenteList = new ArrayList<>();
		docenteList = docenteRepository.findAll();
		return docenteList;
	}

	@Override
	public Docente save(Docente docente) throws Exception {
		Docente docenteFind = docenteRepository.findByName(docente.getName());
		try {
			if (null == docenteFind) {
				docenteRepository.save(docente);
				return docente;
			} else {
				throw new ServiceException("El docente ya existe");
			}

		} catch (Exception e) {
			log.info("El docente ya existe");
			if (e instanceof ServiceException) {
				throw e;
			} else {
				throw new ServiceException("ocurrio un error al guardar");
			}
		}
	}

	@Override
	public Docente getFindById(Long id) throws Exception {
		Docente docente = docenteRepository.getFindById(id);
		return docente;
	}

}
