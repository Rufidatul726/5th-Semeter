public class NotificationFactory {

    private static NotificationFactory instance = null;

    private NotificationFactory() {
    }

    public static NotificationFactory getInstance() {
        if (instance == null) {
            instance = new NotificationFactory();
        }
        return instance;
    }
    public Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) {
            return null;
        }
        if (channel.equalsIgnoreCase("SMS")) {
            return SMSNotification.getInstance();
        } else if (channel.equalsIgnoreCase("EMAIL")) {
            return EmailNotification.getInstance();
        }
        else if(channel.equalsIgnoreCase("PUSH")){
            return PushNotification.getInstance();
        }
        return null;
    }
}
