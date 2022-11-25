package uol.compass.sistemapolitico.entidades;

import java.time.LocalDate;
import java.util.function.Consumer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "associados")
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_politico")
    private CargoPolitico cargoPolitico;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "partido_id")
    private Partido partidoId;

}
