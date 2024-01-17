/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.service;


import com.cinema.cinema.data.AnaliseEntity;
import com.cinema.cinema.data.AnaliseRepository;
import com.cinema.cinema.data.FilmeEntity;
import com.cinema.cinema.data.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author julianob
 */
@Service
public class AnaliseService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    AnaliseRepository analiseRepository;

    public AnaliseEntity getAnalise(Integer analise) {
        return analiseRepository.findById(analise).orElseThrow(() -> new ResourceAccessException("analise não encontrado : " + analise));
    }

//    public AnaliseEntity criarAnalise(AnaliseEntity analise) {
//        analise.setId(null);
//        analiseRepository.save(analise);
//        return analise;
//    }
    public void DeletaAnalise(Integer AnaliseId) {
        AnaliseEntity analise = getAnalise(AnaliseId);
        analiseRepository.deleteById(analise.getAnaliseId());
    }

    public AnaliseEntity editarAnalise(Integer AnaliId, AnaliseEntity analise) {
        AnaliseEntity analiseId = getAnalise(AnaliId);
        analiseId.setAnalise(analise.getAnalise());
        analiseId.setNota(analise.getNota());
        return analiseRepository.save(analiseId);
    }

    public AnaliseEntity criarAnalise(AnaliseEntity analise, FilmeEntity filme) {
        analise.setFilme(filme);
        analiseRepository.save(analise);
        return analise;
      
        
    }

    public FilmeEntity AntescriarAnalise(String titulo) {
        FilmeEntity filmeEncontrado = filmeRepository.findByTitulo(titulo);
        return filmeEncontrado;
    }

    
}
