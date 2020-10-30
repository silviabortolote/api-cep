package br.com.cep.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "TCep")
public class Cep implements Serializable{
	
	private static final long serialVersionUID = 8969561498226838037L;

	@Id
	@Column(name = "CEP", nullable = false, unique = true)
	private String cep;

	@Column(name = "LOGRADOURO")
	private String logradouro;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "CIDADE")
	private Cidade cidade;

}
