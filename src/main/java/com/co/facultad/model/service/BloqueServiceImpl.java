package com.co.facultad.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.facultad.model.Bloque;
import com.co.facultad.repository.BloqueRepository;

@Service(value = "bloqueService")
public class BloqueServiceImpl implements BloqueService {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BloqueRepository bloqueRepository;

	@Override
	public List<Bloque> findAll() throws Exception {
		List<Bloque> bloqueList = new ArrayList<>();
		bloqueList = bloqueRepository.findAll();
		return bloqueList;
	}

	@Override
	public Bloque save(Bloque bloque) throws Exception {
		Bloque bloqueFind = bloqueRepository.findByName(bloque.getName());
		try {
			if (null == bloqueFind) {
				bloqueRepository.save(bloque);
				return bloque;
			} else {
				throw new ServiceException("El bloque ya existe");
			}

		} catch (Exception e) {
			log.info("El bloque ya existe");
			if (e instanceof ServiceException) {
				throw e;
			} else {
				throw new ServiceException("ocurrio un error al guardar");
			}
		}
	}

	@Override
	public Bloque getFindById(Long id) throws Exception {
		Bloque bloque = bloqueRepository.getFindById(id);
		return bloque;
	}

}
