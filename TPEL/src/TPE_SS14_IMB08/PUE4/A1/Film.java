package TPE_SS14_IMB08.PUE4.A1;

public class Film {
    private String titel;
    private int laufzeit;
    private FSK altersfreigabe;
    
    public Film(String titel, int laufzeit, FSK altersfreigabe) {
        this.titel = titel;
        this.laufzeit = laufzeit;
        this.altersfreigabe = altersfreigabe;
    }
    
    @Override
    public String toString() {
        return titel + " " + altersfreigabe + " " + laufzeit;
    }
    
    //+equals +hashCode
}
