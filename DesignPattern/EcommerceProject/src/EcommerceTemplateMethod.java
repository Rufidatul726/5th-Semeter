import java.util.List;

public class EcommerceTemplateMethod {
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

    public void displayProductDetails(String name){
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

    public void updateUserAccount(String name, String email, String password, String address){
        User user = this.mediator.getUserByEmail(email);
        if(user != null){
            if (name != null) {
                user.setName(name);
            }
            if (password != null) {
                user.setPassword(password);
            }
            if (address != null) {
                user.setAddress(address);
            }
            this.mediator.updateUser(user);
            System.out.println("User account updated successfully!");
        }
        else{
            System.out.println("User account not found!");
        }
    }

    public void processOrder(String productName, String userEmail , String paymentMethodName){
        Product product = this.mediator.getProductByName(productName);
        User user = this.mediator.getUserByEmail(userEmail);
        PaymentStrategy paymentStrategy = this.mediator.getPaymentStrategyByName(paymentMethodName);

        if(product!=null && user!=null && paymentStrategy!=null){
            this.mediator.processOrder(product, user, paymentStrategy);
        }
        else{
            System.out.println("Order failed!");
        }
    }


}
