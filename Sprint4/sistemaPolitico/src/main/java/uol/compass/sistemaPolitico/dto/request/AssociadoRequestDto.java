package uol.compass.sistemapolitico.dto.request;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import uol.compass.sistemapolitico.entities.Associado;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

public class AssociadoRequestDto {

    @NotBlank
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CargoPolitico cargoPolitico;

    @NotNull
    @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

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

    public Associado converterParaAssociado() {
        return new Associado(nome, cargoPolitico, dataNascimento, sexo);
    }

}
