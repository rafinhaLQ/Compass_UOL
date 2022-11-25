package uol.compass.sistemapolitico.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uol.compass.sistemapolitico.dto.pedido.AssociaPartidoPedidoDto;
import uol.compass.sistemapolitico.dto.pedido.AssociadoPedidotDto;
import uol.compass.sistemapolitico.dto.resposta.AssociaPartidoRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoRespostaDto;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.excecoes.AssociadoNaoEncontradoException;
import uol.compass.sistemapolitico.repository.AssociadoRepository;
import uol.compass.sistemapolitico.repository.PartidoRepository;

@Service
@RequiredArgsConstructor
public class AssociadoServiceImpl implements AssociadoService {

    private final ModelMapper modelMapper;

    private final AssociadoRepository associadoRepository;

    private final PartidoRepository partidoRepository;

    @Override
    public AssociadoRespostaDto cadastra(AssociadoPedidotDto pedido) {
        Associado paraCriar = modelMapper.map(pedido, Associado.class);
        Associado criado = associadoRepository.save(paraCriar);

        return modelMapper.map(criado, AssociadoRespostaDto.class);
    }

    @Override
    public AssociaPartidoRespostaDto vincula(AssociaPartidoPedidoDto pedido) {
        AssociaPartidoRespostaDto resposta = new AssociaPartidoRespostaDto();

        Associado associadoParaCriar = associadoRepository.getReferenceById(pedido.getIdAssociado());
        Partido partidoParaCriar = partidoRepository.getReferenceById(pedido.getIdPartido());

        // Criar erro para caso não encontre associado ou partido

        associadoParaCriar.setPartido(partidoParaCriar);
        partidoParaCriar.getAssociados().add(associadoParaCriar);

        Associado associadoCriado = associadoRepository.save(associadoParaCriar);
        Partido partidoCriado = partidoRepository.save(partidoParaCriar);

        resposta.setAssociado(associadoCriado);
        resposta.setPartido(partidoCriado);

        return resposta;
    }

    @Override
    public Page<AssociadoRespostaDto> listar(Pageable paginacao) {        
        Page<Associado> associados = associadoRepository.findAll(paginacao);
        Page<AssociadoRespostaDto> resposta = associados.map(AssociadoRespostaDto::new);

        return resposta;
    }

    @Override
    public AssociadoRespostaDto buscarPorId(Long id) {
        Associado resposta = getAssociado(id);

        return modelMapper.map(resposta, AssociadoRespostaDto.class);
    }

    @Override
    public AssociadoRespostaDto alterar(Long id, AssociadoPedidotDto request) {
        getAssociado(id);

        Associado associadoParaAlterar = modelMapper.map(request, Associado.class);
        associadoParaAlterar.setId(id);
        Associado associadoAlterado = associadoRepository.save(associadoParaAlterar);

        return modelMapper.map(associadoAlterado, AssociadoRespostaDto.class);
    }

    @Override
    public void deletar(Long id) {
        getAssociado(id);
        associadoRepository.deleteById(id);
    }

    private Associado getAssociado(Long id) {
        return associadoRepository.findById(id).orElseThrow(AssociadoNaoEncontradoException::new);
    }

}
