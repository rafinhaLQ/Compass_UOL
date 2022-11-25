package uol.compass.sistemapolitico.constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodigosDeErro {

    PARTIDO_NAO_ENCONTRADO("Partido não encontrado"),
    ASSOCIADO_NAO_ENCONTRADO("Associado nao encontrado"),
    PEDIDO_INVALIDO("Pedido invalido"),
    PARAMETRO_INVALIDO("Parametro invalido"),
    ERRO_INTERNO_DO_SERVIDOR("Erro interno do servidor");

    private final String mensagem;

}
