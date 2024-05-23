package br.com.cotiinformatica.infrastructure.repositores;



import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.domain.entities.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, UUID> {

}
