package co.edu.uptc.ejercicio1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.ejercicio1.models.UptcList;

@RestController
@RequestMapping("/")
public class MessageController {
    @GetMapping("/")
    public void runCode(){
        UptcList<String> list = new UptcList<>();
        list.add("Text 1");
        list.add("Text 2");
        list.add("Text 3");
        list.add("Text 4");
        list.add(0,"TestText");
        list.show();
    }

    @GetMapping("/image")
    public String getImage() {
        return "<img src=\"https://avatars.githubusercontent.com/u/120030275?v=4\" style=\"width: 500px;\"/>";
    }
}
