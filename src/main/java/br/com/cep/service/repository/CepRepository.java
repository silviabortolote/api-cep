package br.com.cep.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;

public interface CepRepository  extends JpaRepository<Cep, String>{
	
	@Query("select c from Cep c where c.cep = ?1")
	Cep findByCep(String cep);

}


