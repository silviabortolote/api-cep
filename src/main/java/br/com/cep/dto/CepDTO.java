package br.com.cep.dto;

import java.io.Serializable;

import br.com.cep.model.Cidade;

@SuppressWarnings("unused")
public class CepDTO implements Serializable{
	private static final long serialVersionUID = 6185070746485945643L;

	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;

	private CidadeDTO cidade;

}
