package uol.compass.sistemapolitico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import uol.compass.sistemapolitico.dto.pedido.AssociaPartidoPedidoDto;
import uol.compass.sistemapolitico.dto.pedido.AssociadoPedidotDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoParametrosResposta;
import uol.compass.sistemapolitico.dto.resposta.AssociadoRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoVinculadoDto;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.services.AssociadoServiceImpl;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    private AssociadoServiceImpl associadoService;

    @PostMapping
    public ResponseEntity<AssociadoRespostaDto> cadastra(@RequestBody @Valid AssociadoPedidotDto pedido) {
        AssociadoRespostaDto resposta = associadoService.cadastra(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
    
    @PostMapping("/partidos")
    public ResponseEntity<AssociadoVinculadoDto> vincula(@RequestBody @Valid AssociaPartidoPedidoDto pedido) {
        AssociadoVinculadoDto resposta = associadoService.vincula(pedido);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @GetMapping
    public ResponseEntity<AssociadoParametrosResposta> lista(@RequestParam(required = false) CargoPolitico cargo,
                        @PageableDefault(sort = {"id"}) Pageable paginacao) {
        AssociadoParametrosResposta resposta = associadoService.listar(cargo, paginacao);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociadoRespostaDto> buscarPorId(@PathVariable("id") Long id) {
        AssociadoRespostaDto resposta = associadoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssociadoRespostaDto> altera(@PathVariable("id") Long id, @RequestBody @Valid AssociadoPedidotDto pedido) {
        AssociadoRespostaDto resposta = associadoService.alterar(id, pedido);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleta(@PathVariable("id") Long id) {
        associadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
