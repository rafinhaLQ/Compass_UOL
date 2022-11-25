package uol.compass.sistemapolitico.dto;

import java.util.List;
import java.util.Collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import uol.compass.sistemapolitico.constantes.CodigosDeErro;

@Data
@AllArgsConstructor
public class RespostaDaExcecao {

    private final String codigo;

    private final String mensagem;

    private final List<String> detalhes;

    public RespostaDaExcecao(CodigosDeErro codigosDeErro, Throwable ex) {
        this(codigosDeErro, ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage());
    }

    public RespostaDaExcecao(CodigosDeErro codigosDeErro, String detalhes){
        this.codigo = codigosDeErro.name();
        this.mensagem = codigosDeErro.getMensagem();
        this.detalhes = Collections.singletonList(detalhes);
    }

    public RespostaDaExcecao(CodigosDeErro codigosDeErro, List<String> detalhes){
        this.codigo = codigosDeErro.name();
        this.mensagem = codigosDeErro.getMensagem();
        this.detalhes = detalhes;
    }

}
