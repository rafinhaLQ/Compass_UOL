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
import uol.compass.sistemapolitico.entities.Vinculado;
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
        Vinculado toCreate = new Vinculado();
        Vinculado created = new Vinculado();
        VinculadoRequestDto request = Mockito.mock(VinculadoRequestDto.class);
        
        Mockito.when(request.converterParaVinculado()).thenReturn(toCreate);
        Mockito.when(repository.save(toCreate)).thenReturn(created);
        
        VinculadoResponseDto responseTest = new VinculadoResponseDto(created);
        VinculadoResponseDto response = vinculadoService.vincula(request);

        assertEquals(responseTest.getIdAssociado(), response.getIdAssociado());
        assertEquals(responseTest.getIdPartido(), response.getIdPartido());
        verify(repository).save(any());
    }

}
