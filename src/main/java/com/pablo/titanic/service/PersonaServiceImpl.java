package com.pablo.titanic.service;

import com.pablo.titanic.model.Persona;
import com.pablo.titanic.repository.PersonaRepository;
import com.pablo.titanic.repository.PersonaRepositoryImpl;
import com.pablo.titanic.storage.PersonasStorage;
import com.pablo.titanic.storage.PersonasStorageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.util.List;


public class PersonaServiceImpl implements PersonaService {

    private final Logger log =LoggerFactory.getLogger(PersonaRepositoryImpl.class.getName());
    private final PersonasStorage storage;
    private final PersonaRepository repository;


    public PersonaServiceImpl(PersonasStorage storage, PersonaRepository repository) {
        this.storage = storage;
        this.repository = repository;
    }

    @Override
    public List<Persona> readFromFile(String file) {
        log.info("Leyendo...");
        return storage.readFromFile(new File(file));

    }

    @Override
    public void writeToFile(String file, List<Persona> personas) {
        log.info("Añadiendo personas" + file);
        storage.writeToFile(new File(file), personas);
    }

    @Override
    public void importFromFile(String file) {
        log.info("Importando..." + file);
        List<Persona> personas = readFromFile(file);
        personas.forEach(repository::save);
    }

    @Override
    public void exportToFile(String file) {
        log.info("Exportando..." + file);
        writeToFile(file, repository.getAll());
    }

    @Override
    public List<Persona> getAll() {
        log.info("Obteniendo los datos");
        return repository.getAll();
    }

    @Override
    public Persona getById(int id) {
        log.info("Persona con id " + id);
        Persona producto = repository.getById(id);
        return producto;
    }


}

