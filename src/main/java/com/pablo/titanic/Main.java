package com.pablo.titanic;

import com.pablo.titanic.model.Persona;
import com.pablo.titanic.repository.PersonaRepositoryImpl;
import com.pablo.titanic.service.PersonaService;
import com.pablo.titanic.service.PersonaServiceImpl;
import com.pablo.titanic.storage.PersonasStorageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //Creamos el service
        PersonaService service = new PersonaServiceImpl(new PersonasStorageImpl(),new PersonaRepositoryImpl());

        System.out.println("Mostrando datos de la tripulación del Titanic");

        service.importFromFile("res/titanic.csv");

        List<Persona> personas = service.getAll();

        System.out.println();
        System.out.println("Mostrando todas las personas");
        for (Persona persona : personas) {
            System.out.println(persona);
        }


    }
}
