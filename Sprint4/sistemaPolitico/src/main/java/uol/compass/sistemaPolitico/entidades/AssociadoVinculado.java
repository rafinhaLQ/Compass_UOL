package uol.compass.sistemapolitico.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASSOCIADO_PARTIDO")
public class AssociadoVinculado {

    @Id
    @Column(name = "ID_ASSOCIADO")
    private Long idAssociado;
    @Column(name = "ID_PARTIDO")
    private Long idPartido;

    public AssociadoVinculado() {
    }

    public AssociadoVinculado(Long idAssociado, Long idPartido) {
        this.idAssociado = idAssociado;
        this.idPartido = idPartido;
    }

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

}
