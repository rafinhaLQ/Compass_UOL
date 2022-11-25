package uol.compass.sistemapolitico.dto.resposta;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import uol.compass.sistemapolitico.enums.Ideologia;

@NoArgsConstructor
@Data
public class PartidoRespostaDto {

    private Long id;
    private String nome;
    private String sigla;
    private Ideologia ideologia;
    private LocalDate dataFundacao;

}
