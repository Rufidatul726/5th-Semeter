package BuilderPattern;

public class Appliation {

        public static void main(String[] args) {
            Director director = new Director();
            CarBuilder carBuilder = new CarBuilder();


            director.constructSportsCar(carBuilder);
            Car car = carBuilder.getCar();
//            System.out.println("Car built:\n" + car.getCarType());

            CarManualBuilder carManualBuilder = new CarManualBuilder();
            director.constructSUV(carManualBuilder);
            CarManual carManual = carManualBuilder.getCarManual();
//            System.out.println("Car manual built:\n" + carManual.getCarType());
        }
}
