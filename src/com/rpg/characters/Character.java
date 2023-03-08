package com.rpg.characters;

import java.util.ArrayList;
import java.util.Random;

public class Character
{
    private String name;
    private int health;
    private int armor;
    private int damage;
    private int accuracy;
    private String resistType;
    private ArrayList<Attack> attacks;
    private final String type;
    private final int id;

    public Character(String name, int health, int armor, int damage, int accuracy, String resistType, ArrayList<Attack> attacks, String type, int id)
    {
        this.setName(name);
        this.setHealth(health);
        this.setArmor(armor);
        this.setDamage(damage);
        this.setAccuracy(accuracy);
        this.setAttacks(attacks);
        this.setResistType(resistType);
        this.type = type;
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getHealth()
    {
        return this.health;
    }

    public int getArmor()
    {
        return this.armor;
    }

    public int getDamage()
    {
        return this.damage;
    }

    public int getAccuracy()
    {
        return this.accuracy;
    }

    public String getResistType()
    {
        return this.resistType;
    }

    public ArrayList<Attack> getAttacks()
    {
        return this.attacks;
    }

    public String getType()
    {
        return this.type;
    }

    public int getId()
    {
        return this.id;
    }

    public void setName(String name)
    {
        if (name.length() >= 2 && name.length() <= 12)
        {
            this.name = name;
        }
    }

    public void setHealth(int health)
    {
        if (health >= 0 && health <= 5000)
        {
            this.health = health;
        }
    }

    public void setArmor(int armor)
    {
        if (armor >= 0 && armor <= 25)
        {
            this.armor = armor;
        }
    }

    public void setDamage(int damage)
    {
        if (damage >= 0 && damage <= 250)
        {
            this.damage = damage;
        }
    }

    public void setAccuracy(int accuracy)
    {
        if (accuracy >= 1 && accuracy <= 100)
        {
            this.accuracy = accuracy;
        }
    }

    public void setResistType(String resistType)
    {
        switch (resistType)
        {
            case "Magical", "Physical", "Elemental", "Chemical" -> this.resistType = resistType;
            default -> System.out.println("Invalid input");
        }
    }

    public void setAttacks(ArrayList<Attack> attacks)
    {
        this.attacks = attacks;
    }

    public boolean isHit()
    {
        Random randomNum = new Random();
        int x = randomNum.nextInt(100);
        return x <= this.accuracy;
    }

    public String toString()
    {
        String toString = "The character's name is : " + this.name + "\n";
        toString = toString + "The character's health is : " + this.health + "\n";
        toString = toString + "The character's armor is : " + this.armor + "\n";
        toString = toString + "The character's damage is : " + this.damage + "\n";
        toString = toString + "The character's accuracy is : " + this.accuracy + "\n";
        toString = toString + "The character's attacks are : " + this.attacks + "\n";
        return toString;
    }
}
