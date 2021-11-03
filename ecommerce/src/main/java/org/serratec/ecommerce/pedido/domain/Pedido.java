package org.serratec.ecommerce.pedido.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.serratec.ecommerce.pedido.utils.StatusPedido;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_pedido", nullable = false)
    private LocalDate dataPedido;

    @Enumerated(value = EnumType.ORDINAL)
    private StatusPedido statusPedido = StatusPedido.PROCESSANDO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
