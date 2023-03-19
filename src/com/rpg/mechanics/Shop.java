package com.rpg.mechanics;

import com.rpg.characters.Player;

import java.util.Random;
import java.util.Scanner;

public class Shop
{
    private static final Scanner scanner = new Scanner(System.in);

    private static void shopPrint(Player player)
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Welcome to the shop!");
        System.out.println(player.toString());
        System.out.println("""
                your options for the shop are:
                1. boost your stats for gold
                2. create new attacks(if you are eligable)
                -1. exit
                """);
    }

    public static void Shop(Player player)
    {
        int choice = 0;
        while (choice >= 0)
        {
        }
    }
}
