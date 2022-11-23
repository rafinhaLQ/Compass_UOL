package uol.compass.sistemapolitico.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uol.compass.sistemapolitico.dto.request.AssociadoRequestDto;
import uol.compass.sistemapolitico.dto.response.AssociadoResponseDto;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.repository.AssociadoRepository;

@RestController
@RequestMapping("/associados")
public class AssociadoController {
    
    @Autowired
    private AssociadoRepository associadoRepository;
    
    private final ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    @Transactional
    public ResponseEntity<AssociadoResponseDto> cadastra(@RequestBody @Valid AssociadoRequestDto request) {
        
        Associado associadoParaCriar = modelMapper.map(request, Associado.class);
        Associado associadoCriado = associadoRepository.save(associadoParaCriar);

        AssociadoResponseDto response = modelMapper.map(associadoCriado, AssociadoResponseDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    

}
