package app.service;

import app.Util.FlightGenerated;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    public static List<String> main(String[] args) {


        FlightGenerated flights = new FlightGenerated();
        String fileName = "flight.txt";
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            list = br.lines().collect(Collectors.toList());
            if (list.size() == 0) {
                FileWriter writer = new FileWriter(fileName);
                flights.flightGenerator
                for (String str : arr) {
                    writer.write(str + System.lineSeparator());
                }
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }


        return list;
    }

}


