package br.com.cep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cep.dto.CepDTO;
import br.com.cep.model.Cep;
import br.com.cep.service.CepService;
import br.com.cep.service.repository.CepRepository;

@Service
public class CepServiceImpl implements CepService{
	
	private final CepRepository cepRepository;
	
	@Autowired
    public CepServiceImpl(CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }

	@Override
	public CepDTO getCep(String cep) {
		final Cep cetBanco = cepRepository.findByCep(cep);

        if (cetBanco != null) {
           //return Converters.comprovanteConverter().convert(transacoes.get(0));
           return null;
        }

        return null;
	}

}
