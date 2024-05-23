package br.com.cotiinformatica.domain.dtos;



import java.util.UUID;

import lombok.Data;
@Data
public class ConsultarConvidadoResponseDto {
	private String nome;
	private UUID festaId;

}
