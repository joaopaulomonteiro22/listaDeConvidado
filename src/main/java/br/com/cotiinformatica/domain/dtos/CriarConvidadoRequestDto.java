package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class CriarConvidadoRequestDto {
	@Size(min = 8, max = 150, message = "Por favor, informe o nome de 8 a 150 caracteres.")
	@NotEmpty(message = "Por favor, informe o nome do convidado.")
	private String nome;
	@Size(min = 5, max = 150, message = "Por favor, informe a festa")
	private UUID festaId;

}
