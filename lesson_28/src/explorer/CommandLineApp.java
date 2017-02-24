package explorer;


import java.io.*;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * Created by java on 21.02.2017.
 */
public class CommandLineApp {

    private static final String DEFAULT_PATH = "D:\\";
    private static File currentDir = new File(DEFAULT_PATH);

    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(in);
        System.out.println("Use Help to view commands");

        List<Citizen> list = readCSV("citizen.csv");
        System.out.println(list);

        while (true) {

            System.out.println(currentDir.getPath());
            String line = scanner.nextLine();

            if (line.split(" ")[0].equalsIgnoreCase("print")) {
                if (currentDir.isDirectory()) {
                    printAllDirectories(currentDir);
                }
            } else if (line.split(" ")[0].equalsIgnoreCase("mkDir")) {  //mkDir newFolderName
                createNewFolder(line, currentDir);
            } else if (line.split(" ")[0].equalsIgnoreCase("cd")) {
                changeDirectory(line);
            } else if (line.split(" ")[0].equalsIgnoreCase("mkFile")) {  //mkDir newFolderName
                createNewFile(line, currentDir);
            } else if (line.split(" ")[0].equalsIgnoreCase("delete")) {  //mkDir newFolderName
                delete(line, currentDir);
            } else if (line.split(" ")[0].equalsIgnoreCase("open")) {  //mkDir newFolderName
                openTextFile(line, currentDir);
            } else if (line.split(" ")[0].equalsIgnoreCase("edit")) {  //mkDir newFolderName
                editTextFile(line, currentDir);
            } else if (line.split(" ")[0].equalsIgnoreCase("help")) {  //mkDir newFolderName
                help();
            } else System.out.println("Wrong command. Use Help to view commands");
        }

    }

    private static void help() {
        System.out.println("mkDir [file name]   создать папку");
        System.out.println("cd [folder name]   сменить путь");
        System.out.println("delete [folder name/file name]   удалить файл");
        System.out.println("open [fileName.txt/cvs]   отобразить содержимое текстового файла");
        System.out.println("edit [file name.txt/cvs]   редактировать файл");
        System.out.println("mkFile [file name]   создать файл");
        System.out.println("print   вывести список файлов и папок");
    }

    private static void editTextFile(String line, File parent) throws IOException {
        String fileName = line.split("\\s+")[1];

        if (!(fileName.endsWith(".txt") || fileName.endsWith(".cvs"))) {
            System.out.println("Wrong file type to edit");
            return;
        }
        File file = new File(parent, fileName);
        if (!file.exists()) {
            System.out.println("File not exists");
            return;
        }
        PrintWriter out = new PrintWriter(file);
        Writer writer = new FileWriter(file);
        Scanner scanner = new Scanner(System.in);
        String s = "";
        System.out.println("Write your text and use Save to save change and exit");
        String text;
        while (true) {
            text = scanner.nextLine();
            if (text.equals("save")) break;
            s += (text + "\n");
        }
        writer.append(s);
        save(writer, line, parent);
    }

    private static void save(Writer text, String line, File parent) throws IOException {
        text.close();
        System.out.println("File text edit to:");
        openTextFile(line, parent);

    }

    private static void openTextFile(String line, File parent) throws IOException {
        String fileName = line.split("\\s+")[1];

        if (fileName.endsWith(".txt") || fileName.endsWith(".cvs")) {

            File file = new File(parent, fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String out;

            while ((out = bufferedReader.readLine()) != null) {
                System.out.println(out);
            }
        }
    }

    private static void delete(String line, File parent) {
        String fileName = line.split("\\s+")[1];

        File file = new File(parent, fileName);
        if (!file.exists()) {
            System.out.println("File or directory not exists");
            return;
        }
        if (file.isFile()) System.out.println("File " + fileName + " deleted");
        if (file.isDirectory()) System.out.println("Directory " + fileName + " deleted");
        file.delete();
    }


    private static void changeDirectory(String line) {
        String folderName = line.split("\\s+")[1];

        if (folderName.contains("..")) {
            if (currentDir.getParentFile() != null) currentDir = currentDir.getParentFile();
            return;
        }

        File[] list = currentDir.listFiles(dir -> dir.isDirectory() && dir.getName().contains(folderName));


        if (list.length == 1) {
            File matchedFolder = list[0];
            currentDir = matchedFolder;
        } else if (line.length() == 0) {
            System.out.println("No such directory");
        } else {
            for (File dir : list) {
                System.out.println(dir.getName());
            }
        }

    }

    private static void createNewFile(String line, File parent) throws IOException {
        String fileName = line.split("\\s+")[1];

        File file = new File(parent, fileName);
        file.createNewFile();
        System.out.println("file " + fileName + " created");
    }

    private static void createNewFolder(String line, File parent) {
        String folderName = line.split("\\s+")[1];

        File directory = new File(parent, folderName);
        directory.mkdir();
    }

    private static void printAllDirectories(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isHidden()) {
                System.out.println(f.getName());
            }
        }
    }

    public static List<Citizen> readCSV(String fileName){
        List<Citizen> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));){
            String line;
            while ((line = reader.readLine()) != null){
                if (line.startsWith("id")) continue;
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(";");

                long id = scanner.nextLong();
                String fName = scanner.next();
                String lName = scanner.next();
                int age = scanner.nextInt();

                list.add(new Citizen(id, fName, lName, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
