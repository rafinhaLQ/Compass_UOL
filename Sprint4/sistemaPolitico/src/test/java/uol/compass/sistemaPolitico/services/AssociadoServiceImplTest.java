package uol.compass.sistemapolitico.services;

import org.junit.jupiter.api.Test;

import uol.compass.sistemapolitico.dto.request.AssociadoRequestDto;
import uol.compass.sistemapolitico.dto.response.AssociadoResponseDto;
import uol.compass.sistemapolitico.entities.Associado;

public class AssociadoServiceImplTest {
    
    

    @Test
    void deveriaCriarAssociadoComSucesso() {
        Associado associado = new Associado();
        AssociadoRequestDto request = new AssociadoRequestDto();
        AssociadoResponseDto response = new AssociadoResponseDto();
    }

}
