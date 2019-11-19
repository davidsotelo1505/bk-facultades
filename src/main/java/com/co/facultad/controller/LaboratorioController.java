package com.co.facultad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.facultad.model.Laboratorio;

import com.co.facultad.model.service.LaboratorioService;
import com.co.facultad.util.GeneralResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "adminUniversity", description = "Operaciones correspondientes a la gestión de laboratorios de la plataformas Universidad Libre")
@RestController
@RequestMapping("/laboratorios")
public class LaboratorioController {

	@Autowired
	private LaboratorioService laboratorioService;

	@ApiOperation(value = "Registrar un Usuario en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<GeneralResponse<Laboratorio>> saveLaboratorio(@RequestBody Laboratorio laboratorio) {
		GeneralResponse<Laboratorio> response = new GeneralResponse<>();
		HttpStatus status = HttpStatus.OK;
		try {

			Laboratorio laboratorioSaved = laboratorioService.save(laboratorio);
			// response.setData(userSaved);
			response.setSuccess(true);
			response.setMessage("Laboratoio guardado exitosamente");
			status = HttpStatus.OK;

		} catch (Exception e) {

			status = HttpStatus.BAD_REQUEST;
			response.setSuccess(false);
			response.setMessage("Laboratoio ya existe");

		}
		return new ResponseEntity<GeneralResponse<Laboratorio>>(response, status);

	}

	@ApiOperation(value = "Mostrtar los laboratorios en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Laboratorio> getLaboratorioList() throws Exception {
		return laboratorioService.findAll();
	}

	@ApiOperation(value = "BUscar por id en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Laboratorio> getUserById(@PathVariable(name = "id") Long id) throws Exception {
		Laboratorio laboratorio = laboratorioService.getFindById(id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Laboratorio>(laboratorio, status);
	}

}
