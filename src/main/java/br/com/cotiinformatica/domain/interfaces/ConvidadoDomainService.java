package br.com.cotiinformatica.domain.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.AtualizarConvidadoRequestDto;
import br.com.cotiinformatica.domain.dtos.AtualizarConvidadoResponseDto;
import br.com.cotiinformatica.domain.dtos.AtualizarFestaResponseDto;
import br.com.cotiinformatica.domain.dtos.ConsultarConvidadoResponseDto;
import br.com.cotiinformatica.domain.dtos.CriarConvidadoRequestDto;
import br.com.cotiinformatica.domain.dtos.CriarConvidadoResponseDto;

public interface ConvidadoDomainService {
	CriarConvidadoResponseDto criarConvidado(CriarConvidadoRequestDto dto);

	ConsultarConvidadoResponseDto consultarPorId(UUID id);

	List<ConsultarConvidadoResponseDto> consultarConvidados();
	
	AtualizarConvidadoResponseDto atualizarConvidado(AtualizarConvidadoRequestDto dto);
	

}
