package br.com.cep.dto.converter;

import br.com.cep.dto.CepDTO;
import br.com.cep.dto.CepsDTO;
import br.com.cep.dto.CidadeDTO;
import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;

public final class Converters{
	
	private Converters() {
	}
	
	public static String mascararCep(String cep) {
		return new StringBuilder().append(cep.substring(0, 5)).append("-").append(cep.substring(5,8)).toString(); 
	}

	public static CepDTO convertCep(Cep input) {
		if (input == null || input.getCep() == null) {
			return null;
		}
		return CepDTO.builder()
		.cep(mascararCep(input.getCep()))
		.logradouro(input.getLogradouro())
		.complemento(input.getComplemento())
		.bairro(input.getBairro())
		.cidade(CidadeDTO.builder()
				.ibge(input.getCidade().getIbge())
				.uf(input.getCidade().getUf())
				.localidade(input.getCidade().getLocalidade())
				.build())
		.build();
	}
	
	public static CepsDTO convertCeps(Cep input) {
		if (input == null || input.getCep() == null) {
			return null;
		}
		return CepsDTO.builder()
		.cep(mascararCep(input.getCep()))
		.logradouro(input.getLogradouro())
		.complemento(input.getComplemento())
		.bairro(input.getBairro())
		.build();
	}
	
	public static CidadeDTO convertCidade(Cidade input) {
		if (input == null || input.getIbge() == null) {
			return null;
		}
		return CidadeDTO.builder()
		.ibge(input.getIbge())
		.uf(input.getUf())
		.localidade(input.getLocalidade())
		.build();
	}

}
