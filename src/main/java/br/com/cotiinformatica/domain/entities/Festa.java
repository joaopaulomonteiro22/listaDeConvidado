package br.com.cotiinformatica.domain.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@Entity
@Table( name ="tbl_festa")
@Data
public class Festa {
	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "nome" ,length = 150, nullable = false)
	private String Nome;
	@Temporal(TemporalType.DATE)
	@Column(name = "datafesta", nullable = false)
	private Date data;
	@OneToMany(mappedBy = "festa")
	private List<Convidado> convidados;
	

}
