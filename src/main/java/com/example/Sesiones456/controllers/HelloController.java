package com.example.Sesiones456.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hellocontroller")
    public String HelloController() {
        return ("Buenos días");
    }
}
