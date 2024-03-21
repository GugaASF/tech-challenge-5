package services;

import models.CarrinhoDeCompra;
import models.Produto;
import models.Usuario;
import repositories.CarrinhoDeCompraRepository;
import repositories.ProdutoRepository;
import repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoDeCompraRepository carrinhoDeCompraRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void addProdutoAoCarrinho(String login, Long produtoId) {
        Usuario usuario = usuarioRepository.findByLogin(login);
        Produto produto = produtoRepository.findById(produtoId).orElseThrow();
        CarrinhoDeCompra carrinhoDeCompra = usuario.getCarrinhoDeCompra();

        carrinhoDeCompra.getProdutos().add(produto);
        carrinhoDeCompra.setTotal(carrinhoDeCompra.getTotal() + produto.getValor());

        carrinhoDeCompraRepository.save(carrinhoDeCompra);
    }

    public void removeProdutoDoCarrinho(String login, Long produtoId) {
        Usuario usuario = usuarioRepository.findByLogin(login);
        Produto produto = produtoRepository.findById(produtoId).orElseThrow();
        CarrinhoDeCompra carrinhoDeCompra = usuario.getCarrinhoDeCompra();

        carrinhoDeCompra.getProdutos().remove(produto);
        carrinhoDeCompra.setTotal(carrinhoDeCompra.getTotal() - produto.getValor());

        carrinhoDeCompraRepository.save(carrinhoDeCompra);
    }

    public CarrinhoDeCompra getCarrinho(String login) {
        Usuario usuario = usuarioRepository.findByLogin(login);
        return usuario.getCarrinhoDeCompra();
    }

    public void limparCarrinho(String login) {
        Usuario usuario = usuarioRepository.findByLogin(login);
        CarrinhoDeCompra carrinhoDeCompra = usuario.getCarrinhoDeCompra();

        carrinhoDeCompra.getProdutos().clear();
        carrinhoDeCompra.setTotal(0.0);

        carrinhoDeCompraRepository.save(carrinhoDeCompra);
    }


}