package app.service;

import app.DAOFull.FlightDAO;
import app.Util.FlightGenerated;
import app.entity.Flight;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    FlightDAO flightDao = new FlightDAO();

    public void generating() throws IOException {
        FlightGenerated flightsGenerated = new FlightGenerated();
        String fileName = "flight.txt";
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
            list = br.lines().collect(Collectors.toList());
            if (list.size() == 0) {
                FileWriter writer = new FileWriter(fileName);

                for (Flight str : flightsGenerated.flightGenerator(5)) {
                    writer.write(str + System.lineSeparator());
                }
                writer.close();
            }
        } catch (IOException ex) {
            System.out.printf(" %s File not found! \n", fileName);

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
                  flightDao.getAll().addAll(FlightGenerated.flightGenerator(5));
                for (Flight flight : flightDao.getAll()) {
                    bw.write(flight.toString());
                    bw.write("\n");
                }
                bw.close();


            }
            catch (IOException ex1){

                System.out.println("Something wont wrong!");
            }

        }


    }
}


