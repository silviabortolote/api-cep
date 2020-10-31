package br.com.cep.service;

import java.util.List;

import br.com.cep.dto.CepsDTO;

public interface CidadeService {
	
	public List<CepsDTO> getCeps(String ibge, String uf);

}
