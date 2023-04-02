public interface PaymentStrategy {
    public void processPayment(double amount);
    public void handleRefund(double amount);
    public boolean verifyTransaction();

}
