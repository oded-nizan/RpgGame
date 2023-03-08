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
    private Attack attack1;
    private Attack attack2;
    private Attack attack3;
    private Attack attack4;
    private Attack attack5;
    private Attack attack6;
    private Attack attack7;
    private Attack attack8;
    private final String type;
    private final int id;

    public Character(String name, int health, int armor, int damage, int accuracy, String resistType, Attack attack1, Attack attack2, Attack attack3, String type, int id)
    {
        this.setName(name);
        this.setHealth(health);
        this.setArmor(armor);
        this.setDamage(damage);
        this.setAccuracy(accuracy);
        this.setAttack1(attack1);
        this.setAttack2(attack2);
        this.setAttack3(attack3);
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
        ArrayList<Attack> attacks = new ArrayList<>();
        attacks.add(this.attack1);
        attacks.add(this.attack2);
        attacks.add(this.attack3);
        attacks.add(this.attack4);
        attacks.add(this.attack5);
        attacks.add(this.attack6);
        attacks.add(this.attack7);
        attacks.add(this.attack8);
        return attacks;
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

    public void setAttack1(Attack attack1)
    {
        this.attack1 = attack1;
    }

    public void setAttack2(Attack attack2)
    {
        this.attack2 = attack2;
    }

    public void setAttack3(Attack attack3)
    {
        this.attack3 = attack3;
    }

    public void setAttack4(Attack attack4)
    {
        this.attack4 = attack4;
    }

    public void setAttack5(Attack attack5)
    {
        this.attack5 = attack5;
    }

    public void setAttack6(Attack attack6)
    {
        this.attack6 = attack6;
    }

    public void setAttack7(Attack attack7)
    {
        this.attack7 = attack7;
    }

    public void setAttack8(Attack attack8)
    {
        this.attack8 = attack8;
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
        toString = toString + "The character's attacks are : " + this.getAttacks() + "\n";
        return toString;
    }
}
