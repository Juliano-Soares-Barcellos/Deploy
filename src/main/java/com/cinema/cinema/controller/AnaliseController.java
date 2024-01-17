/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.controller;


import com.cinema.cinema.data.AnaliseEntity;
import com.cinema.cinema.data.FilmeEntity;
import com.cinema.cinema.service.AnaliseService;
import jakarta.validation.Valid;
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

/**
 *
 * @author julianob
 */
@RestController
@RequestMapping("analise")
public class AnaliseController {

    @Autowired
    AnaliseService analiseService;

    @PutMapping("/atualizarAnalise/{id}")
    public ResponseEntity Atualizar(@PathVariable Integer id, @RequestBody AnaliseEntity analise) {
        analise = analiseService.editarAnalise(id, analise);
        return new ResponseEntity<>(analise, HttpStatus.OK);
    }

    @DeleteMapping("/deletaFilme/{id}")
    public ResponseEntity deletaFilme(@PathVariable int id) {
        analiseService.DeletaAnalise(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/adcionar/{titulo}")
    public ResponseEntity adcionar(@Valid @RequestBody AnaliseEntity analise, @PathVariable String titulo) {
        FilmeEntity filme = analiseService.AntescriarAnalise(titulo);
        if (filme == null) 
        {
            return new ResponseEntity<>("Filme não encontrado", HttpStatus.NOT_FOUND);
        }

        analise = analiseService.criarAnalise(analise, filme);
        return new ResponseEntity<>(analise, HttpStatus.CREATED);
    }

}
