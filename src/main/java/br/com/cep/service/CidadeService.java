package br.com.cep.service;

import java.util.List;

import br.com.cep.model.Cep;


public interface CidadeService {
	
	public List<Cep> getCeps(String ibge, String uf);

}
