package uol.compass.sistemapolitico.dto.request;

import javax.validation.constraints.NotNull;

import uol.compass.sistemapolitico.entities.Vinculado;

public class VinculadoRequestDto {

    @NotNull
    private Long idAssociado;
    @NotNull
    private Long idPartido;

    public Long getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(Long idAssociado) {
        this.idAssociado = idAssociado;
    }

    public Long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Long idPartido) {
        this.idPartido = idPartido;
    }

    public Vinculado converterParaVinculado() {
        return new Vinculado(idAssociado, idPartido);
    }

}
