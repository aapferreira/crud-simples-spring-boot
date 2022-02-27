/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coderp.exerciciosspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author apferreira
 */
@RestController
public class PrimeiroController {

    //@RequestMapping ou
    //@RequestMapping(method = RequestMethod.GET) ou
    @GetMapping
    public String ola() {
        return "Olá Spring Boot!";
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/olaComPath")
    //@GetMapping(path = "/olaComPath")
    @GetMapping(path = {"/olaComPath", "/olaComPath2"})
    public String olaComPath() {
        return "Olá Spring Boot (com path)!";
    }

    @PostMapping(path = {"/olaComPath", "/olaComPath2"})
    public String olaPost() {
        return "Olá Spring Boot (com path - POST)!";
    }

}
