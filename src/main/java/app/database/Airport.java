package app.database;

public enum Airport {
    KYIV ("KBP"),
    ANKARA( "ESB"),
    SOFIA("SOF"),
    BAHRAIN("BAH"),
    GANDJA("KVD" );

    private String code;

    public String getCode() {
        return code;
    }

    Airport(String code) {
        this.code = code;
    }
}
