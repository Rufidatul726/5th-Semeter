import java.util.List;

public class AdminTemplateMethod extends EcommerceTemplateMethod{

    public AdminTemplateMethod(EcommerceMediator mediator) {
        super(mediator);
    }

    public void addProduct(String name, String description, double price, String image, int inventory) {
        Product product = new Product(name, description, price, image, inventory);
        this.mediator.addProduct(product);
    }

    public void updateProduct(String name, String description, double price, String image, int inventory) {
        Product product = new Product(name, description, price, image, inventory);
        this.mediator.updateProduct(product);
    }

    public void removeProduct(Product product) {
        this.mediator.removeProduct(product);
    }
    @Override
    public void disPlayProductList() {
        List<Product> products = this.mediator.getProductsList();
        System.out.println("Product List:");
        for (Product p : products) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }
    }

    @Override
    public void displayProductDetails(String name) {
        Product product = this.mediator.getProductByName(name);
        if(product != null){
            System.out.println("Product Details:");
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
            System.out.println(product.getImage());
            System.out.println(product.getInventory());
        }
        else{
            System.out.println("Product not available");
        }
    }


}
