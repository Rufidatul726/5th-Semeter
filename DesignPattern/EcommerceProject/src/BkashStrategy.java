public class BkashStrategy implements PaymentStrategy {
    private String phoneNumber;
    private String pin;
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " with Bkash");
    }

    public boolean verifyTransaction() {
        System.out.println("Verifying transaction with Bkash");
        return true;
    }

    public String toString() {
        return "Phone Number: " + phoneNumber + ", PIN: " + pin;
    }

    public boolean equals(BkashStrategy other) {
        return phoneNumber.equals(other.phoneNumber) && pin.equals(other.pin);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }


}
