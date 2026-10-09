package org.example.ui;

import java.util.Scanner;

public class Dashboard {
    private static Scanner sc = new Scanner(System.in);

    public static void adminDashboard() {
        boolean inAdminMenu = true;

        while (inAdminMenu) {
            System.out.println("\n|============================================================|");
            System.out.println("|                      ADMIN DASHBOARD                       |");
            System.out.println("|============================================================|");
            System.out.println("| 1. Manage Users (Approve / Deactivate Accounts)            |");
            System.out.println("| 2. Manage Products (Add / Edit / Delete Inventory)         |");
            System.out.println("| 3. View Daily Sales & Low-Stock Reports                    |");
            System.out.println("| 4. View System Activity & Audit Logs                       |");
            System.out.println("| 5. Logout                                                  |");
            System.out.println("|============================================================|");
            System.out.print("Choose an Option: ");

            String adminChoice = sc.nextLine();

            switch (adminChoice) {
                case "1":
                    System.out.println("\n--- MANAGE USERS ---");
                    break;

                case "2":
                    System.out.println("\n--- MANAGE PRODUCTS ---");
                    break;

                case "3":
                    System.out.println("\n--- DAILY SALES & LOW-STOCK REPORTS ---");
                    break;

                case "4":
                    System.out.println("\n--- SYSTEM ACTIVITY & AUDIT LOGS ---");
                    break;

                case "5":
                    System.out.println("Logging out from Admin Dashboard...");
                    inAdminMenu = false;
                    break;

                default:
                    System.out.println("Invalid option! Please choose between 1 to 5.");
                    break;
            }
        }
    }

    public static void cashierDashboard() {
        boolean inCashierMenu = true;

        while (inCashierMenu) {
            System.out.println("\n|============================================================|");
            System.out.println("|                 STORE STAFF / CASHIER MENU                 |");
            System.out.println("|============================================================|");
            System.out.println("| 1. New Sales Transaction (Checkout)                        |");
            System.out.println("| 2. Search / View School Supplies                           |");
            System.out.println("| 3. View Sales History                                      |");
            System.out.println("| 4. Cancel / Void Transaction Item                          |");
            System.out.println("| 5. Logout                                                  |");
            System.out.println("|============================================================|");
            System.out.print("Choose an Option: ");

            String cashierChoice = sc.nextLine();

            switch (cashierChoice) {
                case "1":
                    System.out.println("\n--- NEW SALES TRANSACTION ---");
                    break;

                case "2":
                    System.out.println("\n--- SEARCH / VIEW SUPPLIES ---");
                    break;

                case "3":
                    System.out.println("\n--- VIEW SALES HISTORY ---");
                    break;

                case "4":
                    System.out.println("\n--- VOID TRANSACTION ITEM ---");
                    break;

                case "5":
                    System.out.println("Logging out from Cashier Dashboard...");
                    inCashierMenu = false;
                    break;

                default:
                    System.out.println("Invalid option! Please choose between 1 to 5.");
                    break;
            }
        }
    }

    public static void inventoryDashboard() {
        boolean inInventoryMenu = true;

        while (inInventoryMenu) {
            System.out.println("\n|============================================================|");
            System.out.println("|                  INVENTORY CLERK DASHBOARD                 |");
            System.out.println("|============================================================|");
            System.out.println("| 1. Log New Supplier Restock Shipment                       |");
            System.out.println("| 2. Manual Stock Adjustment (Damage / Audit Reconciliation) |");
            System.out.println("| 3. View Inventory Stock Levels & Movement Logs             |");
            System.out.println("| 4. Logout                                                  |");
            System.out.println("|============================================================|");
            System.out.print("Choose an Option: ");

            String clerkChoice = sc.nextLine();

            switch (clerkChoice) {
                case "1":
                    System.out.println("\n--- SUPPLIER RESTOCK SHIPMENT ---");
                    break;

                case "2":
                    System.out.println("\n--- MANUAL STOCK ADJUSTMENT ---");
                    break;

                case "3":
                    System.out.println("\n--- INVENTORY MOVEMENT LOGS ---");
                    break;

                case "4":
                    System.out.println("Logging out from Inventory Dashboard...");
                    inInventoryMenu = false;
                    break;

                default:
                    System.out.println("Invalid option! Please choose between 1 to 4.");
                    break;
            }
        }
    }
}


