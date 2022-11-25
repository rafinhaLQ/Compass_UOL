package uol.compass.sistemapolitico.excecoes;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import uol.compass.sistemapolitico.constantes.CodigoDeErroPartido;

@Getter
public class PartidoNaoEncontradoException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private final String mensagem;
    private final CodigoDeErroPartido codigoDeErro;
    private final HttpStatus httpStatus;

    public PartidoNaoEncontradoException() {
        super(CodigoDeErroPartido.PARTIDO_NAO_ENCONTRADO.name());
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.codigoDeErro = CodigoDeErroPartido.PARTIDO_NAO_ENCONTRADO;
        this.mensagem = CodigoDeErroPartido.PARTIDO_NAO_ENCONTRADO.getMensagem();
    }

}
