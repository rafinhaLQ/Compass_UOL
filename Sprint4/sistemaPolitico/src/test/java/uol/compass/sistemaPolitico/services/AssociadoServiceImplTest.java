package uol.compass.sistemapolitico.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

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
        AssociadoRespostaDto respostaTest = new AssociadoRespostaDto();
        AssociadoPedidotDto pedido = Mockito.mock(AssociadoPedidotDto.class);
        
        Mockito.when(modelMapper.map(pedido, Associado.class)).thenReturn(paraCriar);
        Mockito.when(associadoRepository.save(paraCriar)).thenReturn(criado);
        
        Mockito.when(modelMapper.map(criado, AssociadoRespostaDto.class)).thenReturn(respostaTest);

        AssociadoRespostaDto resposta = associadoService.cadastra(pedido);

        assertEquals(respostaTest, resposta);
        verify(associadoRepository).save(any());
    }

    @Test
    void deveriaVincularAssociadoAUmPartidoComSucesso() {
        Associado associadoParaCriar = Mockito.mock(Associado.class);
        Associado associadoCriado = new Associado();
        AssociaPartidoRespostaDto respostaTest = new AssociaPartidoRespostaDto();
        AssociaPartidoPedidoDto pedido = Mockito.mock(AssociaPartidoPedidoDto.class);

        Partido partidoParaCriar = Mockito.mock(Partido.class);
        Partido partidoCriado = new Partido();

        Mockito.when(associadoRepository.getReferenceById(pedido.getIdAssociado())).thenReturn(associadoParaCriar);
        Mockito.when(partidoRepository.getReferenceById(pedido.getIdPartido())).thenReturn(partidoParaCriar);

        associadoParaCriar.setPartido(partidoParaCriar);
        partidoParaCriar.getAssociados().add(associadoCriado);

        Mockito.when(associadoRepository.save(associadoParaCriar)).thenReturn(associadoCriado);
        Mockito.when(partidoRepository.save(partidoParaCriar)).thenReturn(partidoCriado);
        
        respostaTest.setAssociado(associadoCriado);
        respostaTest.setPartido(partidoCriado);

        AssociaPartidoRespostaDto resposta = associadoService.vincula(pedido);

        assertEquals(respostaTest, resposta);
        verify(associadoRepository).save(any());
        verify(partidoRepository).save(any());
    }

}