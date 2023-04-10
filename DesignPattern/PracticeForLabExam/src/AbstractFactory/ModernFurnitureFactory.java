package AbstractFactory;

public class ModernFurnitureFactory implements MakeFurnitureFactory {
    @Override
    public void createFurniture() {
        Chair chair = new ModernChair();
        Sofa sofa = new ModernSofa();
        chair.create();
        sofa.create();
    }

}
