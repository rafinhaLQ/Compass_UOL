package uol.compass.sistemapolitico.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uol.compass.sistemapolitico.dto.pedido.AssociaPartidoPedidoDto;
import uol.compass.sistemapolitico.dto.pedido.AssociadoPedidotDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoParametrosRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoVinculadoDto;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.excecoes.AssociadoNaoEncontradoException;
import uol.compass.sistemapolitico.repository.AssociadoRepository;
import uol.compass.sistemapolitico.repository.PartidoRepository;

@Service
@RequiredArgsConstructor
public class AssociadoServiceImpl implements AssociadoService {

    private final ModelMapper modelMapper;

    private final AssociadoRepository associadoRepository;

    private final PartidoRepository partidoRepository;

    private final PartidoServiceImpl partidoService;

    @Override
    public AssociadoRespostaDto cadastra(AssociadoPedidotDto pedido) {
        Associado paraCriar = modelMapper.map(pedido, Associado.class);
        Associado criado = associadoRepository.save(paraCriar);

        return modelMapper.map(criado, AssociadoRespostaDto.class);
    }

    @Override
    public AssociadoVinculadoDto vincula(AssociaPartidoPedidoDto pedido) {
        getAssociado(pedido.getIdAssociado());
        Partido partidoParaVincular = modelMapper.map(partidoService.buscarPorId(pedido.getIdPartido()), Partido.class);
        
        Associado associado = getAssociado(pedido.getIdAssociado());

        partidoParaVincular.getAssociados().add(associado);
        partidoParaVincular.getAssociados().forEach(associadoNaLista -> associadoNaLista.setPartidoId(partidoParaVincular));

        Partido partidoVinculado = partidoRepository.save(partidoParaVincular);

        return new AssociadoVinculadoDto(partidoVinculado, associado);
    }

    @Override
    public AssociadoParametrosRespostaDto listar(CargoPolitico cargo, Pageable paginacao) {        
        Page<Associado> pagina = cargo == null ?
                    associadoRepository.findAll(paginacao) :
                    associadoRepository.findAllByCargoPolitico(cargo, paginacao);

        return criarParametrosDeRespostaDeAssociados(pagina);
    }

    @Override
    public AssociadoRespostaDto buscarPorId(Long id) {
        Associado resposta = getAssociado(id);

        return modelMapper.map(resposta, AssociadoRespostaDto.class);
    }

    @Override
    public AssociadoRespostaDto alterar(Long id, AssociadoPedidotDto pedido) {
        getAssociado(id);

        Associado associadoParaAlterar = modelMapper.map(pedido, Associado.class);
        associadoParaAlterar.setId(id);
        Associado associadoAlterado = associadoRepository.save(associadoParaAlterar);

        return modelMapper.map(associadoAlterado, AssociadoRespostaDto.class);
    }

    @Override
    public void deletar(Long id) {
        getAssociado(id);
        associadoRepository.deleteById(id);
    }

    @Override
    public void desvincula(Long idAssociado, Long idPartido) {
        Partido partido = modelMapper.map(partidoService.buscarPorId(idPartido),
                    Partido.class);
        Associado associado = getAssociado(idAssociado);

        associado.setPartidoId(null);
        partido.getAssociados().remove(associado);

        partidoRepository.save(partido);
    }

    public AssociadoParametrosRespostaDto listarPorPartido(Partido partido, Pageable paginacao) {
        Page<Associado> pagina = associadoRepository.findAllByPartidoId(partido, paginacao);

        return criarParametrosDeRespostaDeAssociados(pagina);
    }

    private Associado getAssociado(Long id) {
        return associadoRepository.findById(id)
                    .orElseThrow(AssociadoNaoEncontradoException::new);
    }

    private AssociadoParametrosRespostaDto criarParametrosDeRespostaDeAssociados(Page<Associado> pagina) {
        List<AssociadoRespostaDto> associados = pagina.stream()
                                .map(this::criaRespostaDeAssociados)
                                .collect(Collectors.toList());

        return AssociadoParametrosRespostaDto.builder()
                                .numeroDeElementos(pagina.getNumberOfElements())
                                .totalDeElementos(pagina.getTotalElements())
                                .totalDePaginas(pagina.getTotalPages())
                                .associados(associados)
                                .build();
    }

    private AssociadoRespostaDto criaRespostaDeAssociados(Associado associado) {
        return modelMapper.map(associado, AssociadoRespostaDto.class);
    }

}
