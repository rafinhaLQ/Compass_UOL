package uol.compass.sistemapolitico.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import uol.compass.sistemapolitico.dto.request.VinculadoRequestDto;
import uol.compass.sistemapolitico.dto.response.VinculadoResponseDto;
import uol.compass.sistemapolitico.entidades.Vinculado;
import uol.compass.sistemapolitico.repository.VinculadoRepository;

public class VinculadoServiceImplTest {
    
    private VinculadoServiceImpl vinculadoService;

    @Mock
    private VinculadoRepository repository;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.vinculadoService = new VinculadoServiceImpl(repository);
    }

    @Test
    void deveriaCriarVinculoComSucesso() {
        Vinculado paraCriar = new Vinculado();
        Vinculado criado = new Vinculado();
        VinculadoRequestDto request = Mockito.mock(VinculadoRequestDto.class);
        
        Mockito.when(request.converterParaVinculado()).thenReturn(paraCriar);
        Mockito.when(repository.save(paraCriar)).thenReturn(criado);
        
        VinculadoResponseDto responseTest = new VinculadoResponseDto(criado);
        VinculadoResponseDto response = vinculadoService.vincula(request);

        assertEquals(responseTest.getIdAssociado(), response.getIdAssociado());
        assertEquals(responseTest.getIdPartido(), response.getIdPartido());
        verify(repository).save(any());
    }

}
