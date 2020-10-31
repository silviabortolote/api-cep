package br.com.cep.service.rest;

import br.com.cep.dto.ViaCepDTO;

public interface HttpService {
	
	public ViaCepDTO buscarCep (String cep);	

}
