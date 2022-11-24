package uol.compass.sistemapolitico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uol.compass.sistemapolitico.dto.request.AssociadoRequestDto;
import uol.compass.sistemapolitico.dto.response.AssociadoResponseDto;

public interface AssociadoService {
    
    AssociadoResponseDto cadastra(AssociadoRequestDto request);

    Page<AssociadoResponseDto> listar(Pageable pageable);
    
    AssociadoResponseDto buscarPorId(Long id);
    
    AssociadoResponseDto alterar(Long id, AssociadoRequestDto request);
    
    void deletar(Long id);
    
}
