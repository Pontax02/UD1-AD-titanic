package com.pablo.titanic.model;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

public class Persona {

    private int id;
    private int pclass;
    private String nombre;
    private String sex;
    private Optional<Double> age;
    private int sibsp;
    private int parch;
    private String ticket;
    private Optional<Double> fare;
    private Optional<String> cabin;
    private Optional<String> embarked;
    private Optional<String> boat;
    private Optional<Double> body;
    private Optional<String> home_destiny;
    private int survived;

    public Persona(int id, int pclass, String nombre, String sex, Optional<Double> age, int sibsp, int parch, String ticket, Optional<Double> fare, Optional<String> cabin, Optional<String> embarked, Optional<String> boat, Optional<Double> body, Optional<String> home_destiny, int survived) {
        this.id = id;
        this.pclass = pclass;
        this.nombre = nombre;
        this.sex = sex;
        this.age = age;
        this.sibsp = sibsp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
        this.boat = boat;
        this.body = body;
        this.home_destiny = home_destiny;
        this.survived = survived;
    }





    public Persona withId(int newId){
        return new Persona(newId,pclass,nombre,sex,age,sibsp,parch,ticket,fare,cabin,embarked,boat,body,home_destiny,survived);
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



    public int getId() {
        return id;
    }

    public int getPclass() {
        return pclass;
    }

    public String getNombre() {
        return nombre;
    }




    public String getSex() {
        return sex;
    }

    public Optional<Double> getAge() {
        return age;
    }

    public int getSibsp() {
        return sibsp;
    }

    public int getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public Optional<Double> getFare() {
        return fare;
    }

    public Optional<String> getCabin() {
        return cabin;
    }

    public Optional<Double> getBody() {
        return body;
    }

    public Optional<String> getEmbarked() {
        return embarked;
    }

    public Optional<String> getBoat() {
        return boat;
    }

    public Optional<String> getHome_destiny() {
        return home_destiny;
    }

    public int isSurvived() {
        return survived;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id && pclass == persona.pclass && sibsp == persona.sibsp && parch == persona.parch && survived == persona.survived && Objects.equals(nombre, persona.nombre)  && Objects.equals(sex, persona.sex) && Objects.equals(age, persona.age) && Objects.equals(ticket, persona.ticket) && Objects.equals(fare, persona.fare) && Objects.equals(cabin, persona.cabin) && Objects.equals(embarked, persona.embarked) && Objects.equals(boat, persona.boat) && Objects.equals(body, persona.body) && Objects.equals(home_destiny, persona.home_destiny);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pclass, nombre, sex, age, sibsp, parch, ticket, fare, cabin, embarked, boat, body, home_destiny, survived);
    }
}
