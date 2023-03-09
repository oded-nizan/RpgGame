package com.rpg.characters;

import java.util.Random;

public class NPC extends Character
{

    static Random random = new Random();
    public NPC(int id, String type, String resistType, Attack attack1, Attack attack2, Attack attack3, Attack attack4, Player player)
    {
        super(id, type, resistType, attack1, attack2, attack3, attack4);
        randomHealth(this.getHealth() - 500, this.getHealth() + 500);
        randomArmor(this.getArmor() - 5, this.getArmor() + 5);
        randomDamage(this.getDamage() - 50, this.getDamage() + 50);
        randomAccuracy(this.getAccuracy() - 20, this.getAccuracy() + 20);
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
