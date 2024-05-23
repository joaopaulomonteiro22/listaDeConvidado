package br.com.cotiinformatica.domain.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class ConsultarFestaResponseDto {
	private String nome;
	private Date data;

}
