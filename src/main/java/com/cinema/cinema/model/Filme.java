/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julianob
 */
public class Filme {

    private int Id;
    private String Titulo;
    private String Sinopse;
    private String AnoLancamento;

    private List<Filme> _Filme = new ArrayList<>();

    public List<Filme> getFilme() {
        return _Filme;
    }

    

    public Filme(int Id, String Titulo, String Sinopse, String AnoLancamento) {
        this.Id = Id;
        this.Titulo = Titulo;
        this.Sinopse = Sinopse;
        this.AnoLancamento = AnoLancamento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getSinopse() {
        return Sinopse;
    }

    public void setSinopse(String Sinopse) {
        this.Sinopse = Sinopse;
    }

    public String getAnoLancamento() {
        return AnoLancamento;
    }

    public void setAnoLancamento(String AnoLancamento) {
        this.AnoLancamento = AnoLancamento;
    }

    public Filme() {
        _Filme.add(new Filme(1, "Matrix", "Um hacker descobre a verdade sobre a realidade virtual", "1999"));
        _Filme.add(new Filme(2, "Interestelar", "Explorando buracos de minhoca para salvar a humanidade", "2014"));
        _Filme.add(new Filme(3, "O Poderoso Chefão", "A saga da família Corleone no mundo do crime", "1972"));
        _Filme.add(new Filme(4, "O Senhor dos Anéis: A Sociedade do Anel", "Uma jornada para destruir um anel maligno", "2001"));
        _Filme.add(new Filme(5, "A Origem", "Explorando sonhos e realidades alternativas", "2010"));
        _Filme.add(new Filme(6, "Forrest Gump", "A vida de um homem comum com uma extraordinária série de eventos", "1994"));
        _Filme.add(new Filme(7, "Os Intocáveis", "A luta contra o crime organizado em Chicago", "1987"));
        _Filme.add(new Filme(8, "Efeito Borboleta", "As consequências imprevisíveis de pequenas ações", "2004"));
    }
}
