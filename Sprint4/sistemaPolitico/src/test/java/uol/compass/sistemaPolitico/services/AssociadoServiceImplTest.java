package uol.compass.sistemapolitico.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

import com.jayway.jsonpath.Option;

import uol.compass.sistemapolitico.dto.pedido.AssociaPartidoPedidoDto;
import uol.compass.sistemapolitico.dto.pedido.AssociadoPedidotDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoParametrosRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoVinculadoDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoRespostaDto;
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

    @Mock
    private PartidoServiceImpl partidoService;

    @Test
    void deveriaCriarAssociadoComSucesso() {
        Associado associado = new Associado();
        AssociadoPedidotDto pedido = new AssociadoPedidotDto();
        AssociadoRespostaDto respostaEsperada = new AssociadoRespostaDto();
        
        Mockito.when(modelMapper.map(any(), eq(Associado.class))).thenReturn(associado);
        Mockito.when(associadoRepository.save(any())).thenReturn(associado);
        Mockito.when(modelMapper.map(any(), eq(AssociadoRespostaDto.class))).thenReturn(respostaEsperada);
        
        AssociadoRespostaDto resposta = associadoService.cadastra(pedido);

        assertEquals(respostaEsperada, resposta);
        verify(associadoRepository).save(any());
    }

    @Test
    void deveriaVincularAssociadoAUmPartidoComSucesso() {
        Partido partido = new Partido();
        PartidoRespostaDto partidoDto = new PartidoRespostaDto();

        Associado associadoParaSalvar = new Associado();
        Associado associadoSalvo = new Associado();
        AssociaPartidoPedidoDto pedido = new AssociaPartidoPedidoDto();

        Mockito.when(partidoService.buscarPorId(any())).thenReturn(partidoDto);
        Mockito.when(modelMapper.map(any(), eq(Partido.class))).thenReturn(partido);
        Mockito.when(associadoRepository.findById(any())).thenReturn(Optional.of(associadoParaSalvar));

        Mockito.when(associadoRepository.save(any())).thenReturn(associadoSalvo);
        
        AssociadoVinculadoDto respostaEsperada = new AssociadoVinculadoDto(partido, associadoSalvo);

        AssociadoVinculadoDto resposta = associadoService.vincula(pedido);

        assertEquals(respostaEsperada, resposta);
        verify(associadoRepository).save(any());
    }

    @Test
    void deveriaListarTodosOsAssociadosComSucesso() {
        Associado associado = new Associado();
        AssociadoRespostaDto resposta = new AssociadoRespostaDto();
        Page<Associado> pagina = new PageImpl<>(List.of(associado));
        AssociadoParametrosRespostaDto respostaDeParametrosEsperada = criaRespostaDeParametrosDeAssociados();

        Mockito.when(associadoRepository.findAll((Pageable) any())).thenReturn(pagina);
        Mockito.when(modelMapper.map(any(), eq(AssociadoRespostaDto.class))).thenReturn(resposta);
        
        AssociadoParametrosRespostaDto respostaDeParametros = associadoService.listar(null, any(Pageable.class));

        assertEquals(respostaDeParametrosEsperada, respostaDeParametros);
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

    @Test
    void deveriaAlterarAssociadoComSucesso() {
        Associado associado = new Associado();
        AssociadoRespostaDto respostaEsperada = new AssociadoRespostaDto();
        AssociadoPedidotDto pedido = new AssociadoPedidotDto();

        Mockito.when(associadoRepository.findById(any())).thenReturn(Optional.of(associado));
        Mockito.when(modelMapper.map(any(), eq(Associado.class))).thenReturn(associado);
        Mockito.when(associadoRepository.save(any())).thenReturn(associado);
        Mockito.when(modelMapper.map(any(), eq(AssociadoRespostaDto.class))).thenReturn(respostaEsperada);

        AssociadoRespostaDto resposta = associadoService.alterar(ID, pedido);

        assertEquals(respostaEsperada, resposta);
        verify(associadoRepository).save(any());
    }

    @Test
    void deveriaDeletarAssociadoComSucesso() {
        Associado associado = new Associado();

        Mockito.when(associadoRepository.findById(any())).thenReturn(Optional.of(associado));

        associadoService.deletar(ID);

        verify(associadoRepository).deleteById(any());
    }

    @Test
    void deveriaDesvincularAssociadoComSucesso() {

        Associado associado = new Associado();
        associado.setId(ID);
        Partido partido = new Partido();
        partido.setId(ID);
        associado.setPartidoId(partido);

        Mockito.when(associadoRepository.findById(any())).thenReturn(Optional.of(associado));

        Mockito.when(associadoRepository.save(any())).thenReturn(associado);

        associadoService.desvincula(associado.getId(), partido.getId());

        assertNull(associado.getPartidoId());
        verify(associadoRepository).save(any());

    }

    private AssociadoParametrosRespostaDto criaRespostaDeParametrosDeAssociados() {
        return AssociadoParametrosRespostaDto.builder()
                    .numeroDeElementos(1)
                    .totalDeElementos(1L)
                    .totalDePaginas(1)
                    .associados(List.of(new AssociadoRespostaDto()))
                    .build();
    }

}
