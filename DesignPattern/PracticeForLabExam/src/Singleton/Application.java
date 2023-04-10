package Singleton;

public class Application {
    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.getInstance();

        SingletonClass singletonClass2 = SingletonClass.getInstance();
        System.out.println(singletonClass == singletonClass2);
    }
}
