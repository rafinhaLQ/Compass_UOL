package uol.compass.sistemapolitico.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import uol.compass.sistemapolitico.dto.pedido.AssociaPartidoPedidoDto;
import uol.compass.sistemapolitico.dto.pedido.AssociadoPedidotDto;
import uol.compass.sistemapolitico.dto.resposta.AssociaPartidoRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoRespostaDto;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.repository.AssociadoRepository;
import uol.compass.sistemapolitico.repository.PartidoRepository;

@ExtendWith(MockitoExtension.class)
public class AssociadoServiceImplTest {

    public static final Long ID = 1L;
    
    @InjectMocks
    private AssociadoServiceImpl associadoService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private AssociadoRepository associadoRepository;

    @Mock
    private PartidoRepository partidoRepository;

    @Test
    void deveriaCriarAssociadoComSucesso() {
        Associado paraCriar = new Associado();
        Associado criado = new Associado();
        AssociadoRespostaDto respostaEsperada = new AssociadoRespostaDto();
        AssociadoPedidotDto pedido = Mockito.mock(AssociadoPedidotDto.class);
        
        Mockito.when(modelMapper.map(pedido, Associado.class)).thenReturn(paraCriar);
        Mockito.when(associadoRepository.save(paraCriar)).thenReturn(criado);
        
        Mockito.when(modelMapper.map(criado, AssociadoRespostaDto.class)).thenReturn(respostaEsperada);

        AssociadoRespostaDto resposta = associadoService.cadastra(pedido);

        assertEquals(respostaEsperada, resposta);
        verify(associadoRepository).save(any());
    }

    @Test
    void deveriaVincularAssociadoAUmPartidoComSucesso() {
        Associado associadoParaCriar = Mockito.mock(Associado.class);
        Associado associadoCriado = new Associado();
        AssociaPartidoRespostaDto respostaEsperada = new AssociaPartidoRespostaDto();
        AssociaPartidoPedidoDto pedido = Mockito.mock(AssociaPartidoPedidoDto.class);

        Partido partidoParaCriar = Mockito.mock(Partido.class);
        Partido partidoCriado = new Partido();

        Mockito.when(associadoRepository.getReferenceById(pedido.getIdAssociado())).thenReturn(associadoParaCriar);
        Mockito.when(partidoRepository.getReferenceById(pedido.getIdPartido())).thenReturn(partidoParaCriar);

        associadoParaCriar.setPartido(partidoParaCriar);
        partidoParaCriar.getAssociados().add(associadoCriado);

        Mockito.when(associadoRepository.save(associadoParaCriar)).thenReturn(associadoCriado);
        Mockito.when(partidoRepository.save(partidoParaCriar)).thenReturn(partidoCriado);
        
        respostaEsperada.setAssociado(associadoCriado);
        respostaEsperada.setPartido(partidoCriado);

        AssociaPartidoRespostaDto resposta = associadoService.vincula(pedido);

        assertEquals(respostaEsperada, resposta);
        verify(associadoRepository).save(any());
        verify(partidoRepository).save(any());
    }

    @Test
    void deveriaListarTodosOsAssociadosComSucesso() {
        Associado associado = new Associado();
        AssociadoRespostaDto resposta = new AssociadoRespostaDto();
        Page<Associado> paginaAssociado = new PageImpl<>(List.of(associado));
        Page<AssociadoRespostaDto> paginaEsperada = new PageImpl<>(List.of(resposta));

        Mockito.when(associadoRepository.findAll((Pageable) any())).thenReturn(paginaAssociado);
        
        paginaAssociado.map(AssociadoRespostaDto::new);
        
        Page<AssociadoRespostaDto> pagina = associadoService.listar(any(Pageable.class));

        assertEquals(paginaEsperada, pagina);
    }

    @Test
    void deveriaBuscarPorIdComSucesso() {
        Associado associado = new Associado();
        AssociadoRespostaDto respostaEsperada = new AssociadoRespostaDto();

        Mockito.when(associadoRepository.findById(any())).thenReturn(Optional.of(associado));
        Mockito.when(modelMapper.map(any(), eq(AssociadoRespostaDto.class))).thenReturn(respostaEsperada);

        AssociadoRespostaDto resposta = associadoService.buscarPorId(ID);

        assertEquals(respostaEsperada, resposta);
    }

}
