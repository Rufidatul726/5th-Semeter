import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject("E:\\5th-Semeter\\DesignPattern\\Observer\\file.txt");
        ConcreteObserver observer1 = new ConcreteObserver(subject, "Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver(subject, "Observer 2");
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        Thread thread = new Thread(subject::monitor);
        thread.start();

        // simulate changes to the file
        try {
            Path filePath = Paths.get("E:\\5th-Semeter\\DesignPattern\\Observer\\file.txt");
            for (int i = 1; i <= 100; i++) {
                String content = "File content " + i;
                Files.writeString(filePath, content);
                TimeUnit.SECONDS.sleep(100);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // stop monitoring the file and exit the program
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
