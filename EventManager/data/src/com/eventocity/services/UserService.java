/**
 * Projeto: CityEvents
 * Disciplina: Atividade Pratique
 * Autor: Felipe Oliveira
 */

package services;

import java.util.Scanner;
import models.User;

public class UserService {
    private User user;
    private Scanner sc;

    public UserService(Scanner sc) {
        this.sc = sc;
    }

    public User registerUser() {
        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Idade: ");
        int age = Integer.parseInt(sc.nextLine());
        user = new User(name, email, age);
        System.out.println("Usuário cadastrado com sucesso!\n");
        return user;
    }

    public User getUser() {
        return user;
    }
}
