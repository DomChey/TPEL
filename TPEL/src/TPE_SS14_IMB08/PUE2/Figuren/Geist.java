package TPE_SS14_IMB08.PUE2.Figuren;

/**
 * Geister sind ätherische Wesen, haben daher keine Eigenschaften und können
 * auch nicht attackiert oder verletzt werden, können aber ihrerseits die 
 * anderen Wesen angreifen.
 * 
 * @author IMB08
 *
 */
public class Geist implements Kaempfer {
    
    /** 
     * Implementiert das Interface Kaempfer. Geister verursachen generell einen
     * Punkt Schaden.
     */
    @Override
    public int attack(Kaempfer k) {
        Wesen w = (Wesen)k;
        w.reduziereLebenspunkte(1);
        return 1;
    }

}
