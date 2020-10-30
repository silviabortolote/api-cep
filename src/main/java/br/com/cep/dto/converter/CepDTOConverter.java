package br.com.cep.dto.converter;

import br.com.cep.dto.CepDTO;
import br.com.cep.dto.CidadeDTO;
import br.com.cep.model.Cep;

public class CepDTOConverter implements DTOConverter<Cep, CepDTO>{

	@Override
	public CepDTO convert(Cep input) {
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

}
