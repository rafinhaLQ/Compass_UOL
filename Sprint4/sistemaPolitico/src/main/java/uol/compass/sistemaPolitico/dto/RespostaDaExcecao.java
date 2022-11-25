package uol.compass.sistemapolitico.dto;

import java.util.List;
import java.util.Collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import uol.compass.sistemapolitico.constantes.CodigoDeErro;

@Data
@AllArgsConstructor
public class RespostaDaExcecao {

    private final String codigo;

    private final String mensagem;

    private final List<String> detalhes;

    public RespostaDaExcecao(CodigoDeErro codigoDeErro, Throwable ex) {
        this(codigoDeErro, ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage());
    }

    public RespostaDaExcecao(CodigoDeErro codigoDeErro, String detalhes){
        this.codigo = codigoDeErro.name();
        this.mensagem = codigoDeErro.getMensagem();
        this.detalhes = Collections.singletonList(detalhes);
    }

    public RespostaDaExcecao(CodigoDeErro codigoDeErro, List<String> detalhes){
        this.codigo = codigoDeErro.name();
        this.mensagem = codigoDeErro.getMensagem();
        this.detalhes = detalhes;
    }
}
