package co.edu.uptc.ejercicio1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @GetMapping()
    public String getMessager() {
        char comillas = 34;
        String output = "<img src="+comillas+"https://avatars.githubusercontent.com/u/120030275?v=4"+comillas+">";
        return output;
    }
}
