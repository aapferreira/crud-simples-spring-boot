/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coderp.exerciciosspringboot.controller;

import br.com.coderp.exerciciosspringboot.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author apferreira
 */
@RestController
//@RequestMapping(path = "/clientes") ou
@RequestMapping("/clientes")
public class ClienteController {
    
    //@GetMapping(path = "/clientes/qualquer")
    //@GetMapping(path = "/qualquer") ou
    @GetMapping("/qualquer")
    public Cliente obterCliente() {
        return new Cliente(1, "aaaaa", "111.111.111-11");
    }
    
    //http://localhost:8080/clientes/3
    @GetMapping("/{id}")
    public Cliente obterClientePorId(@PathVariable int id) {
        if (id == 1) {
            return new Cliente(1, "aaaaa", "111.111.111-11");
        } else {
            return new Cliente(0, "00000", "000.000.000-00");
        }
    }
    
    //retornando dados através da url get normal
    //http://localhost:8080/clientes?id=1
    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "0") int id) {
        if (id == 1) {
            return new Cliente(1, "aaaaa", "111.111.111-11");
        } else {
            return new Cliente(0, "00000", "000.000.000-00");
        }
    }
    
}
