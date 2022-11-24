package uol.compass.sistemapolitico.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uol.compass.sistemapolitico.dto.pedido.AssociaPartidoPedidoDto;
import uol.compass.sistemapolitico.dto.pedido.AssociadoPedidotDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoRespostaDto;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.repository.AssociadoRepository;

@Service
@RequiredArgsConstructor
public class AssociadoServiceImpl implements AssociadoService {

    private final ModelMapper modelMapper;

    private final AssociadoRepository associadoRepository;

    @Override
    public AssociadoRespostaDto cadastra(AssociadoPedidotDto pedido) {
        Associado paraCriar = modelMapper.map(pedido, Associado.class);
        Associado criado = associadoRepository.save(paraCriar);
        AssociadoRespostaDto resposta = modelMapper.map(criado, AssociadoRespostaDto.class);

        return resposta;
    }

    @Override
    public AssociadoRespostaDto vincula(AssociaPartidoPedidoDto pedido) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<AssociadoRespostaDto> listar(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssociadoRespostaDto buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssociadoRespostaDto alterar(Long id, AssociadoPedidotDto request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        
    }

}
