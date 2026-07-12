package services;

import model.Character;

import java.util.Scanner;

public class Controller {

    private final Scanner scanner = new Scanner(System.in);

    public Character add() {

        Character character = new Character();

        System.out.println("Name: ");
        character.setName(scanner.next());

        System.out.println("HP: ");
        character.setHP(scanner.nextInt());

        return character;
    }
}
