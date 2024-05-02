package com.pablovass.repository;

import com.pablovass.domain.Persona;

import java.util.List;

public interface PersonaRepository {
    List<Persona> findAll();
}
