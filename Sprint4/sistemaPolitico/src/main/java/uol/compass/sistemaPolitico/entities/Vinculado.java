package uol.compass.sistemapolitico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ASSOCIADO_PARTIDO")
public class Vinculado {

    @Id
    @Column(name = "ID_ASSOCIADO")
    private Long idAssociado;
    @Column(name = "ID_PARTIDO")
    private Long idPartido;

}
