package uol.compass.sistemapolitico.constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodigoDeErroPartido {
    
    PARTIDO_NAO_ENCONTRADO("Partido não encontrado");

    private final String mensagem;

}
