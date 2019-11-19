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

import com.co.facultad.model.Asignatura;

import com.co.facultad.model.service.AsignaturaService;

import com.co.facultad.util.GeneralResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "adminuser", description = "Operaciones correspondientes a la gestión de asignaturas de la plataformas Universidad Libre")
@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AsignaturaService asignaturaService;

	@ApiOperation(value = "Registrar una asignatura en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<GeneralResponse<Asignatura>> saveFacultad(@RequestBody Asignatura asignatura) {
		GeneralResponse<Asignatura> response = new GeneralResponse<>();
		HttpStatus status = HttpStatus.OK;
		try {

			Asignatura asignaturaSaved = asignaturaService.save(asignatura);
			// response.setData(userSaved);
			response.setSuccess(true);
			response.setMessage("Asignatura guardada exitosamente");
			status = HttpStatus.OK;

		} catch (Exception e) {

			status = HttpStatus.BAD_REQUEST;
			response.setSuccess(false);
			response.setMessage("Asignatura ya existe");

		}
		return new ResponseEntity<GeneralResponse<Asignatura>>(response, status);

	}

	@ApiOperation(value = "Mostrtar las Asignatura en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Asignatura> getFacultadList() throws Exception {
		return asignaturaService.findAll();
	}

	@ApiOperation(value = "BUscar por id en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Asignatura> getUserById(@PathVariable(name = "id") Long id) throws Exception {
		Asignatura asignatura = asignaturaService.getFindById(id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Asignatura>(asignatura, status);
	}

}
