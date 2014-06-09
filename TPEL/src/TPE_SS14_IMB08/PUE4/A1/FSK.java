package TPE_SS14_IMB08.PUE4.A1;

/**
 * Enum der in Deutschland ueblichen Alterbeschraenkungen fuer Filme.
 * 
 * @author IMB08
 *
 */

public enum FSK implements Comparable<FSK>{
    OHNE("ohne Altersbeschraenkung", 0), ab6("ab 6 Jahre", 1), ab12("ab 12 Jahre", 2),
        ab16("ab 16 Jahre", 3), ab18("keine Jugendfreigabe", 4);
    
    private String text;
    private int reihenfolge;
    
    FSK(String text, int reihenNummer) {
        this.text = text;
        this.reihenfolge = reihenNummer;
    }
    
    /**
     * 
     * @see java.lang.Enum#toString()
     */
    public String toString() {
        return "[" + text + "]";
    }
}
