package AbstractFactory;

public class VictorianChair implements Chair{
    @Override
    public void create() {
        System.out.println("Victorian chair created");
    }
}
