package controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CarrinhoService;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    private CarrinhoService service;


    @GetMapping
    public ResponseEntity getCarrinho(String login){
        service.getCarrinho(login);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/produto")
    public ResponseEntity addProdutoAoCarrinho(String login, Long produtoId){
        service.addProdutoAoCarrinho(login, produtoId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/produto")
    public ResponseEntity removeProdutoDoCarrinho(String login, Long produtoId){
        service.removeProdutoDoCarrinho(login, produtoId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity limparCarrinho(String login){
        service.limparCarrinho(login);
        return ResponseEntity.ok().build();
    }



}
