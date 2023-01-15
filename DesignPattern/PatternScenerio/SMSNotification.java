public class SMSNotification implements Notification{
    private static SMSNotification instance = null;
    private SMSNotification() {
    }

    public static SMSNotification getInstance() {
        if (instance == null) {
            instance = new SMSNotification();
        }
        return instance;
    }

    @Override
    public void notifyUser() {
        System.out.println("Sending SMS...");
    }
}
