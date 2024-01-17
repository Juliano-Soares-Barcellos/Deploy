/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.controller;

import com.cinema.cinema.data.AnaliseEntity;
import com.cinema.cinema.data.FilmeEntity;
import com.cinema.cinema.model.Analise;
import com.cinema.cinema.model.Filme;
import com.cinema.cinema.service.AnaliseService;
import com.cinema.cinema.service.FilmeService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author julianob
 */
@Controller
public class CinemaController {

    @Autowired
    FilmeService filmeService;

    @Autowired
    AnaliseService analiseService;

    List<Analise> _Analise = new ArrayList<>();
 
    Filme init = new Filme();
    
    List<Filme> _Filme = init.getFilme();

    @GetMapping("/index")
    public String listaFilme(@CookieValue(name = "estilo", defaultValue = "dark") String estilo, Model model) {
        model.addAttribute("css", estilo);
        FilmeEntity _filme = new FilmeEntity();
        AnaliseEntity analise = new AnaliseEntity();
        model.addAttribute("Film", _filme);
        model.addAttribute("_analise", analise);
        List<FilmeEntity> lista = filmeService.RetornarFilmesAnalises();
        try {
            model.addAttribute("Filme", lista);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "Index";
    }

    @GetMapping("/cadastrofilme")
    public String exibirFormularioCadastroFilme(Model model) {
        FilmeEntity filme = new FilmeEntity();  
        model.addAttribute("filme", filme);
        return "cadastrofilme";
    }

    @PostMapping("/cadastro")
    public String processarFormulario(@ModelAttribute FilmeEntity filme, Model model) {
        FilmeEntity filmeRetorno = analiseService.AntescriarAnalise(filme.getTitulo().toString());
        if (filmeRetorno == null) {
            filme = filmeService.criarFilme(filme);
            model.addAttribute("mensagem", "Filme inserido com sucesso.");
            return "redirect:/index";
        }
        return "redirect:/index";
    }

    @PostMapping("/Critica")
    public String processarCritica(@RequestParam("titulo") String titulo, @ModelAttribute AnaliseEntity analise, Model model) {

        FilmeEntity filme = analiseService.AntescriarAnalise(titulo);
        if (filme == null) {
            model.addAttribute("mensagemErro", "Não foi possível encontrar o filme com o título fornecido.");
            return "redirect:/index";
        }
        analiseService.criarAnalise(analise, filme);
        model.addAttribute("mensagem", "Critica inserida.");
        return "redirect:/index";

    }

    @PostMapping("/deletaAnalise")
    public String deletaAnalise(@RequestParam("titulo") String titulo) {
        FilmeEntity filme = analiseService.AntescriarAnalise(titulo);
        if (filme == null) {
            return "redirect:/index";
        }
        analiseService.DeletaAnalise(filme.getAnalises().get(0).getAnaliseId());
        return "redirect:/index";
    }

    @PostMapping("/deletaFilme")
    public String deletaFilme(@RequestParam("titulo") String titulo) {
        FilmeEntity filme = analiseService.AntescriarAnalise(titulo);
        if (filme == null) {
            return "redirect:/index";
        }
        List<AnaliseEntity> analise = filme.getAnalises();

        if (filme.getAnalises().size() > 0) {
            for (AnaliseEntity item : filme.getAnalises()) {

                analiseService.DeletaAnalise(filme.getAnalises().get(0).getAnaliseId());
            }
        }
        filmeService.DeletaFilme(filme.getId());
        return "redirect:/index";
    }

    @PostMapping("/preferencias")
    public String gravaPreferencias(@RequestParam("estilo") String estilo, Model model, HttpServletResponse response) {
        Cookie cookiePrefNome = new Cookie("estilo", estilo);
        cookiePrefNome.setDomain("localhost");
        cookiePrefNome.setHttpOnly(true);
        cookiePrefNome.setMaxAge(86400);
        response.addCookie(cookiePrefNome);
        return "redirect:/index";
    }
}
