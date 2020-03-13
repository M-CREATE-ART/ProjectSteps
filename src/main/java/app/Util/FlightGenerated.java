package app.Util;

import app.entity.AirWays;
import app.entity.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class FlightGenerated {
    public static ArrayList<Flight> flightGenerator(int count) {
        Random random = new Random();
        ArrayList<Flight> flightGenerator = new ArrayList<>();

        ArrayList<AirWays> randomDesti= new ArrayList<>();
        EnumSet.allOf(AirWays.class).forEach(air -> randomDesti.add(air));
        int seats = 10;
        for (int i = 0; i < count; i++) {
            int randomDestiIdx = random.nextInt(randomDesti.size());
            int randonDate=random.nextInt(5);
            AirWays randomDest= randomDest.get(randomDestiIdx);
            DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            LocalDateTime localDateTime= LocalDateTime.now();
            LocalDateTime flightDateTime= LocalDateTime.plusDays(randonDate).plusHours(randonDate).plusMinutes(randonDate);

            String formattedFlightDate= flightDateTime.format(dateTimeFormatter);


            FlightGenerated.add(new Flight(i+1, 5, 5, 3));

            return FlightGenerated;




        }


    }

    private static void add(Flight flight) {
    }

}
