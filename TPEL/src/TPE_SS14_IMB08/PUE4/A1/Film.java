package TPE_SS14_IMB08.PUE4.A1;

public class Film implements Comparable<Film>{
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

    public int getLaufzeit() {
        return this.laufzeit;
    }
    
    public FSK getAltersfreigabe() {
        return this.altersfreigabe;
    }
    
    
    //standardmaessig Titel vergleichen
    public int compareTo(Film o) {
        return this.titel.compareTo(o.titel);
    }
}
