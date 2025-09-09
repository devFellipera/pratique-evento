/**
 * Projeto: CityEvents
 * Disciplina: Atividade Pratique
 * Autor: Felipe Oliveira
 */


package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String name;
    private String address;
    private String category;
    private LocalDateTime dateTime;
    private String description;

    public Event(String name, String address, String category, LocalDateTime dateTime, String description) {
        this.name = name;
        this.address = address;
        this.category = category;
        this.dateTime = dateTime;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public boolean isHappeningNow() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(dateTime.minusHours(1)) && now.isBefore(dateTime.plusHours(1));
    }

    public boolean hasPassed() {
        return LocalDateTime.now().isAfter(dateTime);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return name + " | " + category + " | " + address + " | " + dateTime.format(formatter) + " | " + description;
    }

    public String toDataString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return name + ";" + address + ";" + category + ";" + dateTime.format(formatter) + ";" + description;
    }

    public static Event fromDataString(String line) {
        try {
            String[] parts = line.split(";");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return new Event(parts[0], parts[1], parts[2], LocalDateTime.parse(parts[3], formatter), parts[4]);
        } catch (Exception e) {
            return null;
        }
    }
}
