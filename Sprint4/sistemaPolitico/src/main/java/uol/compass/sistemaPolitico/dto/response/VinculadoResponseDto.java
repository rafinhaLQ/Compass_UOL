package uol.compass.sistemapolitico.dto.response;

import lombok.Getter;
import uol.compass.sistemapolitico.entidades.Vinculado;

@Getter
public class VinculadoResponseDto {

    private Long idAssociado;
    private Long idPartido;

    public VinculadoResponseDto(Vinculado associadoVinculado) {
        this.idAssociado = associadoVinculado.getIdAssociado();
        this.idPartido = associadoVinculado.getIdPartido();
    }

}
