package br.com.cep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Cep> getCeps(String ibge, String uf) {
		
		Cidade cidade;
		
		if(uf!=null) {
			cidade = cidadeRepository.findByIbgeUf(ibge, uf);
		}else {
			cidade = cidadeRepository.findByIbge(ibge);
		}
		
		if(cidade != null) {			
			return cidade.getCeps();
		}
		
		return null;
	}

	


}
