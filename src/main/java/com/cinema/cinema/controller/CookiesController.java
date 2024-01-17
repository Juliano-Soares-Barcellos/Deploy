/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.controller;

import com.cinema.cinema.data.FilmeEntity;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author julianob
 */
@Controller ("/cookies")
@RequestMapping("/cookies")

public class CookiesController {

    @RequestMapping("/exclui")
    public String excluiCookie(HttpServletResponse response) {
        Cookie novoCookie = new Cookie("user-id", null);
        novoCookie.setMaxAge(0);
        response.addCookie(novoCookie);
        return "excluicookie";
    }



@RequestMapping("/")
public String index(@CookieValue(name = "estilo", defaultValue = "") String estilo, Model model) {
    model.addAttribute("css", estilo);
    System.out.println("[DEBUG] Estilo no index: " + estilo);
    return "index";
}



}
