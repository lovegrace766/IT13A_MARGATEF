package MIDTERM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


 
public class ORDERINGSYSTEM {
    
  public class Group8_IT13A_MidtermProject {
     static Scanner sc = new Scanner(System.in);
    static String filePath = "C:\\Users\\ACER\\Documents\\midterm.txt\"";

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
                            boolean LoginCheck = false;
                            while (!LoginCheck) {
                                LoginCheck = login();
                                if (!LoginCheck) {
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
                boolean LoginCheck = false;
                while (!LoginCheck) {
                    LoginCheck = login();
                    if (!LoginCheck) {
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
                        System.out.println("Login successful!");
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        return false;
    }

   
    public static String encrypt(String pwd) {
        StringBuilder sb = new StringBuilder();
        for (char x : pwd.toCharArray()) {
            sb.append((char) (x + 3));
        }
        return sb.toString();
    }

   
    static String decrypt(String encryptedPwd) {
        StringBuilder sb = new StringBuilder();
        for (char c : encryptedPwd.toCharArray()) {
            sb.append((char) (c - 3));
        }
        return sb.toString();
    }

 
   public static void showMenu() {
        String[] items = {"Pizza", "Burger", "Fries", "Cola", "Nuggets", "Chicken Skin", "Fishballs", "Water"};
        double[] prices = {150.00, 70.00, 30.00, 25.00, 7.00, 5.00, 3.00, 20.00};
        int[] quantities = new int[8];

        int choice;
        do {
            System.out.println("\n----- Restaurant Menu -----");
            for (int i = 0; i < items.length; i++) {
                System.out.println("[" + (i + 1) + "] " + items[i] + " - Php" + prices[i]);
            }
            System.out.println("[4] Exit and Checkout");

            System.out.print("Choose an item: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 8) {
                System.out.print("Enter quantity for " + items[choice - 1] + ": ");
                int qty = sc.nextInt();
                quantities[choice - 1] += qty;
            } else if (choice != 9) {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 9);

        
        System.out.println("\n========= Your Order Summary ==========");
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                double itemTotal = quantities[i] * prices[i];
                System.out.println(items[i] + " x " + quantities[i] + " = ₱" + itemTotal);
                total += itemTotal;
            }
        }
        System.out.println("Your Total Bill: Php" + total);
        System.out.println("=========================");
        System.out.println("Thank you for your order and hope to see you again!");
        
    }
  
}
    
}
