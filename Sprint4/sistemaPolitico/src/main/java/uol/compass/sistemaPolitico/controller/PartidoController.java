package uol.compass.sistemapolitico.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uol.compass.sistemapolitico.dto.pedido.PartidoPedidoDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoParametrosRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoParametrosRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoRespostaDto;
import uol.compass.sistemapolitico.enums.Ideologia;
import uol.compass.sistemapolitico.services.PartidoServiceImpl;

@RestController
@RequestMapping("/partidos")
@RequiredArgsConstructor
public class PartidoController {
    
    private final PartidoServiceImpl partidoService;

    @PostMapping
    public ResponseEntity<PartidoRespostaDto> cadastra(@RequestBody @Valid PartidoPedidoDto pedido) {
        PartidoRespostaDto resposta = partidoService.cadastra(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<PartidoParametrosRespostaDto> lista(@RequestParam(required = false) Ideologia ideologia, Pageable pagincao) {
        PartidoParametrosRespostaDto resposta = partidoService.listar(ideologia, pagincao);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoRespostaDto> buscaPorId(@PathVariable("id") Long id) {
        PartidoRespostaDto resposta = partidoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @GetMapping("/{id}/associados")
    public ResponseEntity<AssociadoParametrosRespostaDto> listaAssociadosPorPartido(@PathVariable("id") Long id, Pageable paginacao) {
        AssociadoParametrosRespostaDto resposta = partidoService.buscarAssociadosPorPartido(id, paginacao);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidoRespostaDto> altera(@PathVariable("id") Long id, @RequestBody @Valid PartidoPedidoDto pedido) {
        PartidoRespostaDto resposta = partidoService.alterar(id, pedido);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleta(@PathVariable("id") Long id) {
        partidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
