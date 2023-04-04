import java.io.File;
import java.util.Date;

public class ConcreteObserver extends Observer {
    private final String name;

    public ConcreteObserver(ConcreteSubject subject, String name) {
        super(subject);
        this.name = name;
    }

    public void update() {
        ConcreteSubject concreteSubject = (ConcreteSubject) subject;
        String fileName = concreteSubject.getFileName();
        File file = new File(fileName);
        long lastModified = file.lastModified();
        String typeOfChange = "unknown";
        if (lastModified > super.subject.lastModified) {
            typeOfChange = "modified";
            System.out.printf("[%s] %s was %s at %tc\n", name, fileName, typeOfChange, new Date(lastModified));
        }
        //System.out.printf("[%s] %s was %s at %tc\n", name, fileName, typeOfChange, new Date(lastModified));
        super.subject.lastModified = lastModified;
    }

    public void displayDetails() {
        System.out.println(name + ": Displaying details of file " + subject.getFileName());
        // Display details of file change (e.g. the type of change made, the time of the change)
    }
}
