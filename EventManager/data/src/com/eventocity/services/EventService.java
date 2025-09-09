/**
 * Projeto: CityEvents
 * Disciplina: Atividade Pratique
 * Autor: Felipe Oliveira
 */


package services;

import models.Event;
import models.User;
import utils.FileUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EventService {
    private List<Event> events;
    private Scanner sc;

    public EventService(Scanner sc) {
        this.sc = sc;
        this.events = FileUtils.loadEvents();
    }

    public void createEvent() {
        System.out.println("=== Cadastro de Evento ===");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Endereço: ");
        String address = sc.nextLine();
        System.out.print("Categoria (Festa, Show, Esporte, Outro): ");
        String category = sc.nextLine();
        System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
        LocalDateTime dateTime = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.print("Descrição: ");
        String description = sc.nextLine();

        Event event = new Event(name, address, category, dateTime, description);
        events.add(event);
        FileUtils.saveEvents(events);
        System.out.println("Evento cadastrado com sucesso!\n");
    }

    public void listEvents() {
        System.out.println("=== Lista de Eventos ===");
        events.sort(Comparator.comparing(Event::getDateTime));
        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            System.out.println((i + 1) + " - " + e + (e.isHappeningNow() ? " [Acontecendo agora]" : "") + (e.hasPassed() ? " [Já ocorreu]" : ""));
        }
        System.out.println();
    }

    public void attendEvent(User user) {
        listEvents();
        System.out.print("Escolha o número do evento para participar: ");
        int choice = Integer.parseInt(sc.nextLine()) - 1;
        if (choice >= 0 && choice < events.size()) {
            user.attendEvent(events.get(choice));
            System.out.println("Você agora está participando do evento.\n");
        }
    }

    public void cancelParticipation(User user) {
        List<Event> attending = user.getAttendingEvents();
        if(attending.isEmpty()) {
            System.out.println("Você não está participando de nenhum evento.\n");
            return;
        }
        for (int i = 0; i < attending.size(); i++) {
            System.out.println((i + 1) + " - " + attending.get(i));
        }
        System.out.print("Escolha o número do evento para cancelar participação: ");
        int choice = Integer.parseInt(sc.nextLine()) - 1;
        if (choice >= 0 && choice < attending.size()) {
            user.cancelEvent(attending.get(choice));
            System.out.println("Participação cancelada.\n");
        }
    }

    public void showUserEvents(User user) {
        List<Event> attending = user.getAttendingEvents();
        System.out.println("=== Eventos que você participa ===");
        if(attending.isEmpty()) {
            System.out.println("Nenhum evento.");
        } else {
            attending.forEach(System.out::println);
        }
        System.out.println();
    }
}
