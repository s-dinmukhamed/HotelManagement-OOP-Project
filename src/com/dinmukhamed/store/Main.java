package com.dinmukhamed.store;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<clothingitem> clothingitems = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        clothingitems.add(new clothingitem(3, "l", 20000, "Puma", 100));
        clothingitems.add(new Shirt(1, "S", 15500, "Nike", 40, "cotton"));
        clothingitems.add(new Pants(2, "XL", 23000, "Adidas", 24, "Denim", 77));
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1: addShirt(); break;
                case 2: addPants(); break;
                case 3: viewAll(); break;
                case 4: viewShirts(); break;
                case 5: viewPants(); break;
                case 6: showPolymorph(); break;
                case 0: running = false; break;
            }

        }


    }

    private static void displayMenu() {
        System.out.println("---------------------");
        System.out.println("Clothing Store System");
        System.out.println("---------------------");
        System.out.println("1. Add Shirt");
        System.out.println("2. Add Pants");
        System.out.println("3. View all items");
        System.out.println("4. View only Shirts");
        System.out.println("5. View only pants");
        System.out.println("6. Show polymorphism");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
    }

    private static void addShirt() {
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

        clothingitem clothingitem = new Shirt(id, size, price, brand, amount, material);
        clothingitems.add(clothingitem);

        System.out.println("Shirt added successfully");
    }

    private static void addPants() {
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

        clothingitem clothingitem = new Pants(id, size, price, brand, amount, fabric, length);
        clothingitems.add(clothingitem);

        System.out.println("Pants added successfully");
    }

    private static void viewAll() {
        if (clothingitems.isEmpty()) {
            System.out.println("No clothing items found.");
            return;
        }
        System.out.println("Total staff: " + clothingitems.size());
        System.out.println();

        for (int i = 0; i < clothingitems.size(); i++) {
            clothingitem s = clothingitems.get(i);
            System.out.println((i + 1) + ". " + s);
            if (s instanceof Shirt) {
                Shirt shirt = (Shirt) s;
                System.out.println(shirt);
            } else if (s instanceof Pants) {
                System.out.println(s);
            }
        }
        System.out.println();
    }

    private static void viewShirts() {
        System.out.println("=======");
        System.out.println("Shirts");
        System.out.println("=======");
        int shirts_count = 0;
        for(clothingitem s : clothingitems){
            if (s instanceof Shirt){
                Shirt shirt = (Shirt) s;
                shirts_count++;
                System.out.println(shirts_count + ". " + shirt.getBrand());
                System.out.println("Price: " + shirt.getPrice());
                System.out.println("Material: " + shirt.getMaterial());
                System.out.println();
            }
        }

    }

    private static void viewPants() {
        System.out.println("=======");
        System.out.println("Pants");
        System.out.println("=======");
        int pants_count = 0;
        for(clothingitem s : clothingitems){
            if (s instanceof Pants){
                Pants pants = (Pants) s;
                pants_count++;
                System.out.println(pants_count + ". " + pants.getBrand());
                System.out.println("Price: " + pants.getPrice());
                System.out.println("Fabric type: " + pants.getFabricType());
                System.out.println();
            }
        }
    }
    private static void showPolymorph(){
        System.out.println("==========================");
        System.out.println("Demonstrating Polymorphism");
        System.out.println("==========================");

        for(clothingitem s : clothingitems){
            s.MadeOf();
        }
    }
}