package co.edu.uptc.ejercicio1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.ejercicio1.models.Person;
import co.edu.uptc.ejercicio1.services.PersonService;

@RestController
@RequestMapping("/")
public class MessageController {

    @GetMapping("/person")
    public Person getJSONPerson() {
        PersonService service = new PersonService();
        return service.generatePerson();
    }
    @GetMapping("/image")
    public String getImage() {
        return "<img src=\"https://avatars.githubusercontent.com/u/120030275?v=4\" style=\"width: 500px;\"/>";
    }
}
