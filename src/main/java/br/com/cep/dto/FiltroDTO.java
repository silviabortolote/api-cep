package br.com.cep.dto;

import java.io.Serializable;
import java.util.List;

import br.com.cep.model.Cep;
import lombok.Builder;
import lombok.Data;

@SuppressWarnings("unused")
@Data
@Builder
public class FiltroDTO {

	private String ibge;
	  
	private String uf;

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
	
}
