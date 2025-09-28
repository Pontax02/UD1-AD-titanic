package com.pablo.titanic.repository;

import com.pablo.titanic.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonaRepositoryImpl implements PersonaRepository {

    private final Logger logger = LoggerFactory.getLogger(PersonaRepositoryImpl.class.getName());

    private final Map<Integer, Persona> personas = new HashMap<Integer, Persona>();

    @Override
    public List<Persona> getAll() {
        logger.debug("Obteniendo todas las personas");
        return personas.values().stream().toList();
    }
    @Override
    public Persona getById(Integer id) {
        logger.debug("Obteniendo persona con id: " + id);
        return personas.get(id);
    }

    @Override
    public Persona save(Persona persona) {
        logger.debug("Guardando persona: " + persona);
        int id = personas.keySet().stream().mapToInt(Integer::intValue).max().orElse(0)+1;
        Persona personaconId = persona.withId(id);
        personas.put(id, personaconId);
        return personaconId;
    }

    @Override
    public Persona update(Integer id, Persona persona) {
        logger.debug("Actualizando persona con id: " + id);
        return  personas.put(id, persona);
    }

    @Override
    public Persona delete(Integer id) {
        logger.debug("Eliminando persona con id: " + id);
        return personas.remove(id);
    }


}
