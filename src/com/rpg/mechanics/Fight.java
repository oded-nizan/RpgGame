package com.rpg.mechanics;

import com.rpg.characters.Attack;
import com.rpg.characters.Enemy;
import com.rpg.characters.Player;

import java.util.Random;
import java.util.Scanner;

public class Fight
{
    private final static Random random = new Random();
    private final static Scanner scanner = new Scanner(System.in);

    private static int playerDamage(Player player, Enemy enemy, Attack playerAttack)
    {
        int damage = player.getDamage() * playerAttack.getDamager();
        int ar = enemy.getArmor() - playerAttack.getArmorPenetration();
        int arf = 100 - ar;
        int damagef = (damage * arf) / 100;
        return damagef;
    }

    private static int enemyDamage(Player player, Enemy enemy, Attack enemyAttack)
    {
        int damage = enemy.getDamage() * enemyAttack.getDamager();
        int ar = player.getArmor() - enemyAttack.getArmorPenetration();
        int arf = 100 - ar;
        int damagef = (damage * arf) / 100;
        return damagef;
    }

    private static int playerAttack(Player player, Enemy enemy)
    {
        System.out.println("It is your turn to attack!");
        int choice = -1;
        while(choice < player.getAttacks().toArray().length + 1 && choice > 0) {
            System.out.println("Please enter the number of the attack you would like to choose(1-" + player.getAttacks().toArray().length + " : ");
            choice = scanner.nextInt();
            if (choice < 1 || choice > player.getAttacks().toArray().length)
            {
                System.out.println("You have entered an invalid number");
            }
        }
        Attack playerAttack = player.getAttacks().get(choice - 1);
        System.out.println(playerAttack.toString());

        if (player.isHit())
        {
            System.out.println("You have hit the enemy with your attack!");
            int damage = playerDamage(player, enemy, playerAttack);
            System.out.println("You have inputted " + damage + " damage to your enemy!");
            return damage;
        }
        else
        {
            System.out.println("You have missed! try next time");
            return 0;
        }
    }

    private static int enemyAttack(Player player, Enemy enemy)
    {
        System.out.println("Your enemy is now attacking!");
        int attackNo = random.nextInt(2) + 1;
        Attack enemyAttack = enemy.getAttacks().get(attackNo);
        System.out.println("Your enemy has chose their attack!");
        System.out.println(enemyAttack.toString());

        if (enemy.isHit())
        {
            System.out.println("Your enemy has hit you!");
            int damage = enemyDamage(player, enemy, enemyAttack);
            System.out.println("Your enemy has inputted " + damage + " damage");
            return damage;
        }
        else
        {
            System.out.println("Your enemy has missed!!");
            return 0;
        }
    }

    public static boolean WhoWon(Player player, Enemy enemy)
    {
        int playerHealth = player.getHealth();
        int enemyHealth = enemy.getHealth();
        while (playerHealth > 0 && enemyHealth > 0)
        {
            int enemyDamage = playerAttack(player, enemy);
            enemyHealth -= enemyDamage;

            int playerDamage = enemyAttack(player, enemy);
            playerHealth -= playerDamage;
        }
        if (playerHealth > 0)
        {
            return true;
        }
        return false;
    }
}
