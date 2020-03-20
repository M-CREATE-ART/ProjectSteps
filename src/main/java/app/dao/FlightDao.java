package app.dao;

import app.database.Airport;
import app.entities.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightDao implements dao<Flight> {
    List<Flight> flights = new ArrayList<>();

    @Override
    public void add(Flight flight) {
        flights.add(new Flight(flight.getID(), flight.getDestination(),
                flight.getDate(), flight.getSeats(), flight.getFreeSeats()));
    }

    @Override
    public List<Flight> getAll() {
        return flights;
    }

    @Override
    public Flight getByID(int id) {
        return flights.get(id-1);
    }

    @Override
    public void save() {
        File file = new File("src/main/java/app/database/flights.txt");

        try {
            new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            for (Flight flight : flights) {
                bw.write(flight.toString());
                bw.write("\n");
            }

            bw.close();

        } catch (Exception e) {
            System.out.printf("Database file: '%s' not found! \n", file);

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                for (Flight flight : flights) {
                    bw.write(flight.toString());
                    bw.write("\n");
                }

                bw.close();

            } catch (Exception e1) {
                System.out.println("Oops! Something went wrong \n");
            }
        }

    }


    @Override
    public boolean delete(Flight flight) {
        if (flights.contains(flight)) {
            flights.remove(flight);
            return true;
        } else{
            return false;
        }

    }

    @Override
    public void getfromDB() {
        File file = new File("src/main/java/app/database/flights.txt");

        try {
            List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
            lines.stream().map(line -> line.split(" ")).forEach(split1 -> {
                flights.add(new Flight(Integer.parseInt(split1[0].trim()),
                        Airport.valueOf(split1[1].trim()),
                        split1[2].trim(),
                        Integer.parseInt(split1[3].trim()),
                        Integer.parseInt(split1[4].trim())));

            });

        } catch (Exception e) {
            System.out.printf(" Database file: '%s' not found! \n", file);
        }

    }


}
