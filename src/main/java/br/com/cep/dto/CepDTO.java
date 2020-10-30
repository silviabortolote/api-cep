package br.com.cep.dto;

import java.io.Serializable;

import br.com.cep.model.Cidade;
import lombok.Builder;
import lombok.Data;

@SuppressWarnings("unused")
@Data
@Builder
public class CepDTO implements Serializable{
	private static final long serialVersionUID = 6185070746485945643L;

	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;

	private CidadeDTO cidade;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}	

}
