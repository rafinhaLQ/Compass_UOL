package uol.compass.sistemapolitico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uol.compass.sistemapolitico.dto.pedido.AssociaPartidoPedidoDto;
import uol.compass.sistemapolitico.dto.pedido.AssociadoPedidotDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoRespostaDto;

public interface AssociadoService {
    
    AssociadoRespostaDto cadastra(AssociadoPedidotDto pedido);

    AssociadoRespostaDto vincula(AssociaPartidoPedidoDto pedido);

    Page<AssociadoRespostaDto> listar(Pageable pageable);
    
    AssociadoRespostaDto buscarPorId(Long id);
    
    AssociadoRespostaDto alterar(Long id, AssociadoPedidotDto pedido);
    
    void deletar(Long id);
    
}
