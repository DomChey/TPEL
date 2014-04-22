package TPE_SS14_IMB08.PUE2;

/**
 * Enummeration mit den einzelen Rassen des Spiels und den Kosten der einzelen 
 * Rassen.
 * 
 * @author IMB08
 *
 */
public enum Rasse {
    ORK (150), UNTOTER (70), MENSCH (110), NACHTELF (145);
    
    public int kosten;
    
    private Rasse(int kosten){
        this.kosten = kosten;
    }
}
