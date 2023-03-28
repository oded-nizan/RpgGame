package com.rpg.mechanics;

import com.rpg.characters.Attack;
import com.rpg.characters.Player;

import java.util.Random;
import java.util.Scanner;

public class Shop
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int price = 100;

    private static void shopPrint(Player player)
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Welcome to the shop!");
        System.out.println(player.toString());
        System.out.println("""
                your options for the shop are:
                1: increase your health by a random 50-250
                2: increase your armor by a random 2-5
                3: increase your damage by a random 10-15
                4: increase your accuracy by a random 5-10
                5: check if you are eligible for a new attack;
                -1. exit the shop
                *** The price for options 1-4 is :
                """ + price);
    }

    private static void shop1(Player player)
    {
        if (player.getGold() < price)
        {
            System.out.println("You don't have enough gold please return to the shop when you have the cash!");
            return;
        }

        System.out.println("You have " + player.getGold() + " gold, this purchase will cost you " + price + " gold");
        System.out.println("Enter true to confirm purchase or false to cancel: ");
        boolean confirm = scanner.nextBoolean();

        if (!confirm)
        {
            System.out.println("you hava canceled you purchase");
            return;
        }

        player.setGold(player.getGold() - price);
        player.setHealth(player.getHealth() + random.nextInt(50, 250));
        System.out.println("The purchase has came through!");
        System.out.println(player.toString());
    }

    private static void shop2(Player player)
    {
        if (player.getGold() < price)
        {
            System.out.println("You don't have enough gold please return to the shop when you have the cash!");
            return;
        }

        System.out.println("You have " + player.getGold() + " gold, this purchase will cost you " + price + " gold");
        System.out.println("Enter true to confirm purchase or false to cancel: ");
        boolean confirm = scanner.nextBoolean();

        if (!confirm)
        {
            System.out.println("you hava canceled you purchase");
            return;
        }

        player.setGold(player.getGold() - price);
        player.setArmor(player.getArmor() + random.nextInt(2, 5));
        System.out.println("The purchase has came through!");
        System.out.println(player.toString());
    }

    private static void shop3(Player player)
    {
        if (player.getGold() < price)
        {
            System.out.println("You don't have enough gold please return to the shop when you have the cash!");
            return;
        }

        System.out.println("You have " + player.getGold() + " gold, this purchase will cost you " + price + " gold");
        System.out.println("Enter true to confirm purchase or false to cancel: ");
        boolean confirm = scanner.nextBoolean();

        if (!confirm)
        {
            System.out.println("you hava canceled you purchase");
            return;
        }

        player.setGold(player.getGold() - price);
        player.setDamage(player.getDamage() + random.nextInt(10, 15));
        System.out.println("The purchase has came through!");
        System.out.println(player.toString());
    }

    private static void shop4(Player player)
    {
        if (player.getGold() < price)
        {
            System.out.println("You don't have enough gold please return to the shop when you have the cash!");
            return;
        }

        System.out.println("You have " + player.getGold() + " gold, this purchase will cost you " + price + " gold");
        System.out.println("Enter true to confirm purchase or false to cancel: ");
        boolean confirm = scanner.nextBoolean();

        if (!confirm)
        {
            System.out.println("you hava canceled you purchase");
            return;
        }

        player.setGold(player.getGold() - price);
        player.setAccuracy(player.getAccuracy() + random.nextInt(5, 10));
        System.out.println("The purchase has came through!");
        System.out.println(player.toString());
    }


    private static void checkMaxStats(Player player)
    {
        player.maxStats();
        if (player.getIsMaxedStats())
        {
            System.out.println("You have maxed out all of your stats");
        }
    }

    public static void BuyShop(Player player)
    {
        int choice;
        boolean continueShopping = true;
        while (continueShopping)
        {
            shopPrint(player);
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    shop1(player);
                    checkMaxStats(player);
                    break;

                case 2:
                    shop2(player);
                    checkMaxStats(player);
                    break;

                case 3:
                    shop3(player);
                    checkMaxStats(player);
                    break;

                case 4:
                    shop4(player);
                    checkMaxStats(player);
                    break;

                case 5:
                    int ment = player.getAttacks().toArray().length - 2;
                    if (player.getLvl() > ment)
                    {
                        System.out.println("You are eligible for a new attack!");
                        System.out.println("Enter your attack's name : ");
                        String attackName = scanner.nextLine();
                        int attackDamage = random.nextInt(1, 10);
                        int attackArmorPenetration = random.nextInt(1, 10);
                        String attackType = player.getType();
                        Attack newAttack = new Attack(attackName, attackDamage, attackArmorPenetration, attackType);
                        System.out.println(newAttack.toString());
                        player.setAttacksAdd(newAttack);
                        System.out.println(player.toString());
                    }
                    else
                    {
                        System.out.println("You are not eligible for a new attack");
                    }


                case -1:
                    continueShopping = false;
                    break;

                default:
                    System.out.println("You have inputted an illegal input please try again");
            }
        }
    }
}
