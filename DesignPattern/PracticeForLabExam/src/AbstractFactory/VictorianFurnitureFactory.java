package AbstractFactory;

public class VictorianFurnitureFactory implements MakeFurnitureFactory {
    @Override
    public void createFurniture() {
        Chair chair = new VictorianChair();
        Sofa sofa = new VictorianSofa();
        chair.create();
        sofa.create();
    }

}
