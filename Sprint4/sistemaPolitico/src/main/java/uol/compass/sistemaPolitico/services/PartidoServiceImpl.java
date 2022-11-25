package uol.compass.sistemapolitico.services;

import org.springframework.data.domain.Pageable;

import uol.compass.sistemapolitico.dto.pedido.PartidoPedidoDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoParametrosResposta;
import uol.compass.sistemapolitico.dto.resposta.PartidoRespostaDto;

public class PartidoServiceImpl implements PartidoService {

    @Override
    public PartidoRespostaDto cadastra(PartidoPedidoDto pedido) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PartidoParametrosResposta listar(Pageable pagina) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PartidoRespostaDto buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PartidoParametrosResposta buscarAssociadosPorPartido(Long id, Pageable pagina) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PartidoRespostaDto alterar(Long id, PartidoPedidoDto pedido) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        
    }

}
