public class Product {
    private String name;
    private String description;
    private double price;
    private String image;
    private int inventory;

    public Product(String name, String description, double price, String image, int inventory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public int getInventory() {
        return inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String toString() {
        return "Name: " + name + ", Description: " + description + ", Price: " + price + ", Image: " + image + ", Inventory: " + inventory;
    }

    public boolean equals(Product other) {
        return this.name.equals(other.name) && this.description.equals(other.description) && this.price == other.price && this.image.equals(other.image) && this.inventory == other.inventory;
    }

}
