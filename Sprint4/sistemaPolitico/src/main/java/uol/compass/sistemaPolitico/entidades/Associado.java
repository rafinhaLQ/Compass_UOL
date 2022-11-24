package uol.compass.sistemapolitico.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CargoPolitico getCargoPolitico() {
        return cargoPolitico;
    }

    public void setCargoPolitico(CargoPolitico cargoPolitico) {
        this.cargoPolitico = cargoPolitico;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
}
