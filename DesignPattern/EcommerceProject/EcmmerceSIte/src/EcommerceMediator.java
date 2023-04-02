import java.util.ArrayList;
import java.util.List;

public class EcommerceMediator {
    private List<Product> products;
    private List<User> users;
    private List<PaymentStrategy> paymentStrategies;

    public EcommerceMediator() {
        products = new ArrayList<Product>();
        users = new ArrayList<User>();
        paymentStrategies = new ArrayList<PaymentStrategy>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void updateProduct(Product product) {
        for (Product p : products) {
            if (p.equals(product)) {
                p.setName(product.getName());
                p.setDescription(product.getDescription());
                p.setPrice(product.getPrice());
                p.setImage(product.getImage());
                p.setInventory(product.getInventory());
            }
        }
    }

    public List<Product> getProductsList() {
        return this.products;
    }

    public Product getProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void updateUser(User user) {
        for (User u : users) {
            if (u.equals(user)) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                u.setPassword(user.getPassword());
                u.setAddress(user.getAddress());
            }
        }
    }

    public List<User> getUsersList() {
        return this.users;
    }

    public User getUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public void addPaymentStrategy(PaymentStrategy paymentStrategy) {
        paymentStrategies.add(paymentStrategy);
    }

    public void removePaymentStrategy(PaymentStrategy paymentStrategy) {
        paymentStrategies.remove(paymentStrategy);
    }

    public List<PaymentStrategy> getPaymentStrategiesList() {
        return this.paymentStrategies;
    }

    public PaymentStrategy getPaymentStrategyByName(String name) {
        for (PaymentStrategy ps : paymentStrategies) {
            if (ps.getClass().getName().equals("name")) {
                return ps;
            }
        }
        return null;
    }

    public void processOrder(Product product, User user, PaymentStrategy paymentStrategy) {
        if (product.getInventory() > 0) {
            paymentStrategy.processPayment(product.getPrice());
            product.setInventory(product.getInventory() - 1);
            System.out.println("Order processed successfully! Payement of $" + product.getPrice() + " has been received. ");
            System.out.println("A confirmation email has been sent to " + user.getEmail() + " with the details of the order.");
        }
        else {
            System.out.println("Order failed! Product out of stock!");
        }
    }
}
