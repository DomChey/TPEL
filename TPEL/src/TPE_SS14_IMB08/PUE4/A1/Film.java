package TPE_SS14_IMB08.PUE4.A1;

import java.util.Comparator;

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

    
    public static class FSKComparator implements Comparator<Film> {

        @Override
        public int compare(Film f1, Film f2) {
            return f1.getAltersfreigabe().compareTo(f2.getAltersfreigabe());
        }

    }
    
    public static class LaufzeitComparator implements Comparator<Film>{

        @Override
        public int compare(Film f1, Film f2) {
            int tmp = 0;
            if (f1.getLaufzeit() < f2.getLaufzeit()) {
                tmp = -1;
            }
            if (f1.getLaufzeit() > f2.getLaufzeit()) {
                tmp = 1;
            }
                
            return tmp;
        }
        
    }
    
    public static class TitelComparator implements Comparator<Film>{
        
        @Override
        public int compare(Film f1, Film f2) {
            return f1.titel.compareTo(f2.titel);
        }
    }
}

