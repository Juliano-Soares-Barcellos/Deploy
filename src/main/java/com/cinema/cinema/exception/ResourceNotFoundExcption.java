/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.cinema.exception;

import org.springframework.http.HttpStatus; 

import org.springframework.web.bind.annotation.ResponseStatus; 
/**
 *
 * @author julianob
 */
@ResponseStatus(HttpStatus.NOT_FOUND) 
public class ResourceNotFoundExcption extends RuntimeException{
   
    public ResourceNotFoundExcption(String mensagem)
    {
        super(mensagem);
    }
}
