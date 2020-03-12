package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class    Flight<formattedLocalDateTime>  {
    private int flightID;
    int count_persons;
    AirWays destination;

public String FlightDate(){
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.now();
    String formattedLocalDateTime = localDateTime.format(dateTimeFormatter);
    return  formattedLocalDateTime;
}

    public Flight(int flightID, int count_persons, AirWays destination) {
        this.flightID = flightID;
        this.count_persons = count_persons;
        this.destination = destination;
    }

    public int getFlightID() {
        return flightID;
    }

    public int getCount_persons() {
        return count_persons;
    }

    public AirWays getDestination() {
        return destination;
    }
}
