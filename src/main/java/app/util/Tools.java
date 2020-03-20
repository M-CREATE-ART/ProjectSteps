package app.util;

import app.database.Airport;
import app.entities.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tools {

    public static List<Flight> flightGenerator(int count) {
        Random random = new Random();
        ArrayList<Flight> generatedFlights = new ArrayList<>();

        List<Airport> destinations = Arrays.asList(Airport.values());
        int countSeats = 10;

        for (int i = 0; i < count; i++) {

            int randomDestIdx = random.nextInt(destinations.size());
            Airport randomDestination = destinations.get(randomDestIdx);

            int randomDate = random.nextInt(10);
            int randomTime = random.nextInt(15);

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd|HH:mm");
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime flightDateTime = localDateTime.plusDays(randomDate).plusHours(randomTime).plusMinutes(randomTime);

            String formattedFlightDate = flightDateTime.format(dateTimeFormatter);

            generatedFlights.add(new Flight(i + 1, randomDestination, formattedFlightDate, countSeats, countSeats));
        }

        return generatedFlights;
    }
}