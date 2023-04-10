package BuilderPattern;

public class Director {

    public void constructSportsCar(Builder builder) {
        builder.reset();
        builder.setSeats(2);
        builder.setEngine("V8");
        builder.setTripComputer();
        builder.setGPS();
    }

    public void constructSUV(Builder builder) {
        builder.reset();
        builder.setSeats(5);
        builder.setEngine("V6");
        builder.setTripComputer();
        builder.setGPS();
    }
}
