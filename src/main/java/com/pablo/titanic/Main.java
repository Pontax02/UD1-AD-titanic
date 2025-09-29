package com.pablo.titanic;

import com.pablo.titanic.model.Persona;
import com.pablo.titanic.repository.PersonaRepositoryImpl;
import com.pablo.titanic.service.PersonaService;
import com.pablo.titanic.service.PersonaServiceImpl;
import com.pablo.titanic.storage.PersonasStorageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


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

        //¿Cuántos pasajeros en total han sobrevivido?
        System.out.println();
        System.out.println("¿Cuántos pasajeros en total han sobrevivido?");
        System.out.println(personas.stream()
                .filter(p -> p.isSurvived() == 1).count());


        //¿Cuál fue el puerto de embarque más común?
        System.out.println();
        System.out.println("¿Cuál fue el puerto de embarque más común?");

        System.out.println(personas.stream()
                        .filter(p -> p.isSurvived() == 1)
                .map(Persona::getEmbarked)
                .collect(Collectors.groupingBy(emb -> emb, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey));



        //Cuál fue la tasa de supervivencia de los niños (menores de 12 años)
        System.out.println();
        System.out.println("Cuál fue la tasa de supervivencia de los niños (menores de 12 años)");

        System.out.println(personas.stream()
                .filter(p -> p.isSurvived() == 1)
                .map(Persona::getAge)  // Esto devuelve Stream<Optional<Double>>
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Double::intValue)

                .filter(p -> p <= 12)
                .count());

        System.out.println();
        System.out.println("Y de los mayores?");
        System.out.println(personas.stream()
                .filter(p -> p.isSurvived() == 1)
                .map(Persona::getAge)  // Esto devuelve Stream<Optional<Double>>
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Double::intValue)
                .filter(p -> p > 12)
                .count());
    }
}
