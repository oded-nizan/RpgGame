package com.rpg.mechanics;

import com.rpg.characters.Player;

import java.util.Scanner;

public class MainMenu
{
    private final static Scanner scanner = new Scanner(System.in);

    private static void mainMenuPrint()
    {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("You can now choose your next move in the game");
        System.out.println("You have 4 options:");
        System.out.println("""
                1: fight an enemy and if you win you will collect gold and xp!
                2: fight an opponent player and have a chance for rewards!
                3: go to shop and advance your player
                -1: to exit the program enter -1
                Please do not enter a number that is not one of the options!!
                """);
    }

    public static void mainMenu(Player player)
    {
        int choice;
        boolean continueMain = true;
        while (continueMain)
        {
            mainMenuPrint();
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Fight.enemyFight(player, "Enemies.json");
                case 2 -> Fight.playerFight(player, "PlayerTypes.json");
                case 3 -> Shop.BuyShop(player);
                case -1 -> continueMain = false;
                default -> System.out.println("You have entered an invalid input");
            }
        }
    }
}
