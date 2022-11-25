package uol.compass.sistemapolitico.excecoes;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import uol.compass.sistemapolitico.constantes.CodigosDeErro;

@Getter
public class PartidoNaoEncontradoException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private final String mensagem;
    private final CodigosDeErro codigoDeErro;
    private final HttpStatus httpStatus;

    public PartidoNaoEncontradoException() {
        super(CodigosDeErro.PARTIDO_NAO_ENCONTRADO.name());
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.codigoDeErro = CodigosDeErro.PARTIDO_NAO_ENCONTRADO;
        this.mensagem = CodigosDeErro.PARTIDO_NAO_ENCONTRADO.getMensagem();
    }

}
