package AbstractFactory;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of furniture you want to create: ");
        String furnitureType = scanner.nextLine();

        MakeFurnitureFactory factory = AbstractFactory.getFactory(furnitureType);
        assert factory != null;
        factory.createFurniture();

    }

}
