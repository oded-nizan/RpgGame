package com.rpg.main;

import com.rpg.characters.Player;
import com.rpg.mechanics.GameStart;
import com.rpg.mechanics.MainMenu;

public class Main
{
    public static void main(String[] args)
    {
        String characterName = GameStart.characterGetName();
        Player player = GameStart.getPlayer("PlayerTypes.json", characterName);
        System.out.println(player.toString());
        GameStart.Continue();
        MainMenu.mainMenu(player);
    }
}