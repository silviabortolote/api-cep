package br.com.cep.dto;

import java.io.Serializable;
import java.util.List;

import br.com.cep.model.Cep;
import lombok.Builder;
import lombok.Data;

@SuppressWarnings("unused")
@Data
@Builder
public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 6185070746485945653L;

	private String ibge;
	  
	private String uf;
	  
	private String localidade;
	  
	private List<CepDTO> ceps;

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public List<CepDTO> getCeps() {
		return ceps;
	}

	public void setCeps(List<CepDTO> ceps) {
		this.ceps = ceps;
	} 
	
}
