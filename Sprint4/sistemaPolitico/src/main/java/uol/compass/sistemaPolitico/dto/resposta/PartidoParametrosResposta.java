package uol.compass.sistemapolitico.dto.resposta;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartidoParametrosResposta {

    private Integer numeroDeElementos;

    private Long totalDeElementos;

    private Integer totalDePaginas;

    private List<PartidoRespostaDto> partidos;

}
