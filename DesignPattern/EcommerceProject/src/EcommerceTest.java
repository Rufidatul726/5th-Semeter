import java.util.List;
import java.util.Scanner;

public class EcommerceTest {

    public static void main(String[] args) {
        EcommerceMediator mediator= new EcommerceMediator();
        mediator.addPaymentStrategy(new CreditCardStrategy());
        mediator.addPaymentStrategy(new PaypalStrategy());
        mediator.addPaymentStrategy(new BkashStrategy());

        EcommerceTemplateMethod adminTemplate;
        adminTemplate = new AdminTemplateMethod(mediator);

        adminTemplate.addProduct("Shirt", "A_Shirt", 10.0, "shirt.jpg", 60);
        adminTemplate.addProduct("Pants", "A_Pants", 20.0, "pants.jpg", 30);
        adminTemplate.addProduct("Shoes", "A_Shoes", 30.0, "shoes.jpg", 21);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your user name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        String usertype = verifyUser(userName, password);

        if(usertype.equals("admin")){
            System.out.println("Add Product: ");

            while(true){
                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();

                System.out.print("Enter product description: ");
                String productDescription = scanner.nextLine();

                System.out.print("Enter product price: ");
                double productPrice = scanner.nextDouble();
                scanner.nextLine(); // Consume new line character

                System.out.print("Enter product image file name: ");
                String productImage = scanner.nextLine();

                System.out.print("Enter product Inventory: ");
                int productInventory = scanner.nextInt();
                scanner.nextLine(); // Consume new line character

                adminTemplate.addProduct(productName, productDescription, productPrice, productImage, productInventory);

                System.out.print("Do you want to add more product? (y/n): ");
                String choice = scanner.nextLine();
                if(choice.equals("n")){
                    break;
                }
            }

//            adminTemplate.addProduct("Gown", "Gown_a", 10.0, "gown.jpg", 60);
//            adminTemplate.addProduct("Sharee", "Sharee_B", 20.0, "sharee.jpg", 30);
//            adminTemplate.addProduct("Sandals", "A_Sandal", 30.0, "sandal.jpg", 21);
            System.out.println("Do you want to update product? (y/n):");
            String choice = scanner.nextLine();
            if(choice.equals("y")){
                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();

                System.out.print("Enter product description: ");
                String productDescription = scanner.nextLine();

                System.out.print("Enter product price: ");
                double productPrice = scanner.nextDouble();
                scanner.nextLine(); // Consume new line character

                System.out.print("Enter product image file name: ");
                String productImage = scanner.nextLine();

                System.out.print("Enter product Inventory: ");
                int productInventory = scanner.nextInt();
                scanner.nextLine(); // Consume new line character

                adminTemplate.updateProduct(productName, productDescription, productPrice, productImage, productInventory);
            }
            //adminTemplate.updateProduct("Gown", "Gown_a", 10.0, "gown.jpg", 60);

            System.out.println("Do you want to remove product? (y/n):");
            choice = scanner.nextLine();
            if(choice.equals("y")){
                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();
                adminTemplate.removeProduct(mediator.getProductByName(productName));
            }

            //adminTemplate.removeProduct(mediator.getProductByName("Gown"));


            adminTemplate.disPlayProductList();
        }
        else if(usertype.equals("customer")){
            EcommerceTemplateMethod customerTemplate;
            customerTemplate = new CustomerTemplateMethod(mediator);
            customerTemplate.createUserAccount(userName, password);
            System.out.println("Do you want to update your account? (y/n):");
            String choice2 = scanner.nextLine();
            if(choice2.equals("y")){
                System.out.print("Enter your new password: ");
                String newPassword = scanner.nextLine();
                customerTemplate.updateUserAccount(userName, newPassword);
            }

            customerTemplate.disPlayProductList();
//        customerTemplate.displayProductDetails("Shirt");
            System.out.println("Do you want to see product details? (y/n):");
            String choice = scanner.nextLine();
            if(choice.equals("y")){
                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();
                customerTemplate.displayProductDetails(productName);
            }

            System.out.println("Do you want to buy a product? (y/n):");
            String choice1 = scanner.nextLine();
            if(choice1.equals("y")){
                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();
                System.out.println("Choose payment method:");
                System.out.println("1. Credit Card");
                System.out.println("2. PayPal");
                System.out.println("3. Bkash");
                System.out.print("Enter your choice: ");
                String paymentMethodChoice = scanner.nextLine();
                scanner.nextLine(); // Consume new line character
                String paymentMethod = paymentMethodChoice.equals("1") ? "CreditCardStrategy" : paymentMethodChoice.equals("2") ? "PaypalStrategy" : "BkashStrategy";
                customerTemplate.processOrder(productName, userName, paymentMethod);
            }

//            customerTemplate.createUserAccount("Sharif",  "password");
//            customerTemplate.createUserAccount("Muktadul", "password2");

//            customerTemplate.updateUserAccount("Sharif", "password3");

//            customerTemplate.processOrder("Shirt", "Sharif", "CreditCardStrategy");
        }
        else{
            System.out.println("Invalid user");
        }
    }

    private static String verifyUser(String userName, String password) {
        User user = new User(userName, password);
        if (userName.equals("admin") && password.equals("admin123")) {
            System.out.println("Welcome, Admin!");
            return "admin";
        } else {
            System.out.println("Welcome, Customer!");
            return "customer";
        }

    }


}
