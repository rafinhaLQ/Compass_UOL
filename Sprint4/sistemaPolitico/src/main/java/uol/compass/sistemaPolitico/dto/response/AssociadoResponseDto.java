package uol.compass.sistemapolitico.dto.response;

import java.time.LocalDate;

import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

public class AssociadoResponseDto {

    private Long id;
    private String nome;
    private CargoPolitico cargoPolitico;
    private LocalDate dataNascimento;
    private Sexo sexo;

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

}
