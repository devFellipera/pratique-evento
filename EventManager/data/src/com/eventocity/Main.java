/**
 * Projeto: CityEvents
 * Disciplina: Atividade Pratique
 * Autor: Felipe Oliveira
 */

import services.EventService;
import services.UserService;
import models.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService(sc);
        EventService eventService = new EventService(sc);

        User user = userService.registerUser();

        while(true) {
            System.out.println("=== Menu ===");
            System.out.println("1 - Cadastrar Evento");
            System.out.println("2 - Listar Eventos");
            System.out.println("3 - Participar de Evento");
            System.out.println("4 - Cancelar Participação");
            System.out.println("5 - Meus Eventos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            String option = sc.nextLine();

            switch(option) {
                case "1": eventService.createEvent(); break;
                case "2": eventService.listEvents(); break;
                case "3": eventService.attendEvent(user); break;
                case "4": eventService.cancelParticipation(user); break;
                case "5": eventService.showUserEvents(user); break;
                case "0": System.out.println("Saindo..."); return;
                default: System.out.println("Opção inválida."); break;
            }
        }
    }
}
