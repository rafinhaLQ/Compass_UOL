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

import uol.compass.sistemapolitico.dto.pedido.AssociadoPedidotDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoRespostaDto;
import uol.compass.sistemapolitico.services.AssociadoServiceImpl;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    private AssociadoServiceImpl associadoService;

    @PostMapping
    @Transactional
    public ResponseEntity<AssociadoRespostaDto> cadastra(@RequestBody @Valid AssociadoPedidotDto request) {
        AssociadoRespostaDto response = associadoService.cadastra(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}
