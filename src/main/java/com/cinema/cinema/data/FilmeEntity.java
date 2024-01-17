package com.cinema.cinema.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "filme")
public class FilmeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Titulo Do Filme")
    @Size(max = 100)
    @Size(min = 2)

    @Column(name = "titulo")
    private String titulo;

    @NotBlank(message = "Sinopse")
    @Size(max = 120)
    private String sinopse;

    @NotBlank(message = "Ano de lancamento")
    @Size(max = 11)
    private String anoLancamento;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL)
    private List<AnaliseEntity> analises;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public List<AnaliseEntity> getAnalises() {
        return analises;
    }

    public void setAnalises(List<AnaliseEntity> analises) {
        this.analises = analises;
    }
 public FilmeEntity()
 {
     
 }
    public FilmeEntity(Integer id, String titulo, String sinopse, String anoLancamento, List<AnaliseEntity> analises) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.analises = analises;
    }

    
}
