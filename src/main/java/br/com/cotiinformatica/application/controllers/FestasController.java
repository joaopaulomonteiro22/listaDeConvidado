package br.com.cotiinformatica.application.controllers;


import java.util.Date;
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

import br.com.cotiinformatica.domain.dtos.AtualizarFestaRequestDto;
import br.com.cotiinformatica.domain.dtos.AtualizarFestaResponseDto;
import br.com.cotiinformatica.domain.dtos.ConsultarFestaResponseDto;
import br.com.cotiinformatica.domain.dtos.CriarFestaRequestDto;
import br.com.cotiinformatica.domain.dtos.CriarFestaResponseDto;
import br.com.cotiinformatica.domain.entities.Festa;
import br.com.cotiinformatica.domain.interfaces.FestaDomainService;
import br.com.cotiinformatica.infrastructure.repositores.FestaRepository;

@RestController
@RequestMapping(value = "/api/festas")
public class FestasController {
	@Autowired
	private FestaDomainService festaDomainService;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private FestaRepository festaRepository;
	@Autowired
	Optional<Festa> festa;
	
	
	@PostMapping("criar")
 public ResponseEntity<CriarFestaResponseDto> criar( @RequestParam("nome") String nome,
		 											@RequestParam("data")	Date data			
		 ) throws Exception {
			CriarFestaRequestDto dto = new CriarFestaRequestDto();
			dto.setNome(nome);
			dto.setData(data);
			festaDomainService.criarFesta(dto);
			
			CriarFestaResponseDto response =  	festaDomainService.criarFesta(dto);
			
			
			
				
		
		
		
		return ResponseEntity.status(201).body(response);
		
	 
	 
 }
	
	

	@PutMapping("atualizar")
	public ResponseEntity<AtualizarFestaResponseDto> atualizar(
	        @RequestParam("id") UUID id,
	        @RequestParam("nome") String nome,
	        @RequestParam("data") Date data) {
	    Optional<Festa> festaOptional = festaRepository.findById(id);

	    if (festaOptional.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }

	    Festa festa = festaOptional.get(); // Extrai o objeto Festa do Optional

	    // Define o nome e a data da festa com os valores fornecidos
	    festa.setNome(nome);
	    festa.setData(data);
	    AtualizarFestaRequestDto dto = new AtualizarFestaRequestDto();
	    dto.setId(id);
	    dto.setNome(festa.getNome());
	    dto.setData(festa.getData());
	    
	    AtualizarFestaResponseDto response = festaDomainService.Atualizarfesta(dto);
	

	    return ResponseEntity.status(201).body(response);
	}
	
	
	@GetMapping("consultar")
	public List<ConsultarFestaResponseDto> consultar() {
		return festaDomainService.consultarFestas();
		
			
	}
	@GetMapping("obter/{id}")
	public ConsultarFestaResponseDto consultarId(@PathVariable("id") UUID id) {
		return festaDomainService.consultarPorId(id);
		
		
		
	}

	
	@DeleteMapping("apagar/{id}")
	public ResponseEntity<Void>  apagar(@PathVariable("id") UUID id){
		Optional<Festa> festaOptional = festaRepository.findById(id);
		
		if (festaOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		}else {
			festaRepository.deleteById(id);
			
		}
		
		
		
		return ResponseEntity.noContent().build();
		
		
	
		
		
		
	}
 
	

}
