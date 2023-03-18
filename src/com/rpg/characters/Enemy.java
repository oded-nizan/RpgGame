package com.rpg.characters;

import java.util.Random;

public class Enemy extends Character
{

    static Random random = new Random();
    public Enemy(int id, String type, Attack attack1, Attack attack2, Attack attack3, Player player)
    {
        super(id, type, attack1, attack2, attack3);
        this.randomHealth(player.getHealth() - 500, player.getHealth() + 500);
        this.randomArmor(player.getArmor() - 5, player.getArmor() + 5);
        this.randomDamage(player.getDamage() - 50, player.getDamage() + 50);
        this.randomAccuracy(player.getAccuracy() - 20, player.getAccuracy() + 20);
    }

    public void randomHealth(int min, int max)
    {
        int newHealth = random.nextInt(max-min) + min;
        this.setHealth(newHealth);
    }

    public void randomArmor(int min, int max)
    {
        int newArmor = random.nextInt(max-min) + min;
        this.setArmor(newArmor);
    }

    public void randomDamage(int min, int max)
    {
        int newDamage = random.nextInt(max-min) + min;
        this.setDamage(newDamage);
    }

    public void randomAccuracy(int min, int max)
    {
        int newAccuracy = random.nextInt(max-min) + min;
        this.setAccuracy(newAccuracy);
    }
}
