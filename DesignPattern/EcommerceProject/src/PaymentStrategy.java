public interface PaymentStrategy {
    public void processPayment(double amount);
    public boolean verifyTransaction();

}
