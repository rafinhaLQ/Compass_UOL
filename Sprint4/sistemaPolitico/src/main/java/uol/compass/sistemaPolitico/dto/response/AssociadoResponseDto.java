package uol.compass.sistemapolitico.dto.response;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import uol.compass.sistemapolitico.entities.Associado;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

@NoArgsConstructor
@Getter
public class AssociadoResponseDto {

    private Long id;
    private String nome;
    private CargoPolitico cargoPolitico;
    private LocalDate dataNascimento;
    private Sexo sexo;

    public AssociadoResponseDto(Associado associado) {
        this.id = associado.getId();
        this.nome = associado.getNome();
        this.cargoPolitico = associado.getCargoPolitico();
        this.dataNascimento = associado.getDataNascimento();
        this.sexo = associado.getSexo();
    }

}
