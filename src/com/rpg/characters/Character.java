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
    private final String resistType;
    private Attack attack1;
    private Attack attack2;
    private Attack attack3;
    private Attack attack4;
    private Attack attack5;
    private Attack attack6;
    private Attack attack7;
    private Attack attack8;
    private ArrayList<Attack> attacks = new ArrayList<>(3);
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
        this.setAttacksInitial();
        this.resistType = resistType;
        this.type = type;
        this.id = id;
    }

    // A constructor to be a super for the npc class
    public Character(int id, String type, String resistType, Attack attack1, Attack attack2, Attack attack3, Attack attack4)
    {
        this.id = id;
        this.type = type;
        this.resistType = resistType;
        this.setAttack1(attack1);
        this.setAttack2(attack2);
        this.setAttack3(attack3);
        this.setAttack4(attack4);
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
        if (health < 0)
        {
            this.health = 1;
        }
        else if (health > 5000)
        {
            this.health = 5000;
        }
        else
        {
            this.health = health;
        }
    }

    public void setArmor(int armor)
    {
        if (armor < 0)
        {
            this.armor = 0;
        }
        else if (armor > 25)
        {
            this.armor = 25;
        }
        else
        {
            this.armor = armor;
        }
    }

    public void setDamage(int damage)
    {
        if (damage <= 0)
        {
            this.damage = 1;
        }
        else if (damage >= 250)
        {
            this.damage = 250;
        }
        else
        {
            this.damage = damage;
        }
    }

    public void setAccuracy(int accuracy)
    {
        if (accuracy < 0)
        {
            this.accuracy = 1;
        }
        else if (accuracy > 100)
        {
            this.accuracy = 100;
        }
        else
        {
            this.accuracy = accuracy;
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
        this.setAttacksAdd(attack4);
    }

    public void setAttack5(Attack attack5)
    {
        this.attack5 = attack5;
        this.setAttacksAdd(attack5);
    }

    public void setAttack6(Attack attack6)
    {
        this.attack6 = attack6;
        this.setAttacksAdd(attack6);
    }

    public void setAttack7(Attack attack7)
    {
        this.attack7 = attack7;
        this.setAttacksAdd(attack7);
    }

    public void setAttack8(Attack attack8)
    {
        this.attack8 = attack8;
        this.setAttacksAdd(attack8);
    }

    public void setAttacksInitial()
    {
        this.attacks.add(this.attack1);
        this.attacks.add(this.attack2);
        this.attacks.add(this.attack3);
    }

    public void setAttacksAdd(Attack newAttack)
    {
        this.attacks.add(newAttack);
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
        StringBuilder add = new StringBuilder();
        for (int i = 0; i < this.getAttacks().toArray().length; i++)
        {
            add.append(this.getAttacks().get(i).toString()).append("\n");
        }
        toString = toString + add;
        return toString;
    }
}
