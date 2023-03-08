package com.rpg.characters;
public class Attack
{
    private String name;
    private int damager;
    private int armorPenetration;
    private String type;

    public Attack(String name, int damager, int armorPenetration, String type)
    {
        this.setName(name);
        this.setDamager(damager);
        this.setArmorPenetration(armorPenetration);
        this.setType(type);
    }

    public String getName()
    {
        return this.name;
    }

    public int getDamager()
    {
        return this.damager;
    }

    public int getArmorPenetration()
    {
        return this.armorPenetration;
    }

    public String getType()
    {
        return this.type;
    }

    public void setName(String name)
    {
        if (name.length() >= 2 && name.length() <= 15){
            this.name = name;
        }
    }

    public void setDamager(int damager)
    {
        if (damager > 0 && damager <= 12){
            this.damager = damager;
        }
    }

    public void setArmorPenetration(int armorPenetration)
    {
        if (armorPenetration >= 0 && armorPenetration <= 10){
            this.armorPenetration = armorPenetration;
        }
    }

    public void setType(String type)
    {
        switch (type)
        {
            case "Magical", "Physical", "Elemental", "Chemical" -> this.type = type;
            default -> System.out.println("Invalid input");
        }
    }

    public String toString()
    {
        String toString = "The attack's name is : " + this.name + "\n";
        toString = toString + "The attack's damager stats is : " + this.damager + "\n";
        toString = toString + "The attack's armor penetration stat is : " + this.armorPenetration + "\n";
        return toString;
    }
}
