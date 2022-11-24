package uol.compass.sistemapolitico.dto.pedido;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssociaPartidoPedidoDto {
    
    @NotNull
    private Long idAssociado;

    @NotNull
    private Long idPartido;

}
