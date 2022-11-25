package uol.compass.sistemapolitico.excecoes.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import uol.compass.sistemapolitico.constantes.CodigoDeErroAssociado;
import uol.compass.sistemapolitico.constantes.CodigoDeErroPartido;
import uol.compass.sistemapolitico.dto.RespostaDaExcecao;
import uol.compass.sistemapolitico.excecoes.AssociadoNaoEncontradoException;
import uol.compass.sistemapolitico.excecoes.PartidoNaoEncontradoException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(AssociadoNaoEncontradoException.class)
    public final ResponseEntity<Object> lidarComAssociadoNaoEncontradoException(AssociadoNaoEncontradoException ex) {
        RespostaDaExcecao respostaDaExcecao = new RespostaDaExcecao(CodigoDeErroAssociado.ASSOCIADO_NAO_ENCONTRADO, ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaDaExcecao);
    }

    @ExceptionHandler(PartidoNaoEncontradoException.class)
    public final ResponseEntity<Object> lidarComPartidoNaoEncontradoException(PartidoNaoEncontradoException ex) {
        RespostaDaExcecao respostaDaExcecao = new RespostaDaExcecao(CodigoDeErroPartido.PARTIDO_NAO_ENCONTRADO, ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaDaExcecao);
    }

}
