package br.com.cotiinformatica.domain.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarFestaRequestDto {
	@Size(min = 8, max = 150, message = "Por favor, informe o nome de 8 a 150 caracteres.")
	@NotEmpty(message = "Por favor, informe o nome do convidado.")
	private String nome;
	@Size(min = 5, max = 18, message = "Por favor, informe a data.")
	@NotBlank(message = "O preenchimento é obrigatório.")
	private Date data;

}
