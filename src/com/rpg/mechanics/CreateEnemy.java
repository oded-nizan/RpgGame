package com.rpg.mechanics;


import com.rpg.characters.Attack;
import com.rpg.characters.Enemy;
import com.rpg.characters.Player;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Random;


public class CreateEnemy
{

    private final static Random random = new Random();
    private static JSONObject geyEnemyObject(String fileName)
    {
        int x = random.nextInt(3) + 1;
        ArrayList<JSONObject> charList = Essentials.getCharacterArray(fileName, "enemyTypes");
        JSONObject none = new JSONObject();
        for (JSONObject jsonObject:charList)
        {
            int charId = (int) (long) jsonObject.get("id");
            if (charId == x)
            {
                return jsonObject;
            }
        }
        System.out.println("There has been a mistake, please exit the program");
        return none;
    }

    public static Enemy createEnemy(String fileName, Player player)
    {
        JSONObject enemyJsonObject = geyEnemyObject(fileName);

        int enemyId = (int) (long) enemyJsonObject.get("id");
        String enemyType = (String) enemyJsonObject.get("Type");

        String attack1Name = (String) enemyJsonObject.get("attack1Name");
        int attack1Damager = (int) (long) enemyJsonObject.get("attack1Damager");
        int attack1ArmorPenetration = (int) (long) enemyJsonObject.get("attack1ArmorPenetration");
        String attack1Type = (String) enemyJsonObject.get("attack1Type");
        Attack enemyAttack1 = new Attack(attack1Name, attack1Damager, attack1ArmorPenetration, attack1Type);

        String attack2Name = (String) enemyJsonObject.get("attack2Name");
        int attack2Damager = (int) (long) enemyJsonObject.get("attack2Damager");
        int attack2ArmorPenetration = (int) (long) enemyJsonObject.get("attack2ArmorPenetration");
        String attack2Type = (String) enemyJsonObject.get("attack2Type");
        Attack enemyAttack2 = new Attack(attack2Name, attack2Damager, attack2ArmorPenetration, attack2Type);

        String attack3Name = (String) enemyJsonObject.get("attack3Name");
        int attack3Damager = (int) (long) enemyJsonObject.get("attack3Damager");
        int attack3ArmorPenetration = (int) (long) enemyJsonObject.get("attack3ArmorPenetration");
        String attack3Type = (String) enemyJsonObject.get("attack3Type");
        Attack enemyAttack3 = new Attack(attack3Name, attack3Damager, attack3ArmorPenetration, attack3Type);

        Enemy enemy = new Enemy(enemyId, enemyType, enemyAttack1, enemyAttack2, enemyAttack3, player);

        return enemy;
    }
}
