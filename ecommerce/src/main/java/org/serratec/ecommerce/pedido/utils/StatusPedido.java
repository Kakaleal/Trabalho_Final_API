package org.serratec.ecommerce.pedido.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.ecommerce.exception.EnumValidationException;

import java.util.StringJoiner;

public enum StatusPedido {

    PROCESSANDO(1,"Processando"),
    LIBERADO(2, "Liberado"),
    CANCELADO(3, "Cancelado");

    private Integer codigo;
    private String tipo;

    private StatusPedido(Integer codigo, String tipo){
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    @JsonCreator
    public static StatusPedido verifica(Integer value) throws EnumValidationException {
        String errorMsg = "Status preenchido incorretmente. ";
        StringJoiner joiner = new StringJoiner(" - ");
        for (StatusPedido c : values()){
            joiner.add(c.getCodigo() + ") " + c.getTipo());// errorMsg += c.getCodigo() + ") " + c.getTipo() + " ";
            if (value.equals(c.getCodigo())){
                return c;
            }
        }
        errorMsg += joiner.toString();
        throw new EnumValidationException(errorMsg);
    }
}
