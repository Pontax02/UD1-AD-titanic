package com.pablo.titanic.storage;

import com.pablo.titanic.model.Persona;
import java.io.File;

import java.util.List;

public interface PersonasStorage {

    List<Persona> readFromFile(File file);

    void writeToFile(File file, List<Persona> personas);
}
