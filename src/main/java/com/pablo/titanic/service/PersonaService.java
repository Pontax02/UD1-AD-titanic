package com.pablo.titanic.service;

import com.pablo.titanic.model.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> readFromFile(String file);

    void writeToFile(String file, List<Persona> personas);

    void importFromFile(String file);

    void exportToFile(String file);

    List<Persona> getAll();

    Persona getById(int id);

}
