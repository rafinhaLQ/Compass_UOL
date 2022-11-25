package uol.compass.sistemapolitico.dto.pedido;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uol.compass.sistemapolitico.enums.Ideologia;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartidoPedidoDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String sigla;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;

    @NotNull
    @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataFundacao;

}
