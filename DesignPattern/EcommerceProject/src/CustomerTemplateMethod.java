import java.util.List;

public class CustomerTemplateMethod extends EcommerceTemplateMethod{
    public CustomerTemplateMethod(EcommerceMediator mediator) {
        super(mediator);
    }
    @Override
    public void createUserAccount(String name, String password) {
        mediator.addUser(new User(name, password));
    }
    @Override
    public void updateUserAccount(String name, String password) {
        User user = this.mediator.getUserByName(name);
        if(user != null){
            if (name != null) {
                user.setName(name);
            }
            if (password != null) {
                user.setPassword(password);
            }
            this.mediator.updateUser(user);
        }
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
    @Override
    public void processOrder(String productName, String name, String paymentStrategy) {
        Product product = this.mediator.getProductByName(productName);
        User user = this.mediator.getUserByName(name);
        PaymentStrategy strategy = this.mediator.getPaymentStrategyByName(paymentStrategy);

        if (product != null && user != null && strategy != null) {
            this.mediator.processOrder(product, user, strategy);
        }
        else{
            System.out.println("Order not processed");
        }
    }



}
