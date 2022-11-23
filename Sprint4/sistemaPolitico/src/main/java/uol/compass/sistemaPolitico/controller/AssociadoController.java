package uol.compass.sistemapolitico.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import uol.compass.sistemapolitico.dto.request.AssociadoRequestDto;
import uol.compass.sistemapolitico.dto.response.AssociadoResponseDto;
import uol.compass.sistemapolitico.repository.AssociadoRepository;

@RestController
@RequestMapping("/associados")
public class AssociadoController {
    
    @Autowired
    private AssociadoRepository associadoRepository;
    
    @PostMapping
    @Transactional
    public ResponseEntity<AssociadoResponseDto> cadastra(@RequestBody @Valid AssociadoRequestDto request, UriComponentsBuilder uri) {
        
    }
    

}
