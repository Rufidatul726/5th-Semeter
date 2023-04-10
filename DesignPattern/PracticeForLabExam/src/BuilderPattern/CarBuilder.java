package BuilderPattern;

public class CarBuilder implements Builder{

    private Car car;

    public CarBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.car = new Car();
    }

    @Override
    public void setSeats(int number_of_seats) {
        this.car.setSeats(number_of_seats);
    }

    @Override
    public void setEngine(String engine) {
        this.car.setEngine(engine);
    }

    @Override
    public void setTripComputer() {
        this.car.setTripComputer();
    }

    @Override
    public void setGPS() {
        this.car.setGPS();
    }

    public Car getCar() {
        Car result = this.car;
        this.reset();
        return result;
    }

}
