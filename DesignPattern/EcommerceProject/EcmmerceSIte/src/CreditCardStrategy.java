public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardStrategy(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " with credit card");
    }

    public void handleRefund(double amount) {
        System.out.println("Refunding " + amount + " to credit card");
    }

    public boolean verifyTransaction() {
        System.out.println("Verifying transaction with credit card");
        return true;
    }

    public String toString() {
        return "Card Number: " + cardNumber + ", CVV: " + cvv + ", Expiry Date: " + expiryDate;
    }

    public boolean equals(CreditCardStrategy other) {
        return cardNumber.equals(other.cardNumber) && cvv.equals(other.cvv) && expiryDate.equals(other.expiryDate);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

}
