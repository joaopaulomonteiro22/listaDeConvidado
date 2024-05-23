 package br.com.cotiinformatica.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.dtos.AtualizarFestaRequestDto;
import br.com.cotiinformatica.domain.dtos.AtualizarFestaResponseDto;
import br.com.cotiinformatica.domain.dtos.ConsultarFestaResponseDto;
import br.com.cotiinformatica.domain.dtos.CriarFestaRequestDto;
import br.com.cotiinformatica.domain.dtos.CriarFestaResponseDto;
import br.com.cotiinformatica.domain.entities.Festa;
import br.com.cotiinformatica.infrastructure.repositores.FestaRepository;

@Service
public class FestaDomainService implements br.com.cotiinformatica.domain.interfaces.FestaDomainService {

	@Autowired
	private FestaRepository festaRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CriarFestaResponseDto criarFesta(CriarFestaRequestDto dto) {

		Festa festa = modelMapper.map(dto, Festa.class);
		festa.setId(UUID.randomUUID());
		festaRepository.save(festa);

		CriarFestaResponseDto response = modelMapper.map(festa, CriarFestaResponseDto.class);

		return response;

	}
	@Override
	public AtualizarFestaResponseDto Atualizarfesta(AtualizarFestaRequestDto dto) {
		
		Festa festa = modelMapper.map(dto, Festa.class);
		festaRepository.save(festa);
		AtualizarFestaResponseDto response = modelMapper.map(festa, AtualizarFestaResponseDto.class);
		
		
		
		
		return response ;
	}
	@Override
	public List<ConsultarFestaResponseDto> consultarFestas() {
		 List<Festa> festas = festaRepository.findAll();
		 
		 List<ConsultarFestaResponseDto> response = modelMapper.map(festas, new TypeToken<List<ConsultarFestaResponseDto>>() {}.getType());
		 
		return response;
	}
	@Override
	public ConsultarFestaResponseDto consultarPorId(UUID id) {
			Optional<Festa> festa = festaRepository.findById(id);
			if(festa.isPresent()) {
				
				ConsultarFestaResponseDto response = modelMapper.map(festa, ConsultarFestaResponseDto.class);
				return response;
				}
			else {
				return null;
			}
			
	}

	
	




}
