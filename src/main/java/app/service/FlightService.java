package app.service;

import app.DAOFull.FlightDAO;
import app.Util.FlightGenerated;
import app.entity.Flight;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    public static void main(String[] args) throws FileNotFoundException {

        convert();

    }


    FlightDAO flightDao = new FlightDAO();

    public String generating() {
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
            } catch (IOException ex1) {
                System.out.println("Something wont wrong!");
            }
        }

        return fileName;
    }

    public static List<String> read(String filename) throws FileNotFoundException {
        File file = new File(filename);
        return new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
    }

    public static List<String> convert() {
        StringBuilder sb = new StringBuilder();
        String strLine = "";
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\namaz\\IdeaProjects\\ProjectSteps\\flight.txt"));
            while (strLine != null)
            {
                strLine = br.readLine();
                sb.append(strLine);
                sb.append(System.lineSeparator());
                strLine = br.readLine();
                if (strLine==null)
                    break;
                list.add(strLine);
            }
            System.out.println(Arrays.toString(list.toArray()));
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }

        return  list;
    }

}


