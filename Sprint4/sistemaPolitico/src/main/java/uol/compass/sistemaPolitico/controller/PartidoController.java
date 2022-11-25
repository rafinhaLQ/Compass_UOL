package uol.compass.sistemapolitico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uol.compass.sistemapolitico.dto.pedido.PartidoPedidoDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoRespostaDto;
import uol.compass.sistemapolitico.services.PartidoServiceImpl;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
    
    @Autowired
    private PartidoServiceImpl partidoService;

    @PostMapping
    public ResponseEntity<PartidoRespostaDto> cadastra(@RequestBody @Valid PartidoPedidoDto pedido) {
        PartidoRespostaDto resposta = partidoService.cadastra(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

}
