package uol.compass.sistemapolitico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uol.compass.sistemapolitico.dto.pedido.PartidoPedidoDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoParametrosResposta;
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

    @GetMapping
    public ResponseEntity<PartidoParametrosResposta> lista(Pageable pagincao) {
        PartidoParametrosResposta resposta = partidoService.listar(pagincao);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoRespostaDto> buscaPorId(@PathVariable("id") Long id) {
        PartidoRespostaDto resposta = partidoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidoRespostaDto> altera(@PathVariable("id") Long id, @RequestBody @Valid PartidoPedidoDto pedido) {
        PartidoRespostaDto resposta = partidoService.alterar(id, pedido);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

}
