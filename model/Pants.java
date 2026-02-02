package model;

public class Pants extends clothingitem{
    private String fabricType;
    private int lengthCm;

    public Pants(int item_id, String size, double price, String brand, int amount, String fabricType, String cloth_type) {
        super(item_id, size, price, brand, amount, cloth_type, null, fabricType);  // material is null for Pants
    }

    public String getFabricType(){
        return fabricType;
    }
    public int getLengthCm(){return lengthCm;}

    public void setFabricType(){
        if (fabricType != null && !fabricType.trim().isEmpty()) {
            this.fabricType = fabricType;
        }
    }

    @Override
    public void MadeOf(){System.out.println("Pants made of " + fabricType);}

    public void applyDiscount(int x){
        price = price - price * (x/100);
        System.out.println("Price with discount: " + price);
    }

    public boolean fitsHeight(int heightCm) {
        if (heightCm <= 0) return false;
        // грубо: длина ноги ~ 0.55 роста
        int expected = (int)(heightCm * 0.55);
        return Math.abs(lengthCm - expected) <= 5;
    }

    @Override
    public String toString(){
        return super.toString() + "|Fabric Type: " + fabricType;
    }

}
