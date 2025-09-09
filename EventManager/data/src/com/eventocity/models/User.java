/**
 * Projeto: CityEvents
 * Disciplina: Atividade Pratique
 * Autor: Felipe Oliveira
 */


package models;

import java.util.ArrayList;
import java.util.List;
import models.Event;

public class User {
    private String name;
    private String email;
    private int age;
    private List<Event> attendingEvents;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.attendingEvents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public List<Event> getAttendingEvents() {
        return attendingEvents;
    }

    public void attendEvent(Event event) {
        if(!attendingEvents.contains(event)) {
            attendingEvents.add(event);
        }
    }

    public void cancelEvent(Event event) {
        attendingEvents.remove(event);
    }

    @Override
    public String toString() {
        return name + " (" + email + ", " + age + " anos)";
    }
}
