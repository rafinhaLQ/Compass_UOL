package uol.compass.sistemapolitico.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    private String nome;
    @Enumerated(EnumType.STRING)
    private CargoPolitico cargoPolitico;
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Associado(String nome, CargoPolitico cargoPolitico, LocalDate dataNascimento, Sexo sexo) {
        this.nome = nome;
        this.cargoPolitico = cargoPolitico;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargoPolitico(CargoPolitico cargoPolitico) {
        this.cargoPolitico = cargoPolitico;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

}
