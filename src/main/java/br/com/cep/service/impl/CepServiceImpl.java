package br.com.cep.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cep.dto.converter.Converters;
import br.com.cep.dto.CepDTO;
import br.com.cep.dto.CidadeDTO;
import br.com.cep.dto.ViaCepDTO;
import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;
import br.com.cep.service.CepService;
import br.com.cep.service.repository.CepRepository;
import br.com.cep.service.repository.CidadeRepository;
import br.com.cep.service.rest.HttpService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CepServiceImpl implements CepService{
	
	private final CepRepository cepRepository;
	
	private final CidadeRepository cidadeRepository;
	
	private final HttpService httpService;
	
	@Autowired
    public CepServiceImpl(CepRepository cepRepository, HttpService httpService, CidadeRepository cidadeRepository) {
        this.cepRepository = cepRepository;
        this.httpService = httpService;
        this.cidadeRepository = cidadeRepository;
    }

	@Override
	public CepDTO getCep(String cep) {
		
		final Cep cepBanco = cepRepository.findByCep(cep);
		log.info("cepBanco {} ", cepBanco.getCep());
        if (cepBanco == null) {   
        	final ViaCepDTO viaCep = httpService.buscarCep(cep);
        	viaCep.setCep(cep);
        	CepDTO novo = criarCep(viaCep);
        	return novo;
        }

        return Converters.convertCep(cepBanco);
	}
	
	private CepDTO criarCep(ViaCepDTO viaCep) {
        final Cep cep = new Cep();
        cep.setCep(viaCep.getCep());
        cep.setLogradouro(viaCep.getLogradouro());
        cep.setComplemento(viaCep.getComplemento());
        cep.setBairro(viaCep.getBairro());
        cep.setCidade(criarCidade(viaCep));
        cepRepository.save(cep);
        return Converters.convertCep(cep);
    }
    
    private Cidade criarCidade(ViaCepDTO viaCep) {
        final Cidade opt  = cidadeRepository.findByIbge(viaCep.getIbge());
        if(opt!=null && opt.getIbge()!=null) {
        	log.info("Buscando a cidade {} ", opt.getIbge());
        }else {
        	Cidade nova = new Cidade();
        	nova.setIbge(viaCep.getIbge());
        	nova.setUf(viaCep.getUf());
        	nova.setLocalidade(viaCep.getLocalidade());
            cidadeRepository.save(nova);
            return nova;
        }
        
        return opt;
        
    }

}
