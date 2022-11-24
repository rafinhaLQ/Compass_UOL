package uol.compass.sistemapolitico.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import uol.compass.sistemapolitico.dto.pedido.AssociadoRequestDto;
import uol.compass.sistemapolitico.dto.resposta.AssociadoResponseDto;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.repository.AssociadoRepository;

@ExtendWith(MockitoExtension.class)
public class AssociadoServiceImplTest {
    
    @InjectMocks
    private AssociadoServiceImpl associadoService;

    @Mock
    private ModelMapper modelMapper;


    @Mock
    private AssociadoRepository repository;

    @Test
    void deveriaCriarAssociadoComSucesso() {
        Associado paraCriar = new Associado();
        Associado criado = new Associado();
        AssociadoResponseDto respostaTest = new AssociadoResponseDto();
        AssociadoRequestDto pedido = Mockito.mock(AssociadoRequestDto.class);
        
        Mockito.when(modelMapper.map(pedido, Associado.class)).thenReturn(paraCriar);
        Mockito.when(repository.save(paraCriar)).thenReturn(criado);
        
        Mockito.when(modelMapper.map(criado, AssociadoResponseDto.class)).thenReturn(respostaTest);

        AssociadoResponseDto resposta = associadoService.cadastra(pedido);

        assertEquals(respostaTest, resposta);
        verify(repository).save(any());
    }

    @Test
    void deveriaEncontrarTodosOsAssociadosComSucesso() {
        
    }

}
