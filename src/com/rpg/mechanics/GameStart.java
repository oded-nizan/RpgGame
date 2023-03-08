package com.rpg.mechanics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class GameStart
{
    static Scanner input = new Scanner(System.in);
    static JSONParser parser = new JSONParser();

    private static String getFilePath(String fileName)
    {
        String filePath = new File(fileName).getAbsolutePath();
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

    public static void getCharacter(String fileName)
    {
        String filePath = getFilePath(fileName);
        JSONArray TypesArray = parseJson(filePath);
        for (Object o : TypesArray) {
            System.out.println(o.toString());
        }
    }

    public static boolean Continue()
    {
        System.out.println("Congratulations! You have successfully created your player character and are now ready to play!");
        System.out.println("Please enter true to continue or false to exit the program and loose everything:");
        return input.hasNext();
    }
}
