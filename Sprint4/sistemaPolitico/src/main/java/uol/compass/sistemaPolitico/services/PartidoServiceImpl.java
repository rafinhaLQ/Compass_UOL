package uol.compass.sistemapolitico.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uol.compass.sistemapolitico.dto.pedido.PartidoPedidoDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoParametrosResposta;
import uol.compass.sistemapolitico.dto.resposta.PartidoParametrosResposta;
import uol.compass.sistemapolitico.dto.resposta.PartidoRespostaDto;
import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.excecoes.PartidoNaoEncontradoException;
import uol.compass.sistemapolitico.repository.PartidoRepository;

@Service
public class PartidoServiceImpl implements PartidoService {

    private ModelMapper modelMapper;

    private PartidoRepository partidoRepository;

    private AssociadoServiceImpl associadoService;

    @Autowired
    public PartidoServiceImpl(ModelMapper modelMapper, PartidoRepository partidoRepository,
           @org.springframework.context.annotation.Lazy AssociadoServiceImpl associadoService) {
        this.modelMapper = modelMapper;
        this.partidoRepository = partidoRepository;
        this.associadoService = associadoService;
    }

    @Override
    public PartidoRespostaDto cadastra(PartidoPedidoDto pedido) {
        Partido paraCriar = modelMapper.map(pedido, Partido.class);
        Partido criado = partidoRepository.save(paraCriar);

        return modelMapper.map(criado, PartidoRespostaDto.class);
    }

    @Override
    public PartidoParametrosResposta listar(Pageable paginacao) {
        Page<Partido> pagina = partidoRepository.findAll(paginacao);

        return criaParametrosDeRespostaDePartidos(pagina);
    }

    @Override
    public PartidoRespostaDto buscarPorId(Long id) {
        Partido resposta = getPartido(id);

        return modelMapper.map(resposta, PartidoRespostaDto.class);
    }

    @Override
    public AssociadoParametrosResposta buscarAssociadosPorPartido(Long id, Pageable pagina) {
        Partido partido = getPartido(id);

        return associadoService.listarPorPartido(partido, pagina);
    }

    @Override
    public PartidoRespostaDto alterar(Long id, PartidoPedidoDto pedido) {
        getPartido(id);

        Partido partidoParaAlterar = modelMapper.map(pedido, Partido.class);
        partidoParaAlterar.setId(id);
        Partido partidoAlterado = partidoRepository.save(partidoParaAlterar);

        return modelMapper.map(partidoAlterado, PartidoRespostaDto.class);
    }

    @Override
    public void deletar(Long id) {
        getPartido(id);
        partidoRepository.deleteById(id);
    }

    private PartidoParametrosResposta criaParametrosDeRespostaDePartidos(Page<Partido> pagina) {
        List<PartidoRespostaDto> partidos = pagina.stream()
                                .map(this::criaRespostaDePartidos)
                                .collect(Collectors.toList());
        
        return PartidoParametrosResposta.builder()
                                    .numeroDeElementos(pagina.getNumberOfElements())
                                    .totalDeElementos(pagina.getTotalElements())
                                    .totalDePaginas(pagina.getTotalPages())
                                    .partidos(partidos)
                                    .build();
    }

    private PartidoRespostaDto criaRespostaDePartidos(Partido partido) {
        return modelMapper.map(partido, PartidoRespostaDto.class);
    }

    private Partido getPartido(Long id) {
        return partidoRepository.findById(id)
                    .orElseThrow(PartidoNaoEncontradoException::new);
    }

}
