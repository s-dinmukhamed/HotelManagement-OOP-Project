package com.dinmukhamed.store;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<clothingitem> clothingitems = new ArrayList<>();
    public static ArrayList<customer> customers = new ArrayList<>();
    public static ArrayList<order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        clothingitems.add(new clothingitem(1, "S", 15500, "Nike", 40, "Jeans"));
        clothingitems.add(new clothingitem(2, "XL", 23000, "Adidas", 24, "Hoodie"));
        clothingitems.add(new clothingitem(3, "M", 9990, "Puma", 13, "T-shirt"));

        customers.add(new customer(1,"Dimash", "Kabanbay Batur 60a/6", "dimash@gmail.com", 400));
        customers.add(new customer(2, "Miras", "Kabanbay Batyr 60a/13", "miras@gmail.com", 200));

        orders.add(new order(1, 2, 25490, "Dimash", "Kabanbay Batyra 60a/6"));

        //menu loop
        boolean run = true;
        while(run){
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine();
                switch (choice){
                    case 1:
                        addClothingItem();break;
                    case 2:
                        viewAllItems();break;
                    case 3:
                        addCostumer();break;
                    case 4:
                        viewAllCostumers();break;
                    case 0:
                        run = false; break;
                }
        }
    }

    public static void menu(){
        System.out.println("=======================");
        System.out.println("CLOTHING STORE SYSTEM");
        System.out.println("=======================");
        System.out.println("1. Add clothing item ");
        System.out.println("2. View all items");
        System.out.println("3. Add costumer");
        System.out.println("4. View all costumers");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    public static void addClothingItem(){
        System.out.println("\n ---ADD CLOTHING ITEM---");
        System.out.print("Enter item number: ");
        int item_id = scanner.nextInt();
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

        System.out.print("Enter type of item: ");
        String typeOfCloth = scanner.nextLine();

        clothingitem item = new clothingitem(item_id, size, price, brand, amount, typeOfCloth);
        clothingitems.add(item);

        System.out.println("New item added successfully ");
    }
    public static void viewAllItems(){
        System.out.println("\n================");
        System.out.println(" ALL MENU ITEMS");
        System.out.println("=================");
        if(clothingitems.isEmpty()){
            System.out.println("No clothing items found");
            return;
        }
        System.out.println("Total items: " + clothingitems.size());
        System.out.println();

        for(int i = 0; i < clothingitems.size(); i++){
            clothingitem item = clothingitems.get(i);
            System.out.println(item.getId()+"-"+
                    item.getBrand()+" "+item.getTypeOfCloth());
            System.out.println("Amount: "+item.getAmount());
            System.out.println("Size: "+item.getSize());
            System.out.println("Price: "+item.getPrice());
            System.out.println();
        }
    }
    public static void addCostumer(){
        System.out.println("===================");
        System.out.println("---ADD COSTUMER---");
        System.out.println("===================");

        System.out.print("Enter client id: ");
        int client_id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter client name: ");
        String name = scanner.nextLine();

        System.out.print("Enter client address: ");
        String address = scanner.nextLine();

        System.out.print("Enter client email: ");
        String email = scanner.nextLine();

        System.out.print("Enter amount of loyalty points: ");
        double loyaltypoints = scanner.nextDouble();
        scanner.nextLine();

        customer client = new customer(client_id, name,address, email, loyaltypoints);
        customers.add(client);

        System.out.println("Costumer successfully added");
    }
    public static void viewAllCostumers(){
        System.out.println("\n================");
        System.out.println(" ALL COSTUMERS ");
        System.out.println("=================");

        if(customers.isEmpty()){
            System.out.println("No costumers found");
            return;
        }
        System.out.println("Total costumers: "+ customers.size());
        System.out.println();

        for(int i = 0; i < customers.size(); i++){
            customer client = customers.get(i);
            System.out.println(client.getClient_id() +" - "+ client.getName());
            System.out.println("Address: " + client.getAddress());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Amount of loyalty points: " + client.getLoyaltyPoints());
            System.out.println();

        }
    }
}