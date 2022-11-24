package uol.compass.sistemapolitico.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "ASSOCIADOS")
public class Associado {

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "CARGO_POLITICO")
    private CargoPolitico cargoPolitico;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO")
    private Sexo sexo;

    public Associado(String nome, CargoPolitico cargoPolitico, LocalDate dataNascimento, Sexo sexo) {
        this.nome = nome;
        this.cargoPolitico = cargoPolitico;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

}
