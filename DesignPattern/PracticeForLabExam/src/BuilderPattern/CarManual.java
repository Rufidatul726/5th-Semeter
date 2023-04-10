package BuilderPattern;

public class CarManual {

        public CarManual() {
            System.out.println("Car manual created");
        }

        public void setSeats(int number_of_seats) {
            System.out.println("Car manual seats set to " + number_of_seats);
        }

        public void setEngine(String engine) {
            System.out.println("Car manual engine set to " + engine);
        }

        public void setTripComputer() {
            System.out.println("Car manual trip computer set to its trip to the moon");
        }

        public void setGPS() {
            System.out.println("Car manual GPS set to its default location to the moon");
        }
}
