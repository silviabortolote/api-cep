package br.com.cep.dto;

import java.io.Serializable;
import java.util.List;

import br.com.cep.model.Cep;

@SuppressWarnings("unused")
public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 6185070746485945653L;

	private String ibge;
	  
	private String uf;
	  
	private String localidade;
	  
	private List<CepDTO> ceps; 
	
}
