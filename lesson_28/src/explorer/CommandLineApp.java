package explorer;


import java.io.*;
import java.security.KeyStore;
import java.util.Scanner;

/**
 * Created by java on 21.02.2017.
 */
public class CommandLineApp {

    private static final String DEFAULT_PATH = "D:\\";
    private static File currentDir = new File(DEFAULT_PATH);

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println(currentDir.getPath());
            String line = scanner.nextLine();

            if (line.startsWith("print")) {
                if (currentDir.isDirectory()) {
                    printAllDirectories(currentDir);
                }
            } else if (line.startsWith("mkDir")) {  //mkDir newFolderName
                createNewFolder(line, currentDir);
            } else if (line.startsWith("cd")) {
                changeDirectory(line);
            }
        }

}

    private static void changeDirectory(String line) {
        String folderName = line.split("\\s+")[1];

        if (folderName.contains("..")) {
            if(currentDir.getParentFile() != null) currentDir = currentDir.getParentFile();
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

    private static void createNewFolder(String line, File parent) {
        String folderName = line.split("\\s+")[1];

        File directory = new File(parent, folderName);
        directory.mkdir();
    }

    private static void printAllDirectories(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory() && !f.isHidden()) {
                System.out.println(f.getName());
            }
        }
    }
}
