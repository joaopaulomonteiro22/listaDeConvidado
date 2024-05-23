package br.com.cotiinformatica.domain.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.AtualizarFestaRequestDto;
import br.com.cotiinformatica.domain.dtos.AtualizarFestaResponseDto;
import br.com.cotiinformatica.domain.dtos.ConsultarFestaResponseDto;
import br.com.cotiinformatica.domain.dtos.CriarFestaRequestDto;
import br.com.cotiinformatica.domain.dtos.CriarFestaResponseDto;

public interface FestaDomainService {

	CriarFestaResponseDto criarFesta(CriarFestaRequestDto dto);

	AtualizarFestaResponseDto Atualizarfesta(AtualizarFestaRequestDto dto);

	List<ConsultarFestaResponseDto> consultarFestas();

	ConsultarFestaResponseDto consultarPorId(UUID id);

}
