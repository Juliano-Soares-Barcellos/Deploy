/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 *
 * @author julianob
 */
@Data
@Entity
@Table(name = "analise")
public class AnaliseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "analiseId")
    private Integer analiseId;
    @NotNull(message = "informe a nota")
    private Double nota;
    @NotBlank(message = "Analise obrigatória")
    @Size(max = 100)
    private String analise;
    @ManyToOne
    @JoinColumn(name = "filme_id")
    @JsonIgnore
    private FilmeEntity filme;
    
public AnaliseEntity(){
    
}
    public AnaliseEntity(Integer analiseId, Double nota, String analise, FilmeEntity filme) {
        this.analiseId = analiseId;
        this.nota = nota;
        this.analise = analise;
        this.filme = filme;
    }

    public Integer getAnaliseId() {
        return analiseId;
    }

    public void setAnaliseId(Integer analiseId) {
        this.analiseId = analiseId;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public FilmeEntity getFilme() {
        return filme;
    }

    public void setFilme(FilmeEntity filme) {
        this.filme = filme;
    }
    

}
