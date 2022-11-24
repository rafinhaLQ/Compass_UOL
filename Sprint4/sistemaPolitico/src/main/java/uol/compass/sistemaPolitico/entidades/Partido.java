package uol.compass.sistemapolitico.entidades;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uol.compass.sistemapolitico.enums.Ideologia;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "PARTIDO")
public class Partido {

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SIGLA")
    private String sigla;

    @Column(name = "IDEOLOGIA")
    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;

    @Column(name = "DATA_FUNDACAO")
    private LocalDate dataFundacao;

    @Column(name = "ASSOCIADOS")
    @OneToMany(mappedBy = "PARTIDO")
    private List<Associado> associados;

}
