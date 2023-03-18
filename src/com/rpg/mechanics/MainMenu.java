package com.rpg.mechanics;

import com.rpg.characters.Player;

import java.util.Scanner;

public class MainMenu
{
    private final static Scanner scanner = new Scanner(System.in);

    public static void mainMenu(Player player)
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

        int choice = 0;
        while (choice != -1)
        {
           choice = scanner.nextInt();

           switch (choice)
           {
               case 1:
                   Fight.enemyFight(player, "Enemies.json");
                   break;

               case 2:
                   Fight.playerFight(player, "PlayerTypes.json");
                   break;


           }
        }
    }
}
