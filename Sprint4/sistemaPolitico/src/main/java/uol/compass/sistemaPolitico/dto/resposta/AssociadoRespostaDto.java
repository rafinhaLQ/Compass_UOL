package uol.compass.sistemapolitico.dto.resposta;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import uol.compass.sistemapolitico.enums.CargoPolitico;
import uol.compass.sistemapolitico.enums.Sexo;

@NoArgsConstructor
@Data
public class AssociadoRespostaDto {

    private Long id;
    private String nome;
    private CargoPolitico cargoPolitico;
    private LocalDate dataNascimento;
    private Sexo sexo;

}
