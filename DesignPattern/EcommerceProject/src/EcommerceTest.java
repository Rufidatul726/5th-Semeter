public class EcommerceTest {

    public static void main(String[] args) {
        EcommerceMediator mediator= new EcommerceMediator();
        mediator.addPaymentStrategy(new CreditCardStrategy());
        mediator.addPaymentStrategy(new PaypalStrategy());
        mediator.addPaymentStrategy(new BkashStrategy());

        EcommerceTemplateMethod adminTemplate;
        adminTemplate = new AdminTemplateMethod(mediator);

        adminTemplate.addProduct("Gown", "Gown_a", 10.0, "gown.jpg", 60);
        adminTemplate.addProduct("Sharee", "Sharee_B", 20.0, "sharee.jpg", 30);
        adminTemplate.addProduct("Sandals", "A_Sandal", 30.0, "sandal.jpg", 21);

        adminTemplate.updateProduct("Gown", "Gown_a", 10.0, "gown.jpg", 60);

//        adminTemplate.disPlayProductList();
//        adminTemplate.displayProductDetails("Gown");

        adminTemplate.removeProduct(mediator.getProductByName("Gown"));

//        adminTemplate.disPlayProductList();
//        adminTemplate.displayProductDetails("Gown");

        adminTemplate.addProduct("Shirt", "A_Shirt", 10.0, "shirt.jpg", 60);
        adminTemplate.addProduct("Pants", "A_Pants", 20.0, "pants.jpg", 30);
        adminTemplate.addProduct("Shoes", "A_Shoes", 30.0, "shoes.jpg", 21);

        EcommerceTemplateMethod customerTemplate;
        customerTemplate = new CustomerTemplateMethod(mediator);

        customerTemplate.disPlayProductList();
//        customerTemplate.displayProductDetails("Shirt");

        customerTemplate.createUserAccount("Sharif", "sharif@example.com",  "password", "Komlapur Bangladesh");
        customerTemplate.createUserAccount("Muktadul", "mkdl@example.com","password2", "Katabon Bangladesh");

        customerTemplate.updateUserAccount("Sharif", "sharif@example.com", "password3", "Komlapur Bangladesh");

        customerTemplate.processOrder("Shirt", "sharif@example.com", "CreditCardStrategy");
//        customerTemplate.processOrder("Pants", "mkdl@example.com", "PaypalStrategy");
//        customerTemplate.processOrder("Shoes", "sharif@example.com", "BkashStrategy");

    }


}
