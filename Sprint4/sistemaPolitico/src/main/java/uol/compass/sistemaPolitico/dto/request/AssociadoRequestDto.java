package uol.compass.sistemapolitico.dto.request;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

@Getter
@Setter
@NoArgsConstructor
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

    public Associado converterParaAssociado() {
        return new Associado(nome, cargoPolitico, dataNascimento, sexo);
    }

}
