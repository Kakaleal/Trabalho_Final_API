package org.serratec.ecommerce.pedido.repository;

import org.serratec.ecommerce.pedido.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    //Optional<Veiculo> findByNomeIgnoreCase(String nome);
}
