package app.service;

import app.Util.FlightGenerated;
import app.entity.Flight;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    public void generating() throws IOException {
        FlightGenerated flights = new FlightGenerated();
        String fileName = "flight.txt";
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            list = br.lines().collect(Collectors.toList());
            if (list.size() == 0) {
                FileWriter writer = new FileWriter(fileName);

                for (Flight str : flights.flightGenerator(5)) {
                    writer.write(str + System.lineSeparator());
                }
                writer.close();
            }
        } catch (IOException ex) {

            FileOutputStream fn = new FileOutputStream("flight.txt");
            fn.write(flights.flightGenerator(5).addAll(T));
            fn.flush();
            fn.close();


        }

    }

    public static void main(String[] args) {
        System.out.println();
    }
}


