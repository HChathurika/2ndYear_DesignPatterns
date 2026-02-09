package game;

import game.character.GameCharacter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        GameCharacter character = new GameCharacter(name);

        while (!(character.getLevel() == 4)) { // 4 = Master
            character.printStatus();

            System.out.println("Choose an action:");
            System.out.println("1. Train");
            System.out.println("2. Meditate");
            System.out.println("3. Fight");
            System.out.print("Action: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> character.train();
                case 2 -> character.meditate();
                case 3 -> character.fight();
                default -> System.out.println("Invalid action!");
            }
        }

        System.out.println("\nCongratulations! " + character.getName() + " is now a Master!");
        scanner.close();
    }
}
