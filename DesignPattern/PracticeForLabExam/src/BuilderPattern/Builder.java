package BuilderPattern;

public interface Builder {
    public void reset();

    public void setSeats(int number_of_seats);

    public void setEngine(String engine);

    public void setTripComputer();

    public void setGPS();

}
