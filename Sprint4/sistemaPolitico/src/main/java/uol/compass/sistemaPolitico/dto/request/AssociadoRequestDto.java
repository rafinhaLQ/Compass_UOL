package uol.compass.sistemapolitico.dto.request;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

public class AssociadoRequestDto {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;
    @NotNull
    @Enumerated(EnumType.STRING)
    private CargoPolitico cargoPolitico;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
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

}
