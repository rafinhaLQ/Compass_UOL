package uol.compass.sistemapolitico.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import uol.compass.sistemapolitico.entidades.Vinculado;

@Getter
@Setter
public class VinculadoRequestDto {

    @NotNull
    private Long idAssociado;
    @NotNull
    private Long idPartido;

    public Vinculado converterParaVinculado() {
        return new Vinculado(idAssociado, idPartido);
    }

}
