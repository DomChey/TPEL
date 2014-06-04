package TPE_SS14_IMB08.PUE4.A1;

public class Film implements Comparable{
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
        return titel + " " + altersfreigabe + " " + laufzeit + " min";
    }
    
    @Override
    public boolean equals(Object o) {
        Film f = (Film)o;
        if(this.titel.equals(f.titel) && this.laufzeit==f.laufzeit && 
                this.altersfreigabe==f.altersfreigabe) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return titel.hashCode()*laufzeit*altersfreigabe.hashCode();
    }

    @Override
    public int compareTo(Object arg0) {
        // TODO Auto-generated method stub
        return 0;
    }
}
