package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class AtualizarConvidadoRequestDto {
	@Size(min = 8, message = "não existe convidado aqui.")
	private UUID id;
	@Size(min = 8, message = "Por favor, informe pelo menos 8 caracteres.")
	private String nome;
	@Size(min = 5, max = 150, message = "Por favor, informe a festa")
	private UUID festaId;
	

}
