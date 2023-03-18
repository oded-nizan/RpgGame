package com.rpg.mechanics;

import com.rpg.characters.Attack;
import com.rpg.characters.Character;
import com.rpg.characters.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Essentials {
    private static final JSONParser parser = new JSONParser();
    private static final Random random = new Random();

    private static String getFilePath(String fileName) {
        File filePathFile = new File("src/com/rpg/resources");
        String filePath = filePathFile.getAbsolutePath() + "/" + fileName;
        return filePath;
    }

    private static JSONArray parseJson(String filePath, String arrayName) {
        JSONObject jsonObject;
        JSONArray TypesArray = new JSONArray();
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(filePath));
            TypesArray = (JSONArray) jsonObject.get(arrayName);
        } catch (Exception e) {
            System.out.println("There has been an error");
            e.printStackTrace();
            System.exit(0);
        }
        return TypesArray;
    }

    public static ArrayList<JSONObject> getCharacterArray(String fileName, String arrayName) {
        String filePath = getFilePath(fileName);
        JSONArray TypesArray = parseJson(filePath, arrayName);
        JSONObject jsonObject;
        ArrayList<JSONObject> charList = new ArrayList<>();
        for (Object o : TypesArray) {
            jsonObject = (JSONObject) o;
            charList.add(jsonObject);
        }
        return charList;
    }

}