package entity;

public class Booking {

   int user_id;
   int flight_id;

   public Booking(int user_id, int flight_id, AirWays user) {
      this.user_id = user_id;
      this.flight_id = flight_id;
      this.user = user;
   }

   AirWays user;


}
