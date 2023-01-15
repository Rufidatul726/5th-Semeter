public class PushNotification implements Notification{
    private static PushNotification instance = null;

    private PushNotification() {
    }

    public static PushNotification getInstance() {
        if (instance == null) {
            instance = new PushNotification();
        }
        return instance;
    }

    @Override
    public void notifyUser() {
        System.out.println("Sending push notification...");
    }

}
