package br.com.cep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cep.dto.converter.Converters;
import br.com.cep.dto.CepDTO;
import br.com.cep.dto.ViaCepDTO;
import br.com.cep.model.Cep;
import br.com.cep.service.CepService;
import br.com.cep.service.repository.CepRepository;
import br.com.cep.service.rest.HttpService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CepServiceImpl implements CepService{
	
	private final CepRepository cepRepository;
	
	private final HttpService httpService;
	
	@Autowired
    public CepServiceImpl(CepRepository cepRepository, HttpService httpService) {
        this.cepRepository = cepRepository;
        this.httpService = httpService;
    }

	@Override
	public CepDTO getCep(String cep) {
		
		final Cep cepBanco = cepRepository.findByCep(cep);
		
        if (cepBanco != null) {
           return Converters.convertCep(cepBanco);        		
        }else {
        	log.info("Request via cep: {}",cep);
        	final ViaCepDTO viaCep = httpService.buscarCep(cep);
        	log.info("Resposta via cep: {}", viaCep.getComplemento());
        }

        return null;
	}

}
