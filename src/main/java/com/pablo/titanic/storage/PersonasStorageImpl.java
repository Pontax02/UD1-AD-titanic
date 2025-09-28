package com.pablo.titanic.storage;

import com.pablo.titanic.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class PersonasStorageImpl implements PersonasStorage {

    private final Logger logger = LoggerFactory.getLogger(PersonasStorageImpl.class.getName());

    @Override
    public List<Persona> readFromFile(File file){

        logger.debug("Leyendo personas");
        if (!file.exists() || !file.canRead() || !file.isFile()) {
            logger.error("No se puede leer");
            throw new RuntimeException("No se puede leer");
        }
        try {
            return Files.lines(file.toPath()).
                    skip(1)
                    .map(line -> line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1))
                    .map(this::trimArray)
                    .map(this::createPersona)
                    .toList();
        } catch (IOException e ){
            logger.error("No se puede leer");
        }
        return List.of();
    }

    @Override
    public  void writeToFile(File file, List<Persona> personas) {
        logger.debug("Escribiendo a las personas en el csv");

    try {

        StringBuilder archive = new StringBuilder();
        for (Persona persona : personas) {
            archive.append(persona.toString());
            archive.append(", ");
        }
        Files.writeString(file.toPath(),archive.toString());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }



    private String[] trimArray(String[] array) {
        return Stream.of(array).map(String::trim).toArray(String[]::new);
    }

    private Persona createPersona(String[] data) {
        return new Persona(Integer.parseInt(data[0]),
                Integer.parseInt(data[1]),
                data[2],
                data[3],
                data[4] == ""?Optional.empty():Optional.of(Double.parseDouble(data[4])),
                Integer.parseInt(data[5]),
                Integer.parseInt(data[6]),
                data[7],
                data[8] == ""?Optional.empty():Optional.of(Double.parseDouble(data[8])),
                Optional.of(data[9]),
                Optional.of(data[10]),
                Optional.of((data[11])),
                data[12] == ""?Optional.empty():Optional.of(Double.parseDouble(data[12])),
                Optional.of(data[13]),
                Integer.parseInt(data[14]));

    }
}
