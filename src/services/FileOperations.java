package services;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileOperations {

    public static void scanForFile(Scanner scanner, String path) {
        try {
            System.out.println("Enter file name to scan");
            String fileName = scanner.next();
            List<File> files = getFiles(path);
            boolean fileFound = false;

            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    fileFound = true;
                    System.out.println("File founded at path:" + file.getAbsolutePath());
                }
            }

            if (!fileFound) {
                System.out.println("File not found");
            }
        } catch(Exception e){
            System.out.println("Something went wrong");
        }
    }

    public static void deleteFile(Scanner scanner, String path) {
        System.out.println("Enter file name to delete");
        String deletedFile = scanner.next();
        File file = new File(path, deletedFile);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void createNewFile(Scanner scanner, String path) throws IOException {
        System.out.println("Enter file name");
        String fileName = scanner.next();
        File file = new File(path, fileName);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    public static void listAllFiles(String path) {
        System.out.println("Displaying all files");

        List<File> listFile = getFiles(path);
        Collections.sort(listFile);

        for (int i = 0; i < listFile.size(); i++) {
            if (listFile.get(i).isFile()) {
                System.out.println("File " + listFile.get(i).getName());
            } else if (listFile.get(i).isDirectory()) {
                System.out.println("Directory " + listFile.get(i).getName());
            }
        }
    }

    public static List<File> getFiles(String path) {
        File files = new File(path);
        return Arrays.asList(Objects.requireNonNull(files.listFiles()));
    }

}
