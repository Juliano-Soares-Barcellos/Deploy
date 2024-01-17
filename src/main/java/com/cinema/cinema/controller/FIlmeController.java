/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.controller;


import com.cinema.cinema.data.FilmeEntity;
import com.cinema.cinema.service.AnaliseService;
import com.cinema.cinema.service.FilmeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

/**
 *
 * @author julianob
 */
@RestController
@RequestMapping("filme")
public class FIlmeController {

    @Autowired
    FilmeService filmeService;

    @Autowired
    AnaliseService analiseService;

    @PutMapping("/atualizarFilme/{id}")
    public ResponseEntity Atualizar(@PathVariable Integer id, @RequestBody FilmeEntity filme) {
        filme = filmeService.AtualizaFilme(id, filme);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<FilmeEntity>> RetornarFilmeAnalise() {
        List<FilmeEntity> lista = filmeService.RetornarFilmesAnalises();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/deletaFilme/{id}")
    public ResponseEntity deletaFilme(@PathVariable int id) {
        filmeService.DeletaFilme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/adcionar")
    public ResponseEntity adcionar(@Valid @RequestBody FilmeEntity filme) {
       FilmeEntity filmeRetorno = analiseService.AntescriarAnalise(filme.getTitulo());
        if (filmeRetorno == null) {
            
            filme = filmeService.criarFilme(filme);
            return new ResponseEntity<>(filme, HttpStatus.CREATED);
        } else 
        {
            return new ResponseEntity<>("Filme Ja existente em nossa base de dados", HttpStatus.NOT_FOUND);
        }
    }

}
