import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Main {

    static int sdvig = 0;
    public static void main(String[] args) throws IOException {
	// input/outputStream

//        OutputStream out = new FileOutputStream("file.txt");
//
//        out.write("Hello World\r\nIt's a miracle".getBytes());
//
//        out.close();

        String fileName = "file.txt";
        String fileData = readFromFile(fileName);



        System.out.println(fileData);

//        fileData += "\n"+findScopes(fileData);
//
//        System.out.println(fileData);

        writeToFile(fileData, "output.txt");
//
//        File file = new File("abc.txt");
//
//        HashMap map = new HashMap<>();

    }

    public static String readFromFile(String fileName)  {
        int data;
        StringBuilder result = new StringBuilder();
        try (InputStream input = new FileInputStream(fileName);) {
            while ((data = input.read()) >= 0) result.append((char) data);
        }catch (IOException e){
            e.printStackTrace();
        }
        return result.toString()+"\n"+findScopes(result.toString());
    }

    public static void  writeToFile(String data, String fileName)  {
        try ( Writer out = new FileWriter(fileName);){
            out.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    public static void find(ArrayList<Integer> positionOfOpenScopes, ArrayList<Integer> positionOfCloseScopes){
        if (positionOfCloseScopes.get(0) > positionOfOpenScopes.size()-1) sdvig++;
        positionOfOpenScopes.remove(positionOfOpenScopes.size()-1-sdvig);
        positionOfCloseScopes.remove(0);
        if (positionOfCloseScopes.size() > 0) find(positionOfOpenScopes, positionOfCloseScopes);
    }

    public static String findScopes(String text){
        String result = "";
        ArrayList<Integer> positionOfOpenScopes = new ArrayList<>();
        ArrayList<Integer> positionOfCloseScopes = new ArrayList<>();
        ArrayList<String> parts = new ArrayList<>();

        boolean test = false;
        int startIndex = 0;

        for (int i = 0; i < text.length(); i++){
            if (i == ')') test = true;
            if (test && i == '('){
                parts.add(text.substring(startIndex,i));
                startIndex = i;
                test = false;
            }
        }


        for (int i = 0; i < text.length(); i++){
            if(text.charAt(i) == '(') positionOfOpenScopes.add(i);
            if(text.charAt(i) == ')') positionOfCloseScopes.add(i);
        }
        if (positionOfCloseScopes.size()>positionOfOpenScopes.size()) find(positionOfCloseScopes, positionOfOpenScopes);
        else if (positionOfCloseScopes.size()<positionOfOpenScopes.size()) find(positionOfOpenScopes, positionOfCloseScopes);

        if (positionOfCloseScopes.size() != 0) {
            System.out.println(positionOfCloseScopes.toString());
            int index =0;
            for (int i=0; i < text.length(); i++){
                if (index < positionOfCloseScopes.size() && positionOfCloseScopes.get(index) == i){
                    index++;
                    result += "^";
                }
                else result += " ";
            }
            return result;
        }
        else {
            System.out.println(positionOfOpenScopes.toString());
            int index = 0;
            for (int i=0; i < text.length(); i++){
                if (index < positionOfOpenScopes.size() && positionOfOpenScopes.get(index) == i){
                    index++;
                    result += "^";
                }
                else result += " ";
            }
            return result;
        }
    }
}
