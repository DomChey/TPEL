
package TPE_SS14_IMB08.PUE4.A2;
import java.util.*;


/**
 * Klasse zur Verwaltung der einzelnen Elemente einer Collatz-Folge fuer einen
 * uebergebenen Startwert
 * 
 * @author IMB08
 *
 */
public class Collatz implements Iterable<Integer> {
    
    private Integer startwert;
    private Integer aktuellerWert;
    private Integer iteratorPosition;
   
    /**
     * Erstellt eine neue Collatz-Folge ab dem uebergebenen Startwert. Muss
     * eine Zahl groesser Null sein, da Folgen nur fuer natuerliche Zahlen 
     * definiert sind.
     * 
     * @param n Startwert der Folge im Format int
     * @throws IllegalArgumentException Wenn Startwert kleiner gleich 0 
     */
    public Collatz(int n) throws IllegalArgumentException{
        if (n<=0){
            throw new IllegalArgumentException("ungueltieger Startwert");
        }
       this.startwert = n;
       this.aktuellerWert = n;
       this.iteratorPosition = 1;
       
    }
    
    public Iterator<Integer> iterator() {
        Iterator<Integer> iti = new Iterator<Integer>() {

            /**
             * 
             * @see java.util.Iterator#hasNext()
             */
            @Override
            public boolean hasNext() {
                return aktuellerWert >1;
            }
            /**
             * 
             * @see java.util.Iterator#next()
             */
            @Override
            public Integer next() {
                if (aktuellerWert%2 == 0){
                    aktuellerWert = aktuellerWert/2;
                    iteratorPosition = iteratorPosition +1;
                    return aktuellerWert;
                } else {
                    aktuellerWert = aktuellerWert*3+1;
                    iteratorPosition  = iteratorPosition +1;
                    return aktuellerWert;
                }
            }
            /**
             * 
             * @see java.util.Iterator#remove()
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
          
        return iti;
    }
}
