package uol.compass.sistemapolitico.dto.resposta;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import uol.compass.sistemapolitico.entidades.Associado;

@NoArgsConstructor
@Data
public class PartidoVinculadoDto {

    private String nome;
    private String sigla;
    private List<Associado> associados;

}
