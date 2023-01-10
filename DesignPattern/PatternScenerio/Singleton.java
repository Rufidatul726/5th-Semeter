import javax.management.Notification;

public class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance(){
        if(singleton==null){
            singleton= new Singleton();
        }
        return singleton;
    }
    public void showNotification(){
        System.out.println("This is a singleton design");
    }

}
