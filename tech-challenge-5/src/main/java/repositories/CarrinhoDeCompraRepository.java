package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import models.CarrinhoDeCompra;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoDeCompraRepository extends JpaRepository<CarrinhoDeCompra, Long> {



}
