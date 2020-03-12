package entity;

public enum AirWays {
    KYIV ("KYV"),
    ANKARA( "ESB"),
    SOFIA("SOF"),
    BAHRAIN("BAH"),
    GANDJA("GND" );

     private String code;


    AirWays(String code) {
        this.code = code;
    }
}
