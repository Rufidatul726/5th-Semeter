public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        NotificationFactory notificationFactory = NotificationFactory.getInstance();
        notificationFactory.createNotification("Email").notifyUser();

        NotificationFactory notificationFactory2 = NotificationFactory.getInstance();
        notificationFactory2.createNotification("Push").notifyUser();

    }
}