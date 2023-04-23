package com.rpg.mechanics;

import com.rpg.characters.Attack;
import com.rpg.characters.Character;
import com.rpg.characters.Player;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class CreateOtherPlayer
{

    private static final Random random = new Random();
    public static Character randomPlayerGenerator(Player player, String fileName) {
        String name = "Opponent";
        int id = random.nextInt(1, 12);
        int health = random.nextInt(player.getHealth() - 500, player.getHealth() + 500);
        int damage = random.nextInt(player.getDamage() - 50, player.getDamage() + 50);
        int armor = random.nextInt(player.getArmor() - 5, player.getArmor() + 5);
        int accuracy = random.nextInt(player.getAccuracy() - 20, player.getAccuracy() + 20);

        ArrayList<JSONObject> charList = Essentials.getCharacterArray(fileName, "TypesArray");
        JSONObject none = new JSONObject();
        JSONObject finalChar = new JSONObject();
        for (JSONObject jsonObject : charList) {
            int charId = (int) (long) jsonObject.get("id");
            if (charId == id) {
                finalChar = jsonObject;
            }
        }

        String attack1Name = (String) finalChar.get("attack1Name");
        int attack1Damager = (int) (long) finalChar.get("attack1Damager");
        int attack1ArmorPenetration = (int) (long) finalChar.get("attack1ArmorPenetration");
        String attack1Type = (String) finalChar.get("attack1Type");
        Attack finalCharAttack1 = new Attack(attack1Name, attack1Damager, attack1ArmorPenetration, attack1Type);

        String attack2Name = (String) finalChar.get("attack2Name");
        int attack2Damager = (int) (long) finalChar.get("attack2Damager");
        int attack2ArmorPenetration = (int) (long) finalChar.get("attack2ArmorPenetration");
        String attack2Type = (String) finalChar.get("attack2Type");
        Attack finalCharAttack2 = new Attack(attack2Name, attack2Damager, attack2ArmorPenetration, attack2Type);

        String attack3Name = (String) finalChar.get("attack3Name");
        int attack3Damager = (int) (long) finalChar.get("attack3Damager");
        int attack3ArmorPenetration = (int) (long) finalChar.get("attack3ArmorPenetration");
        String attack3Type = (String) finalChar.get("attack3Type");
        Attack finalCharAttack3 = new Attack(attack3Name, attack3Damager, attack3ArmorPenetration, attack3Type);

        String type = (String) finalChar.get("type");

        Character otherPlayer = new Character(name, health, armor, damage, accuracy, finalCharAttack1, finalCharAttack2, finalCharAttack3, type, id);
        return otherPlayer;
    }
}
