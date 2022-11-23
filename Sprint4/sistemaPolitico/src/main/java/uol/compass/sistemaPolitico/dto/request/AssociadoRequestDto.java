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

    @NotNull @NotEmpty @Length(min = 5)
    private String nome;
    @NotNull @Enumerated(EnumType.STRING)
    private CargoPolitico CargoPolitico;
    @NotNull @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String dataNascimento;
    @NotNull @Enumerated(EnumType.STRING)
    private Sexo sexo;

}
