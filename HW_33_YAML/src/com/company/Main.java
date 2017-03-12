package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here


        int[] af = {1, 4, 5, 1, 5, 4, 7, 9, 7};


        //System.out.println(findSingleNumberInArray(af));


        //RandomAccessFile file = getDataFile();
        File file = new File("test.yaml");

        if (!file.exists()) try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //writeYAMLFile(af, file);

        System.out.println(findSingleNumberInYAML(file, "Array2"));


    }

    public static void writeYAMLFile(int[] array, File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(file.length());

        randomAccessFile.write("Array: ".getBytes());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++){
            if (i == 0) builder.append("[");
            builder.append(array[i]);
            if (i != array.length-1) builder.append(", ");
            else builder.append("]\r\n");
        }
        randomAccessFile.writeBytes(builder.toString());
    }

    public static int findSingleNumberInYAML(File file, String arrayName) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(0);

        int startIndex =0;
        int endIndex = 0;
        int [] result = null;

        String str;
        while ((str = randomAccessFile.readLine()) != null) {
            if (str.startsWith(arrayName+":")) {
                str = str.replaceAll(" ","");
                startIndex = str.indexOf("[")+1;
                endIndex = str.indexOf("]");
                String[] split = str.substring(startIndex,endIndex).split(",");
                result = new int[split.length];
                for (int i =0; i < split.length; i++){
                    result[i] = Integer.parseInt(split[i]);
                }
            }
        }
        return findSingleNumberInArray(result);
    }


    public static int findSingleNumberInArray(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            int num = array[i];
            for (int k = 0; k < array.length; k++)
                if (array[k] == num)
                    count++;
            if (count == 1) {
                result = num;
                break;
            }
        }
        return result;
    }


}
