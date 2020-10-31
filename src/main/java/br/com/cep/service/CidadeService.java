package br.com.cep.service;

import java.util.List;

import br.com.cep.dto.CepDTO;

public interface CidadeService {
	
	public List<CepDTO> getCeps(String ibge, String uf);

}
