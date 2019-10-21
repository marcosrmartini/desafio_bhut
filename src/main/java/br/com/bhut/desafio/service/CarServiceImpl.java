package br.com.bhut.desafio.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import br.com.bhut.desafio.model.Log;
import br.com.bhut.desafio.payload.CarPayload;
import br.com.bhut.desafio.repository.LogRepository;
import br.com.bhut.desafio.service.utils.HeaderRequestInterceptor;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private LogRepository logRepository;

	private final String ENDPOINT = "http://157.230.213.199:3000/api/cars";

	@Override
	public List<CarPayload> listagem() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));

		restTemplate.setInterceptors(interceptors);
		
		ResponseEntity<List<CarPayload>> response = restTemplate.exchange(ENDPOINT,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<CarPayload>>() {
				});
		
		return response.getBody();
	}

	@Override
	public CarPayload salvar(CarPayload car) {
		RestTemplate restTemplate = new RestTemplate();
		
		CarPayload response = restTemplate.postForObject(
		  ENDPOINT,
		  car,
		  CarPayload.class);
		
		Log log = new Log();
		log.setIdCar(response.get_id());
		log.setData(new Date());
		
		logRepository.save(log);
		
		return response;
	}

	@Override
	@GetMapping("/log")
	public List<Log> log() {
		return logRepository.findAll();
	}

}
