package com.co.facultad.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.facultad.model.Docente;
import com.co.facultad.model.service.DocenteService;
import com.co.facultad.util.GeneralResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "adminuser", description = "Operaciones correspondientes a la gestión de docentes de la plataformas Universidad Libre")
@RestController
@RequestMapping("/docentes")
public class DocenteController {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DocenteService docenteService;

	@ApiOperation(value = "Registrar un docente en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<GeneralResponse<Docente>> saveDocente(@RequestBody Docente docente) {
		GeneralResponse<Docente> response = new GeneralResponse<>();
		HttpStatus status = HttpStatus.OK;
		try {

			Docente docenteSaved = docenteService.save(docente);
			// response.setData(userSaved);
			response.setSuccess(true);
			response.setMessage("Docente guardado exitosamente");
			status = HttpStatus.OK;

		} catch (Exception e) {

			status = HttpStatus.BAD_REQUEST;
			response.setSuccess(false);
			response.setMessage("Docente ya existe");

		}
		return new ResponseEntity<GeneralResponse<Docente>>(response, status);

	}

	@ApiOperation(value = "Mostrtar los docentes en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Docente> getDocenteList() throws Exception {
		return docenteService.findAll();
	}

	@ApiOperation(value = "BUscar por id en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Docente> getDocenteById(@PathVariable(name = "id") Long id) throws Exception {
		Docente docente = docenteService.getFindById(id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Docente>(docente, status);
	}

}
