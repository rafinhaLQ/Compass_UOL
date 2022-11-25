package uol.compass.sistemapolitico.constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodigoDeErroAssociado {

    ASSOCIADO_NAO_ENCONTRADO("Associado nao encontrado");

    private final String mensagem;

}
