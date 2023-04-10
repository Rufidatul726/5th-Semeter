package AbstractFactory;

public class ModernChair implements Chair{
    @Override
    public void create() {
        System.out.println("Modern chair created");
    }
}
