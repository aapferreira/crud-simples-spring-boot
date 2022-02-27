/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coderp.exerciciosspringboot.controller;

import br.com.coderp.exerciciosspringboot.model.Produto;
import br.com.coderp.exerciciosspringboot.repository.ProdutoRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author apferreira
 */
@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

//    @PostMapping
//    public @ResponseBody Produto novoProduto(@RequestParam String nome, @RequestParam Double preco, @RequestParam Double desconto) {
//        Produto p = new Produto(nome, preco, desconto);
//        produtoRepository.save(p);
//        return p;
//    }
    
//    @PostMapping
//    //public @ResponseBody Produto novoProduto(@Valid Produto p) {
//    public Produto novoProduto(@Valid Produto p) {
//        produtoRepository.save(p);
//        return p;
//    }
//    
//    @PutMapping
//    public Produto alterarProduto(@Valid Produto p) {
//        produtoRepository.save(p);
//        return p;
//    }
    
    //Utilizando um único método para inserir e alterar um produto
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Produto salvarProduto(@Valid Produto p) {
        produtoRepository.save(p);
        return p;
    }

    @GetMapping
    public Iterable<Produto> listaProduto() {
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
        return produtoRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void excluirProdutoPorId(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }

    @GetMapping(path = "/pagina/{numeroDaPagina}/{qtdElementosPorPagina}")
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroDaPagina, @PathVariable int qtdElementosPorPagina) {
        Pageable page = PageRequest.of(numeroDaPagina, qtdElementosPorPagina);
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutoPorId(@PathVariable String parteNome) {
        return produtoRepository.findByNomeContaining(parteNome);
    }
    
    
    
}
