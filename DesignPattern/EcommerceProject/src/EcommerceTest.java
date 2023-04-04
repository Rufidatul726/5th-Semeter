public class EcommerceTest {

    public static void main(String[] args) {
        EcommerceMediator mediator= new EcommerceMediator();
        mediator.addPaymentStrategy(new CreditCardStrategy());
        mediator.addPaymentStrategy(new PaypalStrategy());
        mediator.addPaymentStrategy(new BkashStrategy());

        EcommerceTemplateMethod customerTemplate;
        customerTemplate = new EcommerceTemplateMethod(mediator);



        mediator.addProduct(new Product("Shirt", "A shirt", 10.0, "shirt.jpg", 10));
        mediator.addProduct(new Product("Pants", "A pants", 20.0, "pants.jpg", 20));
        mediator.addProduct(new Product("Shoes", "A shoes", 30.0, "shoes.jpg", 30));

        customerTemplate.disPlayProductList();
        customerTemplate.displayProductDetails("Shirt");

        customerTemplate.createUserAccount("John Doe", "johndoe@example.com",  "password", "123 Main St.");
        customerTemplate.createUserAccount("Jane Smith", "janesmith@example.com","password2", "456 Main St.");

        customerTemplate.processOrder("Shirt", "johndoe@example.com", "Credit Card");
        customerTemplate.processOrder("Pants", "janedoe@example.com", "Paypal");
        customerTemplate.processOrder("Shoes", "johndoe@example.com", "Bkash");

        customerTemplate.updateUserAccount();

    }


}
