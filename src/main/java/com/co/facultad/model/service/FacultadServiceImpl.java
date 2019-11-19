package com.co.facultad.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.facultad.model.Facultad;
import com.co.facultad.repository.FacultadRepository;

@Service(value = "facultadService")
public class FacultadServiceImpl implements FacultadService {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FacultadRepository facultadRepository;

	@Override
	public List<Facultad> findAll() throws Exception {
		List<Facultad> facultadList = new ArrayList<>();
		facultadList = facultadRepository.findAll();
		return facultadList;
	}

	@Override
	public Facultad save(Facultad facultad) throws Exception {
		facultad = facultadRepository.findByName(facultad.getName());
		try {
			if (null == facultad) {
				facultadRepository.save(facultad);
				return facultad;
			} else {
				throw new ServiceException("La facultad ya existe");
			}

		} catch (Exception e) {
			log.info("La facultad ya existe");
			if (e instanceof ServiceException) {
				throw e;
			} else {
				throw new ServiceException("ocurrio un error al guardar");
			}
		}
	}

	@Override
	public Facultad getFindById(Long id) throws Exception {
		Facultad facultad = facultadRepository.getFindById(id);
		return facultad;
	}
}
