package uol.compass.sistemapolitico.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import uol.compass.sistemapolitico.dto.request.AssociadoRequestDto;
import uol.compass.sistemapolitico.dto.response.AssociadoResponseDto;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.repository.AssociadoRepository;

public class AssociadoServiceImplTest {

    private AssociadoServiceImpl associadoService;

    @Mock
    private AssociadoRepository repository;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.associadoService = new AssociadoServiceImpl(repository);
    }

    @Test
    void deveriaCriarAssociadoComSucesso() {
        Associado paraCriar = new Associado();
        Associado criado = new Associado();
        AssociadoRequestDto request = Mockito.mock(AssociadoRequestDto.class);
        
        Mockito.when(request.converterParaAssociado()).thenReturn(paraCriar);
        Mockito.when(repository.save(paraCriar)).thenReturn(criado);
        
        AssociadoResponseDto responseTest = new AssociadoResponseDto(criado);

        AssociadoResponseDto response = associadoService.cadastra(request);

        assertEquals(responseTest.getId(), response.getId());
        assertEquals(responseTest.getNome(), response.getNome());
        assertEquals(responseTest.getCargoPolitico(), response.getCargoPolitico());
        assertEquals(responseTest.getDataNascimento(), response.getDataNascimento());
        assertEquals(responseTest.getSexo(), response.getSexo());
        verify(repository).save(any());
    }

}
