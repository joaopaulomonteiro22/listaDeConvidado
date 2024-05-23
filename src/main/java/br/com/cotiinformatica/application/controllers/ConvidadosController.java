package br.com.cotiinformatica.application.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.dtos.AtualizarConvidadoRequestDto;
import br.com.cotiinformatica.domain.dtos.AtualizarConvidadoResponseDto;
import br.com.cotiinformatica.domain.dtos.AtualizarFestaRequestDto;
import br.com.cotiinformatica.domain.dtos.AtualizarFestaResponseDto;
import br.com.cotiinformatica.domain.dtos.ConsultarConvidadoResponseDto;
import br.com.cotiinformatica.domain.dtos.CriarConvidadoRequestDto;
import br.com.cotiinformatica.domain.dtos.CriarConvidadoResponseDto;
import br.com.cotiinformatica.domain.entities.Convidado;
import br.com.cotiinformatica.domain.entities.Festa;
import br.com.cotiinformatica.domain.services.ConvidadoDomainService;
import br.com.cotiinformatica.infrastructure.repositores.ConvidadoRepository;
import br.com.cotiinformatica.infrastructure.repositores.FestaRepository;

@RestController
@RequestMapping(value = "/api/convidados")
public class ConvidadosController {
	@Autowired
	private ConvidadoRepository convidadoRepository;
	@Autowired
	private ConvidadoDomainService convidadoDomainService;
	@Autowired
	private FestaRepository festaRepository;

	@Autowired
	private ModelMapper mapper;

	@PostMapping("Criar")
	public ResponseEntity<CriarConvidadoResponseDto> criar(@RequestParam("nome") String nome,
			@RequestParam("festaId") UUID festaId

	) throws Exception {
		CriarConvidadoRequestDto dto = new CriarConvidadoRequestDto();
		dto.setNome(nome);
		dto.setFestaId(festaId);
		CriarConvidadoResponseDto response = convidadoDomainService.criarConvidado(dto);

		return ResponseEntity.status(201).body(response);
	}
	
	@PutMapping("atualizar")
	public ResponseEntity<AtualizarConvidadoResponseDto> atualizar(
	        @RequestParam("id") UUID id,
	        @RequestParam("nome") String nome,
	        @RequestParam("festaId") UUID festaId) {
	    Optional<Festa> festaOptional = festaRepository.findById(festaId);
	    Optional<Convidado> convidadoOptional = convidadoRepository.findById(id);
	    if (convidadoOptional.isEmpty()) {
	    	  return ResponseEntity.notFound().build();
			
		}
	    if (festaOptional.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	   else {

			   AtualizarConvidadoRequestDto dto = new AtualizarConvidadoRequestDto();
			   	dto.setId(id);
			   	dto.setNome(nome);
			   	dto.setFestaId(festaId);
			   	AtualizarConvidadoResponseDto response = convidadoDomainService.atualizarConvidado(dto);

			    return ResponseEntity.status(201).body(response);
		}

	   
	   
	    
	

	    
	}

	

	@GetMapping("consultar")
	public  List<ConsultarConvidadoResponseDto>consultar() {
		return convidadoDomainService.consultarConvidados();
		

	}
	@GetMapping("obter/{id}")
	public ConsultarConvidadoResponseDto obter(@PathVariable("id") UUID id) {
		return  convidadoDomainService.consultarPorId(id);
	}
	@DeleteMapping("apagar/{id}")
	public ResponseEntity<Void>  apagar(@PathVariable("id") UUID id){
		Optional<Convidado> convidadoOpitional = convidadoRepository.findById(id);
		if (convidadoOpitional.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		}else {
			convidadoRepository.deleteById(id);
			
		}
		
		
		
		return ResponseEntity.noContent().build();
		
		
		 
		
	}
	

}
