package com.rpg.main;

import com.rpg.characters.Player;
import com.rpg.mechanics.GameStart;

public class Main
{
    public static void main(String[] args)
    {
        String characterName = GameStart.characterGetName();
        Player player = GameStart.getPlayer("Types.json", characterName);
        System.out.println(player.toString());
        GameStart.Continue();
    }
}