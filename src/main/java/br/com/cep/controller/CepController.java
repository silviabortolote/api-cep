package br.com.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cep.dto.CepDTO;
import br.com.cep.service.CepService;

@RestController
public class CepController {
	
	private final CepService cepService;
	
	 @Autowired
    public CepController(CepService cepService){
        this.cepService = cepService;
    }

	@GetMapping("/cep/{cep}")
	public CepDTO findCep(String cep) {
		return cepService.getCep(cep);
	}

}
