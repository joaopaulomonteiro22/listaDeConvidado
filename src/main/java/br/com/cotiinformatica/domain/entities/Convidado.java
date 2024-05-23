package br.com.cotiinformatica.domain.entities;


import java.util.UUID;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_convidado")
@Data
public class Convidado {
	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "nome", length = 150, nullable = false)
	private String Nome;
	@ManyToOne
	@JoinColumn(name = "festa_id",nullable =  false)
	private Festa festa;
	

}
