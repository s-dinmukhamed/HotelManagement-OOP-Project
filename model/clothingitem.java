package model;

public abstract class clothingitem {
    //Private fields
    protected int item_id;
    protected String size;
    protected double price;
    protected String brand;
    protected int amount;
    protected String cloth_type;   // Added cloth_type
    protected String material;     // Added material (specific for Shirt)
    protected String fabricType;

    //Constructor with parameters
    public clothingitem(int item_id, String size, double price, String brand,
                        int amount, String cloth_type, String material, String fabricType) {
        setId(item_id);
        setSize(size);
        setPrice(price);
        setBrand(brand);
        setAmount(amount);
        setClothType(cloth_type);
        setMaterial(material);
        setFabricType(fabricType);
    }

    //Getters
    public int getId() {return item_id;}
    public String getSize() {return size;}
    public double getPrice() {return price;}
    public String getBrand() {return brand;}
    public int getAmount() {return amount;}
    public String getClothType() { return cloth_type; }
    public String getMaterial() { return material; }
    public String getFabricType() { return fabricType; }

    //Setters
    public void setId(int item_id) {
        if (item_id > 0){
            this.item_id = item_id;
        }else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
    public void setSize(String size) {
        if (size != null && !size.trim().isEmpty()) {
            this.size = size;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        }else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
    public void setAmount(int amount) {
        if(amount > 0){
            this.amount = amount;
        }else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
    public void setClothType(String cloth_type) { this.cloth_type = cloth_type; }
    public void setMaterial(String material) { this.material = material; }
    public void setFabricType(String fabricType) { this.fabricType = fabricType; }

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

    //concrete method
    public void displayInfo(){
        System.out.println("ID: " + item_id);
        System.out.println("Size: " + size);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price + " KZT");
        System.out.println("AMount: " + amount);
    }

    //methods to concrete
    public abstract void MadeOf();

    //To string
    @Override
    public String toString() {
        return "ClothingItem{Item id=" + item_id + ", Size = " + size + ", Price=" + price + ", Brand='" + brand + "', Amount=" + amount + "}";
    }
}
