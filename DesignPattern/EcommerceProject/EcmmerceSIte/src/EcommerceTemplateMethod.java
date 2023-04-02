import java.util.List;

public abstract class EcommerceTemplateMethod {
    private EcommerceMediator mediator;

    public EcommerceTemplateMethod(EcommerceMediator mediator) {
        this.mediator = mediator;
    }

    public void disPlayProductList(){
        List<Product> products = this.mediator.getProductsList();

        System.out.println("Product List:");

        for (Product p : products) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }
    }

    public void dispayProductDetails(String name){
        Product product = this.mediator.getProductByName(name);

        System.out.println("Product Details:");

        System.out.println(product.getName());
        System.out.println(product.getDescription());
        System.out.println(product.getPrice());
        System.out.println(product.getImage());
        System.out.println(product.getInventory());


    }

    public void createUserAccount(String name, String email, String password, String address){
        User user = new User(name, email, password, address);
        this.mediator.addUser(user);
    }


}
