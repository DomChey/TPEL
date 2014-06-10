package TPE_SS14_IMB08.PUE4.A1;

import java.util.Comparator;

/**
 * Ein Film in einem Kino. Er hat einen Titel, eine Laufzeit und eine FSK
 * 
 * @author IMB08
 *
 */
public class Film {
    private String titel;
    private int laufzeit;
    private FSK altersfreigabe;
    
    /**
     * Erstellt einen neuen Film mit Titel, Laufzeit und FSK.
     * 
     * @param titel Name des Films im Format String.
     * 
     * @param laufzeit Dauer des Films im Format int.
     * 
     * @param altersfreigabe FSK des Films
     */
    public Film(String titel, int laufzeit, FSK altersfreigabe) {
        this.titel = titel;
        this.laufzeit = laufzeit;
        this.altersfreigabe = altersfreigabe;
    }
    
    /**
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return titel + " " + altersfreigabe + " " + laufzeit + " min";
    }
    
    /**
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        Film f = (Film)o;
        if(this.titel.equals(f.titel) && this.laufzeit==f.laufzeit && 
                this.altersfreigabe==f.altersfreigabe) {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return titel.hashCode()*laufzeit*altersfreigabe.hashCode();
    }
    
    /**
     * Gibt die Laufzeit des Films zurueck.
     * 
     * @return Laufzeit im Format int
     */
    public int getLaufzeit() {
        return this.laufzeit;
    }
    
    /**
     * Gibt die FSK des Films zurueck.
     * 
     * @return FSK
     */
    public FSK getAltersfreigabe() {
        return this.altersfreigabe;
    }
    
    /**
     * Gibt den Titel des Films zurueck
     * 
     * @return Titel des Films im Format String
     */
    public String getTitel(){
       return titel; 
    }
    
    /**
     * Innere Klasse zur Sortierung von Filmen nach FSK
     * 
     * @author IMB08
     *
     */
    public static class FSKComparator implements Comparator<Film> {
        /**
         * 
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(Film f1, Film f2) {
            return f1.getAltersfreigabe().compareTo(f2.getAltersfreigabe());
        }

    }
    
    /** 
     * Innere Klasse zur Sortierung von Filmen nach Laufzeit.
     * 
     * @author IMB08
     *
     */
    public static class LaufzeitComparator implements Comparator<Film>{
        /**
         * 
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
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
    
    /**
     * Eine innere Klasse zur Sortierung von Filmen nach Titel.
     * 
     * @author IMB08
     *
     */
    public static class TitelComparator implements Comparator<Film>{
        
        /**
         * 
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(Film f1, Film f2) {
            return f1.getTitel().compareTo(f2.getTitel());
        }
    }
}

