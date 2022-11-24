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
import uol.compass.sistemapolitico.dto.request.AssociadoVinculadoRequestDto;
import uol.compass.sistemapolitico.dto.response.AssociadoResponseDto;
import uol.compass.sistemapolitico.dto.response.AssociadoVinculadoResponseDto;
import uol.compass.sistemapolitico.entities.Associado;
import uol.compass.sistemapolitico.entities.AssociadoVinculado;
import uol.compass.sistemapolitico.repository.AssociadoRepository;
import uol.compass.sistemapolitico.repository.AssociadoVinculadoRepository;

@RestController
@RequestMapping("/associados")
public class AssociadoController {
    
    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private AssociadoVinculadoRepository associadoVinculadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AssociadoResponseDto> cadastra(@RequestBody @Valid AssociadoRequestDto request) {
        Associado paraCriar = request.converterParaAssociado();
        Associado criado = associadoRepository.save(paraCriar);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AssociadoResponseDto(criado));
    }
    
    @PostMapping("/partidos")
    @Transactional
    public ResponseEntity<AssociadoVinculadoResponseDto> vincula(@RequestBody @Valid AssociadoVinculadoRequestDto request) {
        AssociadoVinculado paraCriar = request.converterParaAssociadoVinculado();
        AssociadoVinculado criado = associadoVinculadoRepository.save(paraCriar);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AssociadoVinculadoResponseDto(criado));
    }
}
