package uol.compass.sistemapolitico.excecoes.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import uol.compass.sistemapolitico.constantes.CodigosDeErro;
import uol.compass.sistemapolitico.dto.RespostaDaExcecao;
import uol.compass.sistemapolitico.excecoes.AssociadoNaoEncontradoException;
import uol.compass.sistemapolitico.excecoes.PartidoNaoEncontradoException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(AssociadoNaoEncontradoException.class)
    public final ResponseEntity<Object> lidarComAssociadoNaoEncontradoException(AssociadoNaoEncontradoException ex) {
        RespostaDaExcecao respostaDaExcecao = new RespostaDaExcecao(CodigosDeErro.ASSOCIADO_NAO_ENCONTRADO, ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaDaExcecao);
    }

    @ExceptionHandler(PartidoNaoEncontradoException.class)
    public final ResponseEntity<Object> lidarComPartidoNaoEncontradoException(PartidoNaoEncontradoException ex) {
        RespostaDaExcecao respostaDaExcecao = new RespostaDaExcecao(CodigosDeErro.PARTIDO_NAO_ENCONTRADO, ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaDaExcecao);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> lidarComTodasAsExcecoes(Exception ex) {
        RespostaDaExcecao respostaDaExcecao = new RespostaDaExcecao(CodigosDeErro.ERRO_INTERNO_DO_SERVIDOR, ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respostaDaExcecao);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        RespostaDaExcecao respostaDaExcecao = new RespostaDaExcecao(CodigosDeErro.PEDIDO_INVALIDO, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaDaExcecao);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        RespostaDaExcecao respostaDaExcecao = new RespostaDaExcecao(CodigosDeErro.PEDIDO_INVALIDO, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaDaExcecao);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> errosDeCampo = ex.getBindingResult().getFieldErrors();

        List<String> erros = new ArrayList<>();
        errosDeCampo.forEach(erro -> 
                erros.add(String.format("%s : %s", erro.getField(), erro.getDefaultMessage()))
        );
        
        RespostaDaExcecao respostaDaExcecao = new RespostaDaExcecao(CodigosDeErro.PEDIDO_INVALIDO, erros);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaDaExcecao);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        RespostaDaExcecao respostaDaExcecao = new RespostaDaExcecao(CodigosDeErro.PARAMETRO_INVALIDO, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaDaExcecao);
    }

    

}
