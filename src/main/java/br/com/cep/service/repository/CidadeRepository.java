package br.com.cep.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cep.model.Cidade;

public interface CidadeRepository  extends JpaRepository<Cidade, String>{
	
	@Query("select c from Cidade c where c.ibge = ?1")
	Cidade findByIbge(String ibge);
	

}


