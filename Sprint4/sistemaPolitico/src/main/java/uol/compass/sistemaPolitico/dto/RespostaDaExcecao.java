package uol.compass.sistemapolitico.dto;

import java.util.List;
import java.util.Collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import uol.compass.sistemapolitico.constantes.CodigoDeErroAssociado;
import uol.compass.sistemapolitico.constantes.CodigoDeErroPartido;

@Data
@AllArgsConstructor
public class RespostaDaExcecao {

    private final String codigo;

    private final String mensagem;

    private final List<String> detalhes;

    public RespostaDaExcecao(CodigoDeErroAssociado codigoDeErro, Throwable ex) {
        this(codigoDeErro, ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage());
    }

    public RespostaDaExcecao(CodigoDeErroAssociado codigoDeErro, String detalhes){
        this.codigo = codigoDeErro.name();
        this.mensagem = codigoDeErro.getMensagem();
        this.detalhes = Collections.singletonList(detalhes);
    }

    public RespostaDaExcecao(CodigoDeErroAssociado codigoDeErro, List<String> detalhes){
        this.codigo = codigoDeErro.name();
        this.mensagem = codigoDeErro.getMensagem();
        this.detalhes = detalhes;
    }

    public RespostaDaExcecao(CodigoDeErroPartido codigoDeErro, Throwable ex) {
        this(codigoDeErro, ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage());
    }

    public RespostaDaExcecao(CodigoDeErroPartido codigoDeErro, String detalhes){
        this.codigo = codigoDeErro.name();
        this.mensagem = codigoDeErro.getMensagem();
        this.detalhes = Collections.singletonList(detalhes);
    }

    public RespostaDaExcecao(CodigoDeErroPartido codigoDeErro, List<String> detalhes){
        this.codigo = codigoDeErro.name();
        this.mensagem = codigoDeErro.getMensagem();
        this.detalhes = detalhes;
    }
}
