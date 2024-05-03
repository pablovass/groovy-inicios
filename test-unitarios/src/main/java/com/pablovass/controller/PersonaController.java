package com.pablovass.controller;

// PersonaController.java
import com.pablovass.domain.Persona;
import com.pablovass.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private  Persona persona;

    public PersonaController(Persona persona, PersonaService personaService) {
        this.persona = persona;
        this.personaService = personaService;
    }
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.findAll();
    }
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.findAll();
    }














    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {

        Persona persona1= new Persona();
        persona1.sumar(3);
        persona.sumar(2);

        this.personaService = personaService;
    }


}

