package services;

import java.io.IOException;
import java.util.*;

import static services.FileOperations.*;

public class CompanyHandler {

    public static void handleFileOperations(){
        // welcome screen
        System.out.println("Company Project - Developer : Hulya Takaz");
        System.out.println("You can : Display all files in ascending order, ADD,DELETE or SEARCH a file");

        Scanner scanner = new Scanner(System.in);
        displayMainMenu();

        String choice = scanner.next();
        String path = "src/util";
        boolean exit = false;

        while (!exit) {
            switch (choice) {
                case "1":
                    listAllFiles(path);
                    displayMainMenu();
                    choice = scanner.next();
                    break;
                case "2":
                    displayFileOptions();
                    String newOption = scanner.next();

                    if (newOption.equalsIgnoreCase("1")) {
                        try {
                            createNewFile(scanner, path);
                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                    } else if (newOption.equalsIgnoreCase("2")) {
                        deleteFile(scanner, path);
                    } else if (newOption.equalsIgnoreCase("3")) {
                        scanForFile(scanner, path);
                    } else if (newOption.equalsIgnoreCase("4")) {
                        displayMainMenu();
                        choice = scanner.next();
                    } else {
                        System.out.println("No such option found");
                    }
                    break;
                case "3":
                    System.out.println("Program exited");
                    exit = true;
                    continue;

                default:
                    System.out.println("There is no such an option");
                    displayMainMenu();
                    choice = scanner.next();
            }
        }

    }

    private static void displayFileOptions() {
        System.out.println("Which operation do you want to execute");
        System.out.println("1 :Add a file");
        System.out.println("2: Delete a file");
        System.out.println("3: Search a file");
        System.out.println("4: Navigate back to the main context");
    }

    private static void displayMainMenu() {
        System.out.println("Which operation do you want to execute");
        System.out.println("1: Display all files");
        System.out.println("2: File operations");
        System.out.println("3: Exit program");
    }
}
