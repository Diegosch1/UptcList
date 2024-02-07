package co.edu.uptc.ejercicio1.services;

import co.edu.uptc.ejercicio1.models.Person;

public class PersonService {

    public Person generatePerson() {
        Person person = new Person();
        person.setName("Juanito");
        person.setLastName("Golondrina");
        person.setWeight(100);
        return person;
    }
}
