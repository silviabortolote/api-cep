package br.com.cep.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.cep.dto.CepDTO;
import br.com.cep.model.Cep;
import br.com.cep.service.CepService;
import br.com.cep.service.CidadeService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class CepController {
	
	private final CepService cepService;
	
	private final CidadeService cidadeService;
	
	 @Autowired
    public CepController(CepService cepService, CidadeService cidadeService){
        this.cepService = cepService;
        this.cidadeService = cidadeService;
    }

	@GetMapping("/cep/{cep}")
	public CepDTO findCep(@PathVariable String cep) {
		log.info("Request cep: {}",cep);
		return cepService.getCep(cep);
	}
	
	@GetMapping("/ceps")
	public List<Cep> findCep(@Valid String ibge, @Valid String uf) {
		log.info("Request ibge: {}",ibge);
		log.info("Request uf: {}",uf);
		
		cidadeService.getCeps(ibge, uf);
		
		return null;
	}

}
