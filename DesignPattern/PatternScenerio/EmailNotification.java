public class EmailNotification implements Notification{
    private static EmailNotification instance = null;

    private EmailNotification() {
    }

    public static EmailNotification getInstance() {
        if (instance == null) {
            instance = new EmailNotification();
        }
        return instance;
    }
    public void notifyUser() {
        System.out.println("Sending email...");
    }
}
