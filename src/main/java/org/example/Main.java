package org.example;

import org.example.dao.UserDao;
import java.util.Scanner;
import org.example.ui.Dashboard;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserDao userdao = new UserDao();

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main (String[] args){

        boolean running = true;

        while (running) {
            System.out.println("\n|============================================================|");
            System.out.println("|               SCHOOL SUPPLIES INVENTORY SYSTEM             |");
            System.out.println("|============================================================|");
            System.out.println("|1. Register                                                 |");
            System.out.println("|2. Login                                                    |");
            System.out.println("|3. Exit                                                     |");
            System.out.println("|============================================================|");
            System.out.print("Choose an Option: ");
            String choice = sc.nextLine();

            switch(choice){
                case"1":
                    System.out.print("Enter your Fullname: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new Username: ");
                    String user = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();

                    System.out.println("Role: ");
                    System.out.println(" 1. Admin");
                    System.out.println(" 2. Staff/Cashier");
                    System.out.println(" 3. Inventory Clerk");
                    System.out.print("Enter choice (1-3): ");
                    int roleChoice = sc.nextInt();
                    sc.nextLine();

                    String role;
                    switch (roleChoice){
                        case 1:
                            role = "Admin";
                            break;

                        case 2:
                            role = "Staff/Cashier";
                            break;

                        case 3:
                            role = "Inventory Clerk";
                            break;

                        default:
                            role = null;

                    }

                    if(role != null){
                        userdao.registerUser(name, user, pass, role);
                    }else{
                        System.out.println("Invalid role selection! ");
                    }
                    break;

                case"2":
                    System.out.print("Enter Username: ");
                    String loginUser = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPass = sc.nextLine();

                    String userRole = userdao.loginUser(loginUser, loginPass);

                    if (userRole != null) {
                        clearScreen();
                        System.out.println("Logged in as: " + userRole);

                        if ("ADMIN".equalsIgnoreCase(userRole)) {
                            Dashboard.adminDashboard();
                        } else if ("STAFF/CASHIER".equalsIgnoreCase(userRole)) {
                            Dashboard.cashierDashboard();
                        } else if ("INVENTORY CLERK".equalsIgnoreCase(userRole)) {
                            Dashboard.inventoryDashboard();
                        }
                    }
                    break;

                case "3":
                    clearScreen();
                    System.out.println("\n|============================================================|");
                    System.out.println("|    Thank you for using School Supplies Inventory System!   |");
                    System.out.println("|                System Closed Successfully.                 |");
                    System.out.println("|============================================================|\n");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option! Please choose between 1, 2, or 3.");
                    break;

            }
        }
    }
}