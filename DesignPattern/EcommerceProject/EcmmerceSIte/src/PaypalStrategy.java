public class PaypalStrategy implements PaymentStrategy{
    private String email;
    private String password;

    public PaypalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " with Paypal");
    }

    public void handleRefund(double amount) {
        System.out.println("Refunding " + amount + " to Paypal");
    }

    public boolean verifyTransaction() {
        System.out.println("Verifying transaction with Paypal");
        return true;
    }

    public String toString() {
        return "Email: " + email + ", Password: " + password;
    }

    public boolean equals(PaypalStrategy other) {
        return email.equals(other.email) && password.equals(other.password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
