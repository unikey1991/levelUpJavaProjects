package com.company.task2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by unike on 18.02.2017.
 */
public class Main {

    public static int sdvig = 0;
    public static void main(String[] args) throws IOException {


        String fileName = "input.txt";
        String result= "";


        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (String line:lines) {
            result+= checkFormula(line);
        }

        writeToFile(result, "out.txt");


    }



    public static void  writeToFile(String data, String fileName)  {
        try ( Writer out = new FileWriter(fileName);){
            out.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void findScopes(ArrayList<Integer> positionOfOpenScopes, ArrayList<Integer> positionOfCloseScopes){
        if (positionOfCloseScopes.get(0) > positionOfOpenScopes.size()-1) sdvig++;
        positionOfOpenScopes.remove(positionOfOpenScopes.size()-1-sdvig);
        positionOfCloseScopes.remove(0);
        if (positionOfCloseScopes.size() > 0) findScopes(positionOfOpenScopes, positionOfCloseScopes);
    }

    public static String checkFormula(String text){
        ArrayList<Integer> positionOfOpenScopes = new ArrayList<>();
        ArrayList<Integer> positionOfCloseScopes = new ArrayList<>();

        for (int i = 0; i < text.length(); i++){
            if(text.charAt(i) == '(') positionOfOpenScopes.add(i);
            if(text.charAt(i) == ')') positionOfCloseScopes.add(i);
        }
        if (positionOfCloseScopes.size()>positionOfOpenScopes.size()) findScopes(positionOfCloseScopes, positionOfOpenScopes);
        else if (positionOfCloseScopes.size()<positionOfOpenScopes.size() && positionOfCloseScopes.size()>0) findScopes(positionOfOpenScopes, positionOfCloseScopes);

        if (positionOfCloseScopes.size() > positionOfOpenScopes.size()) {
            return text+"\r"+writeMarker(positionOfCloseScopes,text)+"\r";
        }
        else if (positionOfCloseScopes.size() < positionOfOpenScopes.size()){
            return text+"\r"+writeMarker(positionOfOpenScopes, text)+"\r";
        }

        return "";
    }

    public static String writeMarker(ArrayList<Integer> list, String text){
        String result = "";
        int index = 0;
        for (int i=0; i < text.length(); i++){
            if (index < list.size() && list.get(index) == i){
                index++;
                result += "^";
            }
            else result += " ";
        }
        sdvig = 0;
        return result;
    }


}
