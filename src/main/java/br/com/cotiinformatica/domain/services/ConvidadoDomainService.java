package br.com.cotiinformatica.domain.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.dtos.AtualizarConvidadoRequestDto;
import br.com.cotiinformatica.domain.dtos.AtualizarConvidadoResponseDto;
import br.com.cotiinformatica.domain.dtos.ConsultarConvidadoResponseDto;
import br.com.cotiinformatica.domain.dtos.CriarConvidadoRequestDto;
import br.com.cotiinformatica.domain.dtos.CriarConvidadoResponseDto;
import br.com.cotiinformatica.domain.entities.Convidado;
import br.com.cotiinformatica.domain.entities.Festa;
import br.com.cotiinformatica.infrastructure.repositores.ConvidadoRepository;
import br.com.cotiinformatica.infrastructure.repositores.FestaRepository;
@Service
public class ConvidadoDomainService implements br.com.cotiinformatica.domain.interfaces.ConvidadoDomainService {
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private FestaRepository festaRepository;

	
	
	@Override
	public CriarConvidadoResponseDto criarConvidado(CriarConvidadoRequestDto dto) {
				
		if(!festaRepository.existsById(dto.getFestaId())) {
			throw new IllegalArgumentException("Festa não encontrada!");
			
			
			
		}
		Convidado convidado = new Convidado();
		convidado.setId(UUID.randomUUID());
		convidado.setNome(dto.getNome());	
		convidado.setFesta(festaRepository.findById(dto.getFestaId())
                .orElseThrow(() -> new IllegalArgumentException("Festa não encontrada.")));
		convidadoRepository.save(convidado);
		
			CriarConvidadoResponseDto response = new CriarConvidadoResponseDto();
			response.setId(convidado.getId());
			response.setNome(convidado.getNome());
			response.setFestaId(convidado.getFesta().getId());
			
			
		return response;
	}
	@Override
	public ConsultarConvidadoResponseDto consultarPorId(UUID id) {
		Optional<Convidado> convidado = convidadoRepository.findById(id);
		if(convidado.isPresent()) {
			
			ConsultarConvidadoResponseDto response = modelMapper.map(convidado, ConsultarConvidadoResponseDto.class);
			response.setFestaId(convidado.get().getFesta().getId());
			return response;
			}
		else {
			return null;
		}
		
		
		
				
	}
	@Override
	public  List<ConsultarConvidadoResponseDto> consultarConvidados() {
		 	List<Convidado> convidados = convidadoRepository.findAll();
		 	List<ConsultarConvidadoResponseDto> response =  convidados.stream().map(convidado ->{
		 		
		 		ConsultarConvidadoResponseDto dto = new ConsultarConvidadoResponseDto();
		 		dto.setNome(convidado.getNome());
		 		dto.setFestaId(convidado.getFesta().getId());
		 		return dto;
		 		
		 		
		 		
		 	}).collect(Collectors.toList());
		 	
		
		return response;
	}
	@Override
	public AtualizarConvidadoResponseDto atualizarConvidado(AtualizarConvidadoRequestDto dto) {
			Convidado convidado =  new Convidado();
			convidado.setId(dto.getId());
			convidado.setNome(dto.getNome());
			 // Recupere a instância correta da Festa com base no UUID fornecido
		    Optional<Festa> festa = festaRepository.findById(dto.getFestaId());
		    
		    
		    
		    convidado.setFesta(festa.get());
		    
		    convidadoRepository.save(convidado);
		    AtualizarConvidadoResponseDto response = modelMapper.map(convidado, AtualizarConvidadoResponseDto.class);
		    response.setFestaId(convidado.getFesta().getId());
		    
		    
		    
		    
		    
		    
			
		
		return response;
	}
	
	
	

}
