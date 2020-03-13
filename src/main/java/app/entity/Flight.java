package app.entity;

public class Flight<formattedLocalDateTime> {
    private int flightID;
    private int countSeats;
    private int reservedSeats;
    AirWays destination;
    String times;


    public Flight(int flightID, int countSeats, AirWays destination, int reservedSeats, String times) {
        this.flightID = flightID;
        this.countSeats = countSeats;
        this.destination = destination;
        this.reservedSeats = reservedSeats;
        this.times = times;

    }

    public int getFlightID() {
        return flightID;
    }

    public int getCountSeats() {
        return countSeats;
    }

    public AirWays getDestination() {
        return destination;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightID=" + flightID +
                ". countSeats=" + countSeats +
                ", reservedSeats=" + reservedSeats +
                ", destination=" + destination +
                ", times=" + times +
                '}';
    }
}
