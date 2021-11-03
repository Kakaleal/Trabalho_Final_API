package org.serratec.ecommerce.pedido.exception;


import org.serratec.ecommerce.exception.ErroResposta;

public class PedidoException extends RuntimeException {

    private ErroResposta erroResposta;

    public PedidoException(ErroResposta erroResposta) {
        super(erroResposta.getTitulo());
        this.erroResposta = erroResposta;
    }

    public ErroResposta getErroResposta() {
        return erroResposta;
    }

    //    public static class PedidoStatusException extends PedidoExceptions {
//        public PedidoStatusException(String message) {
//            super(message);
//        }
//    }
//
//    public static class PedidoExclusaoException extends PedidoExceptions {
//        public PedidoExclusaoException(String message) {
//            super(message);
//        }
//    }
}
