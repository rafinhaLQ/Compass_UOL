package uol.compass.sistemapolitico.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uol.compass.sistemapolitico.dto.pedido.PartidoPedidoDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoParametrosResposta;
import uol.compass.sistemapolitico.dto.resposta.PartidoRespostaDto;
import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.repository.PartidoRepository;

@Service
@RequiredArgsConstructor
public class PartidoServiceImpl implements PartidoService {

    private final ModelMapper modelMapper;

    private final PartidoRepository partidoRepository;

    @Override
    public PartidoRespostaDto cadastra(PartidoPedidoDto pedido) {
        Partido paraCriar = modelMapper.map(pedido, Partido.class);
        Partido criado = partidoRepository.save(paraCriar);

        return modelMapper.map(criado, PartidoRespostaDto.class);
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
