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
		
        if (cepBanco != null) {
           return Converters.convertCep(cepBanco);        		
        }else {
        	log.info("Request via cep: {}",cep);
        	final ViaCepDTO viaCep = httpService.buscarCep(cep);
        	criarCep(viaCep);
        	log.info("Resposta via cep: {}", viaCep.getComplemento());
        }

        return null;
	}
	
	private CepDTO criarCep(ViaCepDTO viaCep) {
        final Cep cep = new Cep();
        cep.setCep(viaCep.getCep());
        cep.setLogradouro(viaCep.getLogradouro());
        cep.setComplemento(viaCep.getComplemento());
        cep.setBairro(viaCep.getBairro());
        //Cidade
        //cepRepository.save(cep);
        log.info("Criado o cep ",cep.getCep());
        return Converters.convertCep(cep);
    }
    
    private CidadeDTO criarCidade(ViaCepDTO viaCep) {
    	log.info("Buscando pela cidade de ibge ->>>> ", viaCep.getIbge());
        final Cidade opt  = cidadeRepository.findByIbge(viaCep.getIbge());
        if(opt!=null) {
        	log.info("Buscando a cidade ", opt.getIbge());
        }else {
        	log.info("Cidade não encontrada!!! ");
        }
        
        /*if (cidade!=null) {
        	cidade = new Cidade();
        	cidade.setIbge(viaCep.getIbge());
        	cidade.setUf(viaCep.getUf());
        	cidade.setLocalidade(viaCep.getLocalidade());
            cidadeRepository.save(cidade);
        }*/
        //return Converters.convertCidade(cidade);
        return null;
        
    }

}
