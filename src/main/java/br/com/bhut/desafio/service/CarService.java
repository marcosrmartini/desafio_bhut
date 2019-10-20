package br.com.bhut.desafio.service;

import java.util.List;

import br.com.bhut.desafio.model.Log;
import br.com.bhut.desafio.payload.CarPayload;

public interface CarService {
	
	public List<CarPayload> listagem();
	public CarPayload salvar(CarPayload employees);
	public List<Log> log();

}
