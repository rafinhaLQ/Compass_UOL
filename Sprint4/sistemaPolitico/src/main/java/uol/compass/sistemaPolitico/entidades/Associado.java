package uol.compass.sistemapolitico.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

@Entity
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CargoPolitico cargoPolitico;
    private LocalDate dataNascimento;
    private Sexo sexo;

    public Associado(CargoPolitico cargoPolitico, LocalDate dataNascimento, Sexo sexo) {
        this.cargoPolitico = cargoPolitico;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public CargoPolitico getCargoPolitico() {
        return cargoPolitico;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

}
