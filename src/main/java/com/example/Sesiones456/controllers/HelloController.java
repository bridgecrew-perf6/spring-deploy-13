package com.example.Sesiones456.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.varexample}")
    String message;



    @GetMapping("/hellocontroller")
    public String HelloController() {
        System.out.println(message);
        return ("Buenos días, " + message);
    }
}
