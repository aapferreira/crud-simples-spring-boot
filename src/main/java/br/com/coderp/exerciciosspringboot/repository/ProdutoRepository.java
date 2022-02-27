/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coderp.exerciciosspringboot.repository;

import br.com.coderp.exerciciosspringboot.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author apferreira
 */
//public interface ProdutoRepository extends CrudRepository<Produto, Integer> {         //Crud simples
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {    //Contém o crud simples, paginação e sorting

    //Criando a interface de um método seguindo a convenção findBy+NomeDoAtributo+algumaConvencao e o spring se encarrega do resto
    public Iterable<Produto> findByNomeContaining(String parteNome);
    //outras opções
    //findByNomeContaining    
    //findByNomeIsContaining
    //findByNomeContains
    //findByNomeStartsWith
    //findByNomeEndsWith
    //findByNomeNotContaining
    
    //Criando uma consulta customizada
    @Query("SELECT p FROM Produto WHERE p.nome LIKE :nome")
    public Iterable<Produto> buscaPorNomeExato(@Param("nome") String nome);
    
}
