package uol.compass.sistemapolitico.dto.response;

import uol.compass.sistemapolitico.entities.AssociadoVinculado;

public class AssociadoVinculadoResponseDto {

    private Long idAssociado;
    private Long idPartido;

    public AssociadoVinculadoResponseDto(AssociadoVinculado associadoVinculado) {
        this.idAssociado = associadoVinculado.getIdAssociado();
        this.idPartido = associadoVinculado.getIdPartido();
    }

    public Long getIdAssociado() {
        return idAssociado;
    }

    public Long getIdPartido() {
        return idPartido;
    }

    
}
