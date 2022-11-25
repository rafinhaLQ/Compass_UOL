package uol.compass.sistemapolitico.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import uol.compass.sistemapolitico.dto.pedido.PartidoPedidoDto;
import uol.compass.sistemapolitico.dto.resposta.PartidoRespostaDto;
import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.repository.PartidoRepository;

@ExtendWith(MockitoExtension.class)
public class PartidoServiceImplTest {
    
    public static final Long ID = 1L;

    @InjectMocks
    private PartidoServiceImpl partidoServiceImpl;

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

        PartidoRespostaDto resposta = partidoServiceImpl.cadastra(pedido);

        assertEquals(respostaEsperada, resposta);
        verify(partidoRepository).save(any());
    }

}
