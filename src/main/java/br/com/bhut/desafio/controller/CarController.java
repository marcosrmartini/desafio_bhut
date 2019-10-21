package br.com.bhut.desafio.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bhut.desafio.model.Log;
import br.com.bhut.desafio.payload.CarPayload;
import br.com.bhut.desafio.service.CarService;

@RestController
@RequestMapping("/api")
public class CarController {

	private static final Logger log = Logger.getLogger(CarController.class);

	@Autowired
	private CarService service;

	@GetMapping("/listCars")
	public ResponseEntity<List<CarPayload>> listagem() {
		List<CarPayload> response = new ArrayList();
		try {
			response = service.listagem();
			if (response.isEmpty()) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.ok().body(response);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/createCar")
	public ResponseEntity<CarPayload> salvar(@RequestBody CarPayload car) {
		CarPayload response = new CarPayload();
		try {
			response = service.salvar(car);
			if (response.get_id().isEmpty()) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.ok().body(response);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.notFound().build();
		
	}

	@GetMapping("/log")
	public ResponseEntity<List<Log>> log() {
		List<Log> response = new ArrayList();
		try {
			response = service.log();
			if (response.isEmpty()) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.ok().body(response);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.notFound().build();
	}

}
