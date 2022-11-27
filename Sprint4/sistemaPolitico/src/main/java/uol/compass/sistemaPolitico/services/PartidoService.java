package uol.compass.sistemapolitico.services;

import org.springframework.data.domain.Pageable;

import uol.compass.sistemapolitico.dto.pedido.PartidoPedidoDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoParametrosRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoParametrosRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoRespostaDto;

public interface PartidoService {

    PartidoRespostaDto cadastra(PartidoPedidoDto pedido);
    
    PartidoParametrosRespostaDto listar(Pageable pagina);
    
    PartidoRespostaDto buscarPorId(Long id);
    
    AssociadoParametrosRespostaDto buscarAssociadosPorPartido(Long id, Pageable pagina);

    PartidoRespostaDto alterar(Long id, PartidoPedidoDto pedido);

    void deletar(Long id);

}
