package models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@Table(name = "carrinhos")
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoDeCompra {


    private Long id;
    private Long idCliente;

    @OneToMany(mappedBy = "carrinhoDeCompra")
    private List<Produto> produtos;

    private Double total;

    @OneToOne(mappedBy = "carrinhoDeCompra")
    private Usuario usuario;


    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
        this.total += produto.getValor();
    }



}
