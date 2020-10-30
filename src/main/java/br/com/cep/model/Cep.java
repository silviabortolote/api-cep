package br.com.cep.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("unused")
//@Entity
//@Table(name = "TCep")
//implements Serializable
public class Cep {

	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;

	private Cidade cidade;

}
