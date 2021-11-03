package org.serratec.ecommerce.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.serratec.ecommerce.pedido.exception.PedidoException;
import org.serratec.ecommerce.utils.Mensagens;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PedidoException.class)
    public ResponseEntity<Object> handlePedidoStatusException(PedidoException ex){
//        ErroResposta erroResposta = new ErroResposta(HttpStatus.BAD_REQUEST,
//                Mensagens.Exceptions.EDICAO_FALHOU,
//                Arrays.asList(ex.getMessage()));

        return new ResponseEntity<Object>(ex.getErroResposta(), ex.getErroResposta().returnHttpStatus());
//        return new ResponseEntity<Object>(ex.getErroResposta(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErroResposta erroResposta = new ErroResposta(status,
                Mensagens.Exceptions.CAMPOS_INVALIDOS,
                Collections.singletonList(ex.getMostSpecificCause().getMessage()));

        if(ex.getCause() instanceof InvalidFormatException){
            erroResposta.setErrors(Collections.singletonList(
                    String.format("O dado informado '%s' não é um tipo válido de '%s'.",
                            ((InvalidFormatException)ex.getCause()).getValue().toString(),
                            ((MismatchedInputException)ex.getCause()).getTargetType().toString()
                    )));
        } else if(ex.getCause() instanceof JsonParseException){
            String erro = ((JsonParseException)ex.getCause()).getRequestPayloadAsString();
            System.out.println(erro);
        }


        return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> errors = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        ErroResposta erroResposta = new ErroResposta(status,
                Mensagens.Exceptions.CAMPOS_INVALIDOS,
                errors);
        return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
    }
}
