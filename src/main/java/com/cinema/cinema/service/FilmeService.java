/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.service;


import com.cinema.cinema.data.AnaliseRepository;
import com.cinema.cinema.data.FilmeEntity;
import com.cinema.cinema.data.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author julianob
 */
@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    AnaliseRepository analiseRepository;

    public FilmeEntity criarFilme(FilmeEntity Filme) {
        Filme.setId(null);
        filmeRepository.save(Filme);
        return Filme;
    }

    public FilmeEntity getFilmeId(Integer filme) {
        return filmeRepository.findById(filme).orElseThrow(() -> new ResourceAccessException("Funcionario não encontrado : " + filme));
    }

    public void DeletaFilme(Integer id) {
        FilmeEntity fl = getFilmeId(id);
        filmeRepository.deleteById(fl.getId());
    }

    public FilmeEntity AtualizaFilme(Integer id,FilmeEntity filme)
    {
        FilmeEntity filmeVolta=getFilmeId(id);
        filmeVolta.setAnoLancamento(filme.getAnoLancamento());
        filmeVolta.setSinopse(filme.getSinopse());
        return filmeRepository.save(filmeVolta);
    }
    
       public List<FilmeEntity>  RetornarFilmesAnalises() {
        return filmeRepository.findAllFilmes();
    }
}
