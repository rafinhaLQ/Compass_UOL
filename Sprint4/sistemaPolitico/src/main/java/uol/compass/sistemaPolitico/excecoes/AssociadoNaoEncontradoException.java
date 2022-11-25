package uol.compass.sistemapolitico.excecoes;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import uol.compass.sistemapolitico.constantes.CodigoDeErro;

@Getter
public class AssociadoNaoEncontradoException extends RuntimeException {
    
    private final String detalhes;
    private final CodigoDeErro codigoDeErro;
    private final HttpStatus httpStatus;

    public AssociadoNaoEncontradoException() {
        super(CodigoDeErro.ASSOCIADO_NAO_ENCONTRADO.name());
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.codigoDeErro = CodigoDeErro.ASSOCIADO_NAO_ENCONTRADO;
        this.detalhes = CodigoDeErro.ASSOCIADO_NAO_ENCONTRADO.getMensagem();
    }

}
