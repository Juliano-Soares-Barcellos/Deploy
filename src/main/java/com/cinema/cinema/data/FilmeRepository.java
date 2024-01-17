/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cinema.cinema.data;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julianob
 */
@Repository
public interface FilmeRepository extends JpaRepository<FilmeEntity, Integer>
{
FilmeEntity findByTitulo(String titulo);
@Query(value = "SELECT filme.id,filme.titulo,filme.sinopse,filme.ano_lancamento,analise.analiseId,analise.analise,analise.nota,analise.filme_id FROM filme left join analise on filme.id=analise.filme_id group by filme.titulo", nativeQuery = true)
    List<FilmeEntity> findAllFilmes();
}