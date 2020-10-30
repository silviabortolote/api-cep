package br.com.cep.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("unused")

@Entity
@Table(name = "TCidade")
public class Cidade implements Serializable{
	
	private static final long serialVersionUID = 8969561498226838845L;
  
	@Id
	@Column(name = "IBGE", nullable = false, unique = true)
	private String ibge;
  
	@Column(name = "UF")
	private String uf;
  
	@Column(name = "LOCALIDADE")
 	private String localidade;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "IBGE")
	private List<Cep> ceps;

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

	public List<Cep> getCeps() {
		return ceps;
	}

	public void setCeps(List<Cep> ceps) {
		this.ceps = ceps;
	} 
}
