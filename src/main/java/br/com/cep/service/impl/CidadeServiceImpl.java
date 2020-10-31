package br.com.cep.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cep.dto.CepDTO;
import br.com.cep.dto.converter.Converters;
import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;
import br.com.cep.service.CidadeService;
import br.com.cep.service.repository.CidadeRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CidadeServiceImpl implements CidadeService{
	
	private final CidadeRepository cidadeRepository;
	
	@Autowired
    public CidadeServiceImpl( CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

	@Override
	public List<CepDTO> getCeps(String ibge, String uf) {
		
		Cidade cidade;
		
		if(uf!=null) {
			cidade = cidadeRepository.findByIbgeUf(ibge, uf);
		}else {
			cidade = cidadeRepository.findByIbge(ibge);
		}
		
		if(cidade != null) {
			
			List<CepDTO> list = new ArrayList<CepDTO>(); 
						
			for ( Cep cep : cidade.getCeps()) {
				log.info("Cep {} ", cep.getCep());
				list.add(Converters.convertCep(cep));				
			}
			
			return list;
		}
		
		return null;
	}

	


}
