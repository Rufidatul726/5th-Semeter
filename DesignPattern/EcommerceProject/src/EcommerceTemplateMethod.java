import java.util.List;

public abstract class EcommerceTemplateMethod {
    protected EcommerceMediator mediator;

    public EcommerceTemplateMethod(EcommerceMediator mediator) {

        this.mediator = mediator;
    }

    public void createUserAccount(String name, String email, String password, String address){

    }
    public void updateUserAccount(String name, String email, String password, String address){

    }

    public abstract void disPlayProductList();

    public abstract void displayProductDetails(String name);

    public void processOrder(String productName, String email, String paymentStrategy){

    }

    public void addProduct(String shirt, String a_shirt, double v, String s, int i){

    }

    public void updateProduct(String shirt, String a_shirt, double v, String s, int i){

    }

    public void removeProduct(Product product){

    }

    public void displayOrderConfirmation(String productName, String email, String paymentStrategy){

    }

    public void displayOrderReceipt(String productName, String email, String paymentStrategy){

    }


}
