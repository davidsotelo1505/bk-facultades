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

import com.co.facultad.model.Bloque;
import com.co.facultad.model.service.BloqueService;
import com.co.facultad.util.GeneralResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "adminuser", description = "Operaciones correspondientes a la gestión de bloques de la plataformas Universidad Libre")
@RestController
@RequestMapping("/bloques")
public class BloqueController {
	
	final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BloqueService bloqueService;
	
	@ApiOperation(value = "Registrar un bloque en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<GeneralResponse<Bloque>> saveBloque(@RequestBody Bloque bloque) {
		GeneralResponse<Bloque> response = new GeneralResponse<>();
		HttpStatus status = HttpStatus.OK;
		try {

			Bloque bloqueSaved = bloqueService.save(bloque);
			// response.setData(userSaved);
			response.setSuccess(true);
			response.setMessage("Bloque guardada exitosamente");
			status = HttpStatus.OK;

		} catch (Exception e) {

			status = HttpStatus.BAD_REQUEST;
			response.setSuccess(false);
			response.setMessage("Bloque ya existe");

		}
		return new ResponseEntity<GeneralResponse<Bloque>>(response, status);

	}

	@ApiOperation(value = "Mostrtar los bloques en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Bloque> getBloqueList() throws Exception {
		return bloqueService.findAll();
	}
	
	@ApiOperation(value = "BUscar por id en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Bloque> getBloqueById(@PathVariable(name = "id")Long id) throws Exception {
		Bloque bloque =bloqueService.getFindById(id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Bloque>(bloque, status);
	}

}
