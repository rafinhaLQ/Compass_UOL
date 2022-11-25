package uol.compass.sistemapolitico.excecoes;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import uol.compass.sistemapolitico.constantes.CodigosDeErro;

@Getter
public class AssociadoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    private final String mensagem;
    private final CodigosDeErro codigoDeErro;
    private final HttpStatus httpStatus;

    public AssociadoNaoEncontradoException() {
        super(CodigosDeErro.ASSOCIADO_NAO_ENCONTRADO.name());
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.codigoDeErro = CodigosDeErro.ASSOCIADO_NAO_ENCONTRADO;
        this.mensagem = CodigosDeErro.ASSOCIADO_NAO_ENCONTRADO.getMensagem();
    }

}
