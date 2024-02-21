package co.edu.uptc.ejercicio1.services;

import co.edu.uptc.ejercicio1.models.Person;

public class PersonService {
    private Person person = new Person();

    public Person generatePerson() {
        
        person.setName("Juanito");
        person.setLastName("Golondrina");
        person.setWeight(70);
        return person;
    }
}