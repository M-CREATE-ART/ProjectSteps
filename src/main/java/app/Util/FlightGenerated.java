package app.Util;

import app.entity.AirWays;
import app.entity.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class FlightGenerated {
    public static  ArrayList<Flight> flightGenerator(int count) {
        Random random = new Random();
        ArrayList<Flight> flightGenerated = new ArrayList<>();

        ArrayList<AirWays> randomDesi = new ArrayList<>();
        EnumSet.allOf(AirWays.class).forEach(air -> randomDesi.add(air));
        int countSeats = 10;
        for (int i = 0; i < count; i++) {
            int randomDestiIdx = random.nextInt(randomDesi.size());
            int randonDate = random.nextInt(10);
            AirWays randomDest = randomDesi.get(randomDestiIdx);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime flightDateTime = localDateTime.plusDays(randonDate).plusHours(randonDate).plusMinutes(randonDate);

            String formattedFlightDate = flightDateTime.format(dateTimeFormatter);

            flightGenerated.add(new Flight(i + 1, 10, randomDest, i+1, formattedFlightDate));


           //return flightGenerator;


        }


        return flightGenerated;
    }


    public static void main(String[] args) {
        System.out.println(flightGenerator(1));
    }


}
