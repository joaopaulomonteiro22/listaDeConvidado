package br.com.cotiinformatica.infrastructure.repositores;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.domain.entities.Festa;


public interface FestaRepository extends JpaRepository<Festa, UUID> {
	
	@Query("select f from Festa f where f.id = :pId")
	Festa findById(@Param("pId") String email);



}
