package BuilderPattern;

public class Car {

    public Car() {
        System.out.println("Car created");
    }

    public void setSeats(int number_of_seats) {
        System.out.println("Car seats set to " + number_of_seats);
    }

    public void setEngine(String engine) {
        System.out.println("Car engine set to " + engine);
    }

    public void setTripComputer() {
        System.out.println("Car trip computer set to its default trip");
    }

    public void setGPS() {
        System.out.println("Car GPS set to its default location");
    }



}
