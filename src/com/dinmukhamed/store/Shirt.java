package com.dinmukhamed.store;

public class Shirt extends clothingitem{
    private String material;

    public Shirt(int item_id, String size, double price, String brand, int amount, String material){
        super(item_id, size, price, brand, amount);
        this.material = material;
    }
    public String getMaterial(){
        return material;
    }
    public void setMaterial(String material){
        if (material != null && !material.trim().isEmpty()) {
            this.material = material;
        }
    }

    @Override
        public void MadeOf(){
            System.out.println(brand + " shirt made of " + material);
    }
    @Override
        public String whatBrand(){
            return brand;
    }

    public boolean isAffordable(){
        return price < 20000;
    }

    public String whatSize(){
        return size;
    }

    @Override
    public String toString(){
        return super.toString() + "| Material: " + material;
    }
}
