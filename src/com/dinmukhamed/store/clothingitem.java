package com.dinmukhamed.store;

public class clothingitem {
    //Private fields
    protected int item_id;
    protected String size;
    protected double price;
    protected String brand;
    protected int amount;

    //Constructor with parameters
    public clothingitem(int item_id, String size, double price, String brand,  int amount) {
        setId(item_id);
        this.size = size;
        setPrice(price);
        setBrand(brand);
        setAmount(amount);
    }

    public clothingitem() {
    }

    //Getters
    public int getId() {return item_id;}
    public String getSize() {return size;}
    public double getPrice() {return price;}
    public String getBrand() {return brand;}
    public int getAmount() {return amount;}

    //Setters
    public void setId(int item_id) {
        if (item_id > 0){
            this.item_id = item_id;
        }else {
            System.out.println("Warning: ID cannot be negative");
            this.item_id = 0;
        }
    }
    public void setSize(String size) {this.size = size;}
    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        }else {
            System.out.println("Warning: Price cannot be negative ");
            this.price = 0;
        }
    }
    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        } else {
            System.out.println("Warning: Brand name cannot be empty!");
        }
    }
    public void setAmount(int amount) {

        if(amount > 0){
            this.amount = amount;
        }else {
            System.out.println("Warning: Amount cannot be negative ");
            this.amount = 0;
        }
    }


    //Methods
    public void applDiscount(double Percent){
        double discount = price * (Percent/100);
        price =  price - discount;
    }
    public boolean amountCheck(){
        if(amount >= 10){
            return false;
        }else{
            return true;
        }
    }
    //Overriden
    public void MadeOf(){
        System.out.print("Shirt");
    }
    public String whatBrand(){
        return "Brand";
    }

    public void pantsMadeOf(){
        System.out.println("Pants");
    }
    public String whatBrandPants(){
        return "Brand";
    }
    //Not overriden
    public String isAvailable(){
        if(amount > 0){
            return "Available";
        }else{
            return "Not available";
        }
    }

    //To string
    @Override
    public String toString() {
        return "ClothingItem{Item id=" + item_id + ", Size = " + size + ", Price=" + price + ", Brand='" + brand + "', Amount=" + amount + "}";
    }
}
