package AbstractFactory;

public abstract class AbstractFactory {
//    MakeFurnitureFactory makeFurnitureFactory;

    public static MakeFurnitureFactory getFactory(String factoryType){
        if(factoryType.equals("Modern")){
            return new ModernFurnitureFactory();
        }else if(factoryType.equals("Victorian")){
            return new VictorianFurnitureFactory();
        }else{
            return null;
        }
    }

    public abstract void createFurniture();

}
