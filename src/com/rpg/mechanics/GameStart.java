package com.rpg.mechanics;

import com.rpg.characters.Attack;
import com.rpg.characters.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GameStart
{
    static Scanner input = new Scanner(System.in);
    static JSONParser parser = new JSONParser();

    private static String getFilePath(String fileName)
    {
        File filePathFile = new File("src/com/rpg/resources");
        String filePath = filePathFile.getAbsolutePath() + "/" + fileName;
        return filePath;
    }
    private static JSONArray parseJson(String filePath)
    {
        JSONObject jsonObject;
        JSONArray TypesArray = new JSONArray();
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(filePath));
            TypesArray = (JSONArray) jsonObject.get("TypesArray");
        }
        catch (Exception e)
        {
            System.out.println("There has been an error");
            e.printStackTrace();
            System.exit(0);
        }
        return TypesArray;
    }

    private static ArrayList<JSONObject> getCharacterArray(String fileName)
    {
        String filePath = getFilePath(fileName);
        JSONArray TypesArray = parseJson(filePath);
        JSONObject jsonObject;
        ArrayList<JSONObject> charList = new ArrayList<>();
        for (Object o : TypesArray)
        {
            jsonObject = (JSONObject) o;
            charList.add(jsonObject);
        }
        return charList;
    }

    private static JSONObject getCharacterObject(String fileName, int chosen)
    {
        ArrayList<JSONObject> charList = getCharacterArray(fileName);
        JSONObject none = new JSONObject();
        for (JSONObject jsonObject:charList)
        {
            int charId = (int) jsonObject.get("id");
            if (charId == chosen)
            {
                return jsonObject;
            }
        }
        System.out.println("There has been a mistake, please exit the program");
        return none;
    }

    private static int characterMenu()
    {
        System.out.println("-----------------------------------------------------");
        System.out.println("You will be presented with options, please type the number of your choice... ");
        System.out.println("The type of each character type will be presented as such: (P) = Physical, (M) = Magical, (C) = Chemical, (E) = Elemental");
        System.out.println("""
                1: Barbarian(P)
                2: Wizard(M)
                3: Monk(P)
                4: Druid(E)
                5: Alchemist(C)
                6: Sorcerer(M)
                7: Apprentice(C)
                8: Ranger(E)
                9: Shaman(C)
                10: Warden(P)
                11: Ardent(E)
                12: Visoner(M)
                """);
        System.out.println("---------------------------------------------------");
        System.out.println("Enter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    private static String characterGetName()
    {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Please enter your character's name : ");
        String result = input.nextLine();
        return result;
    }

    public static Player getPlayer(String fileName)
    {
        int choice = characterMenu();
        JSONObject character = getCharacterObject(fileName, choice);
        String characterName = characterGetName();
        int characterHealth = 200;
        int characterArmor = (int) character.get("armor");
        int characterDamage = (int) character.get("damage");
        int characterAccuracy = (int) character.get("accuracy");
        String attack1Name = (String) character.get("attack1Name");
        int attack1Damager = (int) character.get("attack1Damager");
        int attack1ArmorPenetration = (int) character.get("attack1ArmorPenetration");
        String attack1Type = (String) character.get("attack1Type");
        Attack characterAttack1 = new Attack(attack1Name, attack1Damager, attack1ArmorPenetration, attack1Type);
        String attack2Name = (String) character.get("attack2Name");
        int attack2Damager = (int) character.get("attack2Damager");
        int attack2ArmorPenetration = (int) character.get("attack2ArmorPenetration");
        String attack2Type = (String) character.get("attack2Type");
        Attack characterAttack2 = new Attack(attack2Name, attack2Damager, attack2ArmorPenetration, attack2Type);
        String attack3Name = (String) character.get("attack3Name");
        int attack3Damager = (int) character.get("attack3Damager");
        int attack3ArmorPenetration = (int) character.get("attack3ArmorPenetration");
        String attack3Type = (String) character.get("attack3Type");
        Attack characterAttack3 = new Attack(attack3Name, attack3Damager, attack3ArmorPenetration, attack3Type);
        String characterResistType = (String) character.get("resistType");
        String characterType = (String) character.get("type");
        int characterId = (int) character.get("id");
        Player player = new Player(characterName, characterHealth, characterArmor, characterDamage, characterAccuracy, characterResistType, characterAttack1, characterAttack2, characterAttack3, characterType, characterId);
        return player;
    }

    public static void Continue()
    {
        System.out.println("Congratulations! You have successfully created your player character and are now ready to play!");
        System.out.println("Please enter true to continue or false to exit the program and loose everything:");
        boolean doContinue = input.hasNext();
        if (!doContinue)
        {
            System.exit(0);
        }
    }
}
