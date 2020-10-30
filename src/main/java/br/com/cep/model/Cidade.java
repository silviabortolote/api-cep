package br.com.cep.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("unused")
//@Entity
//@Table(name = "TCidade")
//implements Serializable
public class Cidade {
  
  private String ibge;
  
  private String uf;
  
  private String localidade;
  
  private List<Cep> ceps; 
  
}
