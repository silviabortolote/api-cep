package br.com.cep.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ViaCepDTO implements Serializable{
	private static final long serialVersionUID = 6185070746489448543L;

	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	private String ibge;
	
	private String gia;	
	
	private String ddd;	
	
	private String siafi;
	
}
