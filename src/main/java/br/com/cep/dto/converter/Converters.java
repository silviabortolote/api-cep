package br.com.cep.dto.converter;

import br.com.cep.dto.CepDTO;
import br.com.cep.dto.CidadeDTO;
import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;

public final class Converters{
	
	private Converters() {
	}

	public static CepDTO convertCep(Cep input) {
		if (input == null || input.getCep() == null) {
			return null;
		}
		return CepDTO.builder()
		.cep(input.getCep())
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
