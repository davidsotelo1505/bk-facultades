package com.co.facultad.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.facultad.model.Asignatura;

import com.co.facultad.repository.AsignaturaRepository;

@Service(value = "asignaturaService")
public class AsignaturaServiceImpl implements AsignaturaService {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Override
	public List<Asignatura> findAll() throws Exception {
		List<Asignatura> asignaturaList = new ArrayList<>();
		asignaturaList = asignaturaRepository.findAll();
		return asignaturaList;
	}

	@Override
	public Asignatura save(Asignatura asignatura) throws Exception {
		Asignatura asignaturaFind = asignaturaRepository.findByName(asignatura.getName());
		try {
			if (null == asignaturaFind) {
				asignaturaRepository.save(asignatura);
				return asignatura;
			} else {
				throw new ServiceException("La asignatura ya existe");
			}

		} catch (Exception e) {
			log.info("La asignatura ya existe");
			if (e instanceof ServiceException) {
				throw e;
			} else {
				throw new ServiceException("ocurrio un error al guardar");
			}
		}
	}

	@Override
	public Asignatura getFindById(Long id) throws Exception {
		Asignatura asignatura = asignaturaRepository.getFindById(id);
		return asignatura;
	}

}
