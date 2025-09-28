package com.pablo.titanic.model;

import java.util.Objects;
import java.util.Optional;

public class Persona {

    private int id;
    private short pclass;
    private String nombre;
    private String sex;
    private Optional<Integer> age;
    private short sibsp;
    private short parch;
    private String ticket;
    private double fare;
    private Optional<String> cabin;
    private Optional<String> embarked;
    private Optional<Integer> boat;
    private Optional<Integer> body;
    private Optional<String> home_destiny;
    private boolean survived;

    public Persona(int id, short pclass, String nombre, String sex, short sibsp, short parch, Optional<Integer> age, String ticket, Optional<Integer> boat, Optional<String> embarked, Optional<String> cabin, double fare, Optional<Integer> body, Optional<String> home_destiny, boolean survived) {
        this.id = id;
        this.pclass = pclass;
        this.nombre = nombre;
        this.sex = sex;
        this.sibsp = sibsp;
        this.parch = parch;
        this.age = age;
        this.ticket = ticket;
        this.boat = boat;
        this.embarked = embarked;
        this.cabin = cabin;
        this.fare = fare;
        this.body = body;
        this.home_destiny = home_destiny;
        this.survived = survived;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id && pclass == persona.pclass && sibsp == persona.sibsp && parch == persona.parch && Double.compare(fare, persona.fare) == 0 && survived == persona.survived && Objects.equals(nombre, persona.nombre) && Objects.equals(sex, persona.sex) && Objects.equals(age, persona.age) && Objects.equals(ticket, persona.ticket) && Objects.equals(cabin, persona.cabin) && Objects.equals(embarked, persona.embarked) && Objects.equals(boat, persona.boat) && Objects.equals(body, persona.body) && Objects.equals(home_destiny, persona.home_destiny);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pclass, nombre, sex, age, sibsp, parch, ticket, fare, cabin, embarked, boat, body, home_destiny, survived);
    }

    public int getId() {
        return id;
    }

    public short getPclass() {
        return pclass;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSex() {
        return sex;
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public short getSibsp() {
        return sibsp;
    }

    public short getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public double getFare() {
        return fare;
    }

    public Optional<String> getCabin() {
        return cabin;
    }

    public Optional<Integer> getBoat() {
        return boat;
    }

    public Optional<String> getEmbarked() {
        return embarked;
    }

    public boolean isSurvived() {
        return survived;
    }

    public Optional<String> getHome_destiny() {
        return home_destiny;
    }

    public Optional<Integer> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", pclass=" + pclass +
                ", nombre='" + nombre + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sibsp=" + sibsp +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin=" + cabin +
                ", embarked=" + embarked +
                ", boat=" + boat +
                ", body=" + body +
                ", home_destiny=" + home_destiny +
                ", survived=" + survived +
                '}';
    }
}
