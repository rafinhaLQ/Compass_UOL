package uol.compass.sistemapolitico.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uol.compass.sistemapolitico.dto.pedido.AssociadoRequestDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoResponseDto;
import uol.compass.sistemapolitico.services.AssociadoServiceImpl;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    private AssociadoServiceImpl associadoService;

    @PostMapping
    @Transactional
    public ResponseEntity<AssociadoResponseDto> cadastra(@RequestBody @Valid AssociadoRequestDto request) {
        AssociadoResponseDto response = associadoService.cadastra(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}
