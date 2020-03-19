package app.service;

import app.DAOFull.FlightDAO;
import app.Util.FlightGenerated;
import app.entity.Flight;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FlightService {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> flight = read("flight.txt");
        Map<String, List<String>> flightList = convert(flight);

    }

    FlightDAO flightDao = new FlightDAO();

    public String generating()  {
        FlightGenerated flightsGenerated = new FlightGenerated();
        String fileName = "flight.txt";
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
            list = br.lines().collect(Collectors.toList());
            if (list.size() == 0) {
                FileWriter writer = new FileWriter(fileName);

                for (Flight str : flightsGenerated.flightGenerator(10)) {
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

return fileName;
    }
    private static List<String> read(String filename) throws FileNotFoundException {
        File file = new File(filename);
        return new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
    }
    private static Map<String, List<String>> convert(List<String>  list) {
        String fileName = "flight.txt";
        HashMap<String, List<String>> data = new HashMap<>();
        for (String line: list) {
            String[] splitted = line.split(",");
            String[] splited2 = splitted[1].split(",");

            data.put(
                    splitted[0].trim(),
                    Arrays.stream(splited2).map(s -> s.trim()).collect(Collectors.toList())
            );
        }
        System.out.println(data);
        return data;
    }
}


