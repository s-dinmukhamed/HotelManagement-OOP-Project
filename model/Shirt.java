package model;

public class Shirt extends clothingitem{
    private String material;

    public Shirt(int item_id, String size, double price, String brand, int amount, String material, String cloth_type) {
        super(item_id, size, price, brand, amount, cloth_type, material, null);  
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
