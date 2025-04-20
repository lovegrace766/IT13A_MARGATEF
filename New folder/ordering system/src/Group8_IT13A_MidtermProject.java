public class Group8_IT13A_MidtermProject {
    package MIDTERM;
  
    
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Group8_IT13A_MidtermProject {

    static Scanner sc = new Scanner(System.in);
    static String filePath = "\"C:\\Users\\ACER\\Documents\\midterm.txt\"";

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to our ICS Snack Store!");
            System.out.println("[1] Create an Account");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    boolean stayInCreate = true;
                    while (stayInCreate) {
                        makeAccount();
                        System.out.println("\nWhat would you like to do next?");
                        System.out.println("[1] Create another account");
                        System.out.println("[2] Proceed to login");
                        System.out.println("[3] Return to main menu");
                        System.out.print("Enter your choice: ");
                        int nextChoice = sc.nextInt();
                        sc.nextLine();

                        switch (nextChoice) {
                            case 1:
                                break;
                            case 2:
                                boolean loginCheck = false;
                                while (!loginCheck) {
                                    loginCheck = login();
                                    if (!loginCheck) {
                                        System.out.print("Login failed. Try again? (yes/no): ");
                                        String retry = sc.nextLine();
                                        if (!retry.equalsIgnoreCase("yes")) {
                                            break;
                                        }
                                    } else {
                                        showMenu();
                                        stayInCreate = false;
                                    }
                                }
                                stayInCreate = false;
                                break;
                            case 3:
                                stayInCreate = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Returning to main menu.");
                                stayInCreate = false;
                                break;
                        }
                    }
                    break;

                case 2:
                    boolean loginCheck = false;
                    while (!loginCheck) {
                        loginCheck = login();
                        if (!loginCheck) {
                            System.out.print("Login failed. Try again? (yes/no): ");
                            String retry = sc.nextLine();
                            if (!retry.equalsIgnoreCase("yes")) {
                                break;
                            }
                        } else {
                            showMenu();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you for visiting!");
                    return;

                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    public static void makeAccount() {
        System.out.print("Enter your Username: ");
        String user = sc.nextLine();
        System.out.print("Enter your Password: ");
        String password = sc.nextLine();

        String encrypted = encrypt(password);

        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(user + "," + encrypted + "\n");
            System.out.println("Account created successfully.\n");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public static boolean login() {
        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedUser = parts[0];
                    String storedEncryptedPwd = parts[1];
                    String decryptedPwd = decrypt(storedEncryptedPwd);

                    if (user.equals(storedUser) && password.equals(decryptedPwd)) {

}
