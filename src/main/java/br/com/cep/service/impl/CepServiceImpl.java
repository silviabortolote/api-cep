package br.com.cep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cep.dto.converter.Converters;
import br.com.cep.dto.CepDTO;
import br.com.cep.model.Cep;
import br.com.cep.service.CepService;
import br.com.cep.service.repository.CepRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CepServiceImpl implements CepService{
	
	private final CepRepository cepRepository;
	
	@Autowired
    public CepServiceImpl(CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }

	@Override
	public CepDTO getCep(String cep) {
		
		final Cep cepBanco = cepRepository.findByCep(cep);
		
        if (cepBanco != null) {
           return Converters.convertCep(cepBanco);        		
        }

        return null;
	}

}
