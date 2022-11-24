package uol.compass.sistemapolitico.dto.resposta;

import lombok.Data;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.entidades.Partido;

@Data
public class AssociaPartidoRespostaDto {

    private Partido partido;
    private Associado associado;

}
