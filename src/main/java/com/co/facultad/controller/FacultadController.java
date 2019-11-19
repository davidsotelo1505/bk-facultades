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

import com.co.facultad.model.Facultad;
import com.co.facultad.model.service.FacultadService;
import com.co.facultad.util.GeneralResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "adminuser", description = "Operaciones correspondientes a la gestión de facultades de la plataformas Universidad Libre")
@RestController
@RequestMapping("/facultades")
public class FacultadController {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FacultadService facultadService;

	@ApiOperation(value = "Registrar un Usuario en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<GeneralResponse<Facultad>> saveUser(@RequestBody Facultad facultad) {
		GeneralResponse<Facultad> response = new GeneralResponse<>();
		HttpStatus status = HttpStatus.OK;
		try {

			Facultad userSaved = facultadService.save(facultad);
			// response.setData(userSaved);
			response.setSuccess(true);
			response.setMessage("Facultad guardada exitosamente");
			status = HttpStatus.OK;

		} catch (Exception e) {

			status = HttpStatus.BAD_REQUEST;
			response.setSuccess(false);
			response.setMessage("facultad ya existe");

		}
		return new ResponseEntity<GeneralResponse<Facultad>>(response, status);

	}

	@ApiOperation(value = "Mostrtar las facultades en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Facultad> getFacultadList() throws Exception {
		return facultadService.findAll();
	}
	
	@ApiOperation(value = "BUscar por id en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Facultad> getUserById(@PathVariable(name = "id")Long id) throws Exception {
		Facultad facultad =facultadService.getFindById(id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Facultad>(facultad, status);
	}
}
