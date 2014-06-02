package TPE_SS14_IMB08.PUE4.A1;

public enum FSK {
    OHNE("ohne Altersbeschraenkung"), ab6("ab 6 Jahre"), ab12("ab 12 Jahre"),
        ab16("ab 16 Jahre"), ab18("keine Jugendfreigabe");
    
    private String text;
    
    FSK(String text) {
        this.text = text;
    }
    
    public String toString() {
        return "[" + text + "]";
    }
}
