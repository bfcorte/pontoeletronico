package com.mastertech.pontoeletronico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mastertech.pontoeletronico.Entity.Ponto;
import com.mastertech.pontoeletronico.repository.PontoRepository;

@RestController
public class PontoController {
	
	@Autowired
	PontoRepository pontoRepository;
	
	@PostMapping("/ponto")
	public Ponto ponto(@RequestBody Ponto ponto) {
		
		Ponto pontoCriado = pontoRepository.save(ponto);
		
		return pontoCriado;
	}
	
	

}
