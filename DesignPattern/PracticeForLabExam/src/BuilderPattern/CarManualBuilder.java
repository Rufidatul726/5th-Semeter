package BuilderPattern;

public class CarManualBuilder implements Builder{

        private CarManual carManual;

        public CarManualBuilder() {
            this.reset();
        }

        @Override
        public void reset() {
            this.carManual = new CarManual();
        }

        @Override
        public void setSeats(int number_of_seats) {
            this.carManual.setSeats(number_of_seats);
        }

        @Override
        public void setEngine(String engine) {
            this.carManual.setEngine(engine);
        }

        @Override
        public void setTripComputer() {
            this.carManual.setTripComputer();
        }

        @Override
        public void setGPS() {
            this.carManual.setGPS();
        }

        public CarManual getCarManual() {
            CarManual result = this.carManual;
            this.reset();
            return result;
        }
}
