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

import uol.compass.sistemapolitico.dto.pedido.PartidoPedidoDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoParametrosRespostaDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoRespostaDto;
import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.repository.PartidoRepository;

@ExtendWith(MockitoExtension.class)
public class PartidoServiceImplTest {
    
    public static final Long ID = 1L;

    @InjectMocks
    private PartidoServiceImpl partidoService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PartidoRepository partidoRepository;

    @Test
    void deveriaCriarPartidoComSucesso() {
        Partido partido = new Partido();
        PartidoPedidoDto pedido = new PartidoPedidoDto();
        PartidoRespostaDto respostaEsperada = new PartidoRespostaDto();

        Mockito.when(modelMapper.map(any(), eq(Partido.class))).thenReturn(partido);
        Mockito.when(partidoRepository.save(any())).thenReturn(partido);
        Mockito.when(modelMapper.map(any(), eq(PartidoRespostaDto.class))).thenReturn(respostaEsperada);

        PartidoRespostaDto resposta = partidoService.cadastra(pedido);

        assertEquals(respostaEsperada, resposta);
        verify(partidoRepository).save(any());
    }

    @Test
    void deveriaListarTodosOsPartidosComSucesso() {
        Partido partido = new Partido();
        PartidoRespostaDto resposta = new PartidoRespostaDto();
        Page<Partido> pagina = new PageImpl<>(List.of(partido));
        PartidoParametrosRespostaDto respostaDeParametrosEsperada = criaRespostaDeParametrosDePartidos();

        Mockito.when(partidoRepository.findAll((Pageable) any())).thenReturn(pagina);
        Mockito.when(modelMapper.map(any(), eq(PartidoRespostaDto.class))).thenReturn(resposta);

        PartidoParametrosRespostaDto respostaDeParametros = partidoService.listar(null, any(Pageable.class));

        assertEquals(respostaDeParametrosEsperada, respostaDeParametros);
    }

    @Test
    void deveriaBuscarPorIdComSucesso() {
        Partido partido = new Partido();
        PartidoRespostaDto respostaEsperada = new PartidoRespostaDto();

        Mockito.when(partidoRepository.findById(any())).thenReturn(Optional.of(partido));
        Mockito.when(modelMapper.map(any(), eq(PartidoRespostaDto.class))).thenReturn(respostaEsperada);

        PartidoRespostaDto resposta = partidoService.buscarPorId(ID);

        assertEquals(respostaEsperada, resposta);
    }

    @Test 
    void deveriaAlterarPartidoComSucesso() {
        Partido partido = new Partido();
        PartidoRespostaDto respostaEsperada = new PartidoRespostaDto();
        PartidoPedidoDto pedido = new PartidoPedidoDto();

        Mockito.when(partidoRepository.findById(any())).thenReturn(Optional.of(partido));
        Mockito.when(modelMapper.map(any(), eq(Partido.class))).thenReturn(partido);
        Mockito.when(partidoRepository.save(any())).thenReturn(partido);
        Mockito.when(modelMapper.map(any(), eq(PartidoRespostaDto.class))).thenReturn(respostaEsperada);

        PartidoRespostaDto resposta = partidoService.alterar(ID, pedido);

        assertEquals(respostaEsperada, resposta);
        verify(partidoRepository).save(any());
    }

    @Test
    void deveriaDeletarPartidoComSucesso() {
        Partido partido = new Partido();

        Mockito.when(partidoRepository.findById(any())).thenReturn(Optional.of(partido));

        partidoService.deletar(ID);

        verify(partidoRepository).deleteById(any());
    }

    private PartidoParametrosRespostaDto criaRespostaDeParametrosDePartidos() {
        return PartidoParametrosRespostaDto.builder()
                    .numeroDeElementos(1)
                    .totalDeElementos(1L)
                    .totalDePaginas(1)
                    .partidos(List.of(new PartidoRespostaDto()))
                    .build();
    }

}
