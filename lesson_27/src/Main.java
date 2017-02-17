import java.io.*;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Main {

    public static void main(String[] args)  {
	// input/outputStream

//        OutputStream out = new FileOutputStream("file.txt");
//
//        out.write("Hello World\r\nIt's a miracle".getBytes());
//
//        out.close();

        String fileName = "input.txt";
        String fileData = readFromFile(fileName);

        System.out.println(fileData);

        writeToFile(fileData, "output.txt");

        File file = new File("abc.txt");

        HashMap map = new HashMap<>();

    }

    public static String readFromFile(String fileName)  {
        int data;
        StringBuilder result = new StringBuilder();
        try (InputStream input = new FileInputStream(fileName);) {
            while ((data = input.read()) >= 0) result.append((char) data);
        }catch (IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void  writeToFile(String data, String fileName)  {
        try ( Writer out = new FileWriter(fileName);){
            out.write(data.toUpperCase());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
