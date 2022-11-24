package uol.compass.sistemapolitico.services;

import uol.compass.sistemapolitico.dto.request.VinculadoRequestDto;
import uol.compass.sistemapolitico.dto.response.VinculadoResponseDto;

public interface VinculadoService {
    
    VinculadoResponseDto vincula(VinculadoRequestDto request);

}
