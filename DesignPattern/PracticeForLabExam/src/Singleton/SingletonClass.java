package Singleton;

public class SingletonClass {
    private static SingletonClass instance;

    private SingletonClass() {
        instance = null;
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}
