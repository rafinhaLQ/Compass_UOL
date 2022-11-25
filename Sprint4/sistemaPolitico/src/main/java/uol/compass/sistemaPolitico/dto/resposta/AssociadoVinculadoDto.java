package uol.compass.sistemapolitico.dto.resposta;


import lombok.Data;
import lombok.NoArgsConstructor;
import uol.compass.sistemapolitico.entidades.Associado;
import uol.compass.sistemapolitico.entidades.Partido;
import uol.compass.sistemapolitico.enums.CargoPolitico;

@NoArgsConstructor
@Data
public class AssociadoVinculadoDto {

    private String nome;
    private CargoPolitico cargoPolitico;
    private Long partidoId;

    public AssociadoVinculadoDto(Partido partido, Associado associado) {
        this.nome = associado.getNome();
        this.cargoPolitico = associado.getCargoPolitico();
        this.partidoId = partido.getId();
    }

}
