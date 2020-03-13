package app.entity;

public class Flight<formattedLocalDateTime> {
    private int flightID;
    private int countSeats;
    private int reservedSeats;
    AirWays destination;


    public Flight(int flightID, int countSeats, AirWays destination, int reservedSeats) {
        this.flightID = flightID;
        this.countSeats = countSeats;
        this.destination = destination;
        this.reservedSeats = reservedSeats;

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
}
