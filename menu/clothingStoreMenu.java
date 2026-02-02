package menu;

import database.*;
import model.*;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class clothingStoreMenu implements Menu {
    private Scanner scanner;
    private ClothingitemDAO clothingitemDAO;

    public clothingStoreMenu() {
        this.scanner = new Scanner(System.in);
        this.clothingitemDAO = new ClothingitemDAO();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         MAIN MENU - Week 8            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("┌─ STAFF MANAGEMENT ─────────────────────┐");
        System.out.println("│ 1. Add Shirt                           │");
        System.out.println("│ 2. Add Pants                           │");
        System.out.println("│ 3. View All Items                      │");
        System.out.println("│ 4. View Shirts Only                    │");
        System.out.println("│ 5. View Pants   Only                   │");
        System.out.println("│ 6. Update Shirts                       │");
        System.out.println("│ 7. Update Pants                        │");
        System.out.println("├─ SEARCH & FILTER ──────────────────────┤");
        System.out.println("│ 8. Search by Brand                     │");
        System.out.println("│ 9. Search by Price  Range              │");
        System.out.println("│10. High-Priced Items (Price >= X)      │");
        System.out.println("├─ DEMO & OTHER ─────────────────────────┤");
        System.out.println("│11. Polymorphism Demo                   │");
        System.out.println("│12. Delete Item                         │");
        System.out.println("│ 0. Exit                                │");
        System.out.println("└────────────────────────────────────────┘");
    }//finished

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("\n👉 Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addShirt();
                        break;
                    case 2:
                        addPants();
                        break;
                    case 3:
                        viewAll();
                        break;
                    case 4:
                        viewShirts();
                        break;
                    case 5:
                        viewPants();
                        break;
                    case 6:
                        updateShirt();
                        break;
                    case 7:
                        updatePants();
                        break;
                    case 8:
                        searchByBrand();
                        break;
                    case 9:
                        searchByPriceRange();
                        break;
                    case 10:
                        searchHighPricedItems();
                        break;
                    case 11:
                        demonstratePolymorphism();
                        break;
                    case 12:
                        deleteItem();
                        break;
                    case 0:
                        running = false;
                        System.out.println("\n╔════════════════════════════════════════╗");
                        System.out.println("║  Thank you for using our system!      ║");
                        System.out.println("║  Goodbye! 👋                          ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
                    default:
                        System.out.println("❌ Invalid choice! Please select 0-11.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Please enter a valid number!");
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());

            }
        }

        scanner.close();
    }


    private void addShirt() {
        try {
            System.out.println("===============");
            System.out.println("Adding a Shirt");
            System.out.println("===============");
            System.out.print("Enter item id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter size: ");
            String size = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter brand name: ");
            String brand = scanner.nextLine();

            System.out.print("Enter amount of item: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter a material: ");
            String material = scanner.nextLine();

            String clothType = "Shirt";

            Shirt shirt = new Shirt(id, size, price, brand, amount, material, clothType);
            ClothingitemDAO.insertShirt(shirt);

            System.out.println("Shirt added successfully");
        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }//finished

    private void addPants() {
        try {
            System.out.println("===============");
            System.out.println("Adding Pants");
            System.out.println("===============");
            System.out.print("Enter item id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter size: ");
            String size = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter brand name: ");
            String brand = scanner.nextLine();

            System.out.print("Enter amount of item: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter a fabricType: ");
            String fabric = scanner.nextLine();

            System.out.print("Enter length: ");
            int length = scanner.nextInt();
            scanner.nextLine();

            String clothType = "Pants";

            Pants pants = new Pants(id, size, price, brand, amount, fabric, clothType);
            ClothingitemDAO.insertPants(pants);

            System.out.println("Pants added successfully");
        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }//finished

    private void viewAll() {
        ClothingitemDAO.displayAllItems();
    }//finished

    private void viewShirts() {
        List<Shirt> shirts = ClothingitemDAO.getAllShirts();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         SHIRTS ONLY                    ║");
        System.out.println("╚════════════════════════════════════════╝");

        if (shirts.isEmpty()) {
            System.out.println("📭 No shirts in database.");
        } else {
            for (int i = 0; i < shirts.size(); i++) {
                Shirt shirt = shirts.get(i);
                System.out.println((i + 1) + ". " + shirt.toString());
                System.out.println("   Material: " + shirt.getMaterial());
                if (shirt.isAffordable()) {
                    System.out.println("   ⭐ AFFORDABLE (Price < 20,000 KZT)");
                }
                System.out.println();
            }
            System.out.println("Total Shirts: " + shirts.size());
        }

    }//finished

    private void viewPants() {
        List<Pants> pantsList = ClothingitemDAO.getAllPants();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         PANTS ONLY                    ║");
        System.out.println("╚════════════════════════════════════════╝");

        if (pantsList.isEmpty()) {
            System.out.println("📭 No pants in database.");
        } else {
            for (int i = 0; i < pantsList.size(); i++) {
                Pants pants = pantsList.get(i);
                System.out.println((i + 1) + ". " + pants.toString());
                System.out.println("   Fabric Type: " + pants.getFabricType());
                pants.applyDiscount(20);
                System.out.println("Price with discount: " + pants.getPrice());
                System.out.println();
            }
            System.out.println("Total Pants: " + pantsList.size());
        }

    }//finished

    private void updateShirt() {
        try {
            System.out.println("\n┌─ UPDATE SHIRT ─────────────────────────┐");

            // Ввод данных
            System.out.print("│ Enter Shirt ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter New Size: ");
            String size = scanner.nextLine();

            System.out.print("│ Enter New Price (KZT): ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("│ Enter New Brand: ");
            String brand = scanner.nextLine();

            System.out.print("│ Enter New Amount: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter New Material: ");
            String material = scanner.nextLine();

            System.out.print("│ Enter New Cloth Type: ");
            String cloth_type = scanner.nextLine();

            System.out.println("└──────────────────────────────────────┘");
            Shirt shirt = new Shirt(id, size, price, brand, amount, material, cloth_type);

            if (ClothingitemDAO.updateShirts(shirt)) {
                System.out.println("✅ Shirt updated successfully!");
            } else {
                System.out.println("❌ Error updating Shirt in the database.");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    } //finished

    private void updatePants() {
        try {
            System.out.println("\n┌─ UPDATE PANTS ─────────────────────────┐");


            System.out.print("│ Enter Pants ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter New Size: ");
            String size = scanner.nextLine();

            System.out.print("│ Enter New Price (KZT): ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("│ Enter New Brand: ");
            String brand = scanner.nextLine();

            System.out.print("│ Enter New Amount: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            System.out.print("│ Enter New Fabric Type: ");
            String fabricType = scanner.nextLine();
            System.out.print("│ Enter New Cloth Type: ");
            String clothType = scanner.nextLine();

            System.out.println("└──────────────────────────────────────┘");

            Pants pants = new Pants(id, size, price, brand, amount, fabricType, clothType);

            if (ClothingitemDAO.updatePants(pants)) {
                System.out.println("✅ Pants updated successfully!");
            } else {
                System.out.println("❌ Error updating Pants in the database.");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    } //finished

    private void searchByBrand() {
        System.out.println("\n┌─ SEARCH BY BRAND ──────────────────────┐");
        System.out.print("│ Enter brand to search: ");
        String brand = scanner.nextLine();
        System.out.println("└────────────────────────────────────────┘");

        List<clothingitem> results = clothingitemDAO.searchByBrand(brand);

        displaySearchResults(results, "Search: '" + brand + "'");
    }//finished
    private void displaySearchResults(List<clothingitem> results, String criteria) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         SEARCH RESULTS                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Criteria: " + criteria);
        System.out.println("─────────────────────────────────────────");

        if (results.isEmpty()) {
            System.out.println("📭 No items found matching criteria.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                clothingitem item = results.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + item.getClass().getSimpleName() + "] ");
                System.out.println(item.toString());

                if (item instanceof Shirt) {
                    Shirt shirt = (Shirt) item;
                    System.out.println("   Material: " + shirt.getMaterial());
                }

                if (item instanceof Pants) {
                    Pants pants = (Pants) item;
                    System.out.println("   Fabric Type: " + pants.getFabricType());
                }
            }
            System.out.println("─────────────────────────────────────────");
            System.out.println("Total Results: " + results.size());
        }
    }//finished

    private void searchByPriceRange() {
        try {
            System.out.println("\n┌─ SEARCH BY PRICE RANGE ───────────────┐");
            System.out.print("│ Enter minimum price: ");
            double minPrice = scanner.nextDouble();

            System.out.print("│ Enter maximum price: ");
            double maxPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<clothingitem> results = clothingitemDAO.searchByPriceRange(minPrice, maxPrice);

            displaySearchResults(results, "Price: " + minPrice + " - " + maxPrice + " KZT");

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }//finished

    private void searchHighPricedItems() {
        try {
            System.out.println("\n┌─ HIGH-PRICED ITEMS ─────────────────────┐");
            System.out.print("│ Enter minimum price: ");
            double minPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<clothingitem> results = clothingitemDAO.searchByMinPrice(minPrice);

            displaySearchResults(results, "Price >= " + minPrice + " KZT");

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }

    private void demonstratePolymorphism(){ClothingitemDAO.demonstratePolymorphism();}//finished

    private void deleteItem(){
            System.out.println("\n┌─ DELETE ITEM ─────────────────────────┐");
            System.out.print("│ Enter Item ID to delete: ");

            try {
                int itemId = scanner.nextInt();
                scanner.nextLine();

                clothingitem item = clothingitemDAO.getItemById(itemId);

                if (item == null) {
                    System.out.println("❌ No item found with ID: " + itemId);
                    return;
                }

                System.out.println("│ Item to delete:");
                System.out.println("│ " + item.toString());
                System.out.println("└────────────────────────────────────────┘");

                System.out.print("⚠️  Are you sure? (yes/no): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("yes")) {
                    clothingitemDAO.deleteItem(itemId);
                } else {
                    System.out.println("❌ Deletion cancelled.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Invalid input!");
                scanner.nextLine();
            }
        }

    }
