/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.model;

/**
 *
 * @author julianob
 */
public class Analise {
   private int  id;
   private String filme;
   private String Analise;
   private double  nota;
 
    public Analise()
    {
     
    }
    public Analise(int id, String filme, String análise, double nota) {
        this.id = id;
        this.filme = filme;
        this.Analise = análise;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getAnalise() {
        return Analise;
    }

    public void setAnalise(String Analise) {
        this.Analise = Analise;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
   
   
}
