package uol.compass.sistemapolitico.services;

import org.springframework.data.domain.Pageable;

import uol.compass.sistemapolitico.dto.pedido.AssociaPartidoPedidoDto;
import uol.compass.sistemapolitico.dto.pedido.AssociadoPedidotDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoParametrosResposta;
import uol.compass.sistemapolitico.dto.resposta.AssociadoRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoVinculadoDto;

public interface AssociadoService {
    
    AssociadoRespostaDto cadastra(AssociadoPedidotDto pedido);

    PartidoVinculadoDto vincula(AssociaPartidoPedidoDto pedido);

    AssociadoParametrosResposta listar(Pageable pagina);
    
    AssociadoRespostaDto buscarPorId(Long id);
    
    AssociadoRespostaDto alterar(Long id, AssociadoPedidotDto pedido);
    
    void deletar(Long id);

    void desvincula(Long id_associado, Long id_partido);
    
}
