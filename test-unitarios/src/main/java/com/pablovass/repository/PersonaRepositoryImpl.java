package com.pablovass.repository;

import com.pablovass.domain.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {

    @Override
    public List<Persona> findAll() {
        // Aquí iría la lógica para obtener todas las personas (puedes usar una lista en memoria para este ejemplo)
        return  null;
    }
}