package br.com.cep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

	@GetMapping("/cep")
	public String findCep() {
		return "Olá mundo para Silvia!";
	}

}
