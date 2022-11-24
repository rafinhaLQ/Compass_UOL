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
import uol.compass.sistemapolitico.dto.request.VinculadoRequestDto;
import uol.compass.sistemapolitico.dto.response.AssociadoResponseDto;
import uol.compass.sistemapolitico.dto.response.VinculadoResponseDto;
import uol.compass.sistemapolitico.services.AssociadoServiceImpl;
import uol.compass.sistemapolitico.services.VinculadoService;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    private AssociadoServiceImpl associadoService;

    private VinculadoService vinculadoService;

    @PostMapping
    @Transactional
    public ResponseEntity<AssociadoResponseDto> cadastra(@RequestBody @Valid AssociadoRequestDto request) {
        AssociadoResponseDto response = associadoService.cadastra(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PostMapping("/partidos")
    @Transactional
    public ResponseEntity<VinculadoResponseDto> vincula(@RequestBody @Valid VinculadoRequestDto request) {
        VinculadoResponseDto response = vinculadoService.vincula(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
