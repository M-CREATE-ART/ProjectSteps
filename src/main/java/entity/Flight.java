package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class    Flight<formattedLocalDateTime>  {
    int count_persons;
    AirWays destination;

public String FlightDate(){
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.now();
    String formattedLocalDateTime = localDateTime.format(dateTimeFormatter);
    return  formattedLocalDateTime;
}

}
