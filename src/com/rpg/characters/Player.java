package com.rpg.characters;

public class Player extends Character
{
    private int XP;
    private int lvl;
    private boolean isMaxedLvl;
    private int gold;
    private boolean isMaxedStats;

    public Player(String name, int health, int armor, int damage, int accuracy, Attack attack1, Attack attack2, Attack attack3, String type, int id)
    {
        super(name, health, armor, damage, accuracy, attack1, attack2, attack3, type, id);
        this.setGold(0);
        this.setXP(0);
        this.setLvl(1);
        this.maxLvl();
        this.maxStats();
    }


    public int getXP()
    {
        return this.XP;
    }

    public void setXP(int XP){
        if (XP >= 0 && XP <= 2500)
        {
            this.XP = XP;
        }

        if (this.XP > 500)
        {
            this.XP -= 500;
            this.setLvl(this.getLvl() + 1);
        }
    }

    public int getLvl()
    {
        return this.lvl;
    }

    public void setLvl(int lvl)
    {
        if (lvl >= 1 && lvl  <= 20)
        {
            this.lvl = lvl;
        }
    }

    public boolean getIsMaxedLvl()
    {
        return this.isMaxedLvl;
    }

    public void setIsMaxedLvl(boolean isMaxedLvl)
    {
        this.isMaxedLvl = isMaxedLvl;
    }

    public int getGold()
    {
        return this.gold;
    }

    public void setGold(int gold)
    {
        if (gold >= 0)
        {
            this.gold = gold;
        }
    }

    public boolean bought()
    {
        if (this.gold >= 100)
        {
            int current = this.getGold();
            int newGold = current - 100;
            this.setGold(newGold);
            return true;
        }
        else
        {
            System.out.println("You do not have enough gold!");
            return false;
        }
    }

    public boolean getIsMaxedStats()
    {
        return this.isMaxedStats;
    }

    public void setIsMaxedStats(boolean isMaxedStats)
    {
        this.isMaxedStats = isMaxedStats;
    }

    public void buyHealth()
    {
        int current = this.getHealth();
        int newHealth = current + 250;
        this.setHealth(newHealth);
        System.out.println("Your health was increased by 250. It is now : " + this.getHealth());
    }

    public void buyArmor()
    {
        int current = this.getArmor();
        int newHealth = current + 5;
        this.setArmor(newHealth);
        System.out.println("Your armor was increased by 5. It is now : " + this.getArmor());
    }

    public void buyDamage()
    {
        int current = this.getDamage();
        int newHealth = current + 15;
        this.setDamage(newHealth);
        System.out.println("Your Damage was increased by 15. It is now : " + this.getDamage());
    }

    public void buyAccuracy()
    {
        int current = this.getAccuracy();
        int newHealth = current + 5;
        this.setAccuracy(newHealth);
        System.out.println("Your Accuracy was increased by 5%. It is now : " + this.getAccuracy());
    }

    public void maxLvl()
    {
        if (this.lvl >= 6)
        {
            this.lvl = 6;
            this.isMaxedLvl = true;
        }
        this.isMaxedLvl = false;
    }

    public void maxStats()
    {
        isMaxedStats = true;

        if (this.getHealth() >= 5000)
        {
            this.setHealth(5000);
        }
        else
        {
            isMaxedStats = false;
        }

        if (this.getArmor() >= 25)
        {
            this.setArmor(25);
        }
        else
        {
            isMaxedStats = false;
        }

        if (this.getAccuracy() >= 100)
        {
            this.setAccuracy(100);
        }
        else
        {
            isMaxedStats = false;
        }

        if (this.getDamage() >= 250)
        {
            this.setDamage(250);
        }
        else
        {
            isMaxedStats = false;
        }
    }

    public String toString()
    {
        String toString = super.toString();
        toString = toString + "The player's XP is : " + this.XP + "\n";
        toString = toString + "The player's level is : " + this.lvl + "\n";
        toString = toString + "The player's gold is : " + this.gold + "\n";
        if (isMaxedLvl)
        {
            toString = toString + "The player is on the maximum level!" + "\n";
        }
        if (isMaxedStats)
        {
            toString = toString + "The player has maxed out their stats!" + "\n";
        }
        return toString;
    }
}
