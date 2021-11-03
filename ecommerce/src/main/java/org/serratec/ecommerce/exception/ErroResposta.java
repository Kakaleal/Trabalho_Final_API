package org.serratec.ecommerce.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;

public class ErroResposta {

    private HttpStatus status;
    private String titulo;
    private LocalDateTime dataHora;
    private List<String> errors;

    public ErroResposta(HttpStatus status, String titulo) {
        this.status = status;
        this.titulo = titulo;
        this.dataHora = LocalDateTime.now();
    }

    public ErroResposta(HttpStatus status, String titulo, List<String> errors) {
        this(status, titulo);
        this.errors = errors;
    }

    public String getStatus()
    {
        return new StringJoiner(" ")
                .add(String.valueOf(status.value()))
                .add(status.name()).toString();
    }

    public HttpStatus returnHttpStatus(){
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
