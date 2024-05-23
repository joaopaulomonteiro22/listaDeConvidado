package br.com.cotiinformatica.domain.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;
@Data
public class AtualizarFestaResponseDto {
	private UUID id;
	private String nome;
	private Date data;

}
