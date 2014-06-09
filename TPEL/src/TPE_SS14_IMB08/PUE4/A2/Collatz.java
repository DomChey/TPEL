
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
    
    private int startwert;
    private ArrayList<Integer> folge;
   
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
        this.folge = new ArrayList<Integer>();
        while (n > 1){ 
            folge.add(n);
            if (n%2 == 0){
                n = n/2;
            } else {
                n = n*3+1;
            }
        }
        folge.add(n); // Muss hier eingefuegt werden, da bei n=1 die Schleife
                       // nicht durchlaufen wird, 1 aber Teil der Folge ist.
        
    }
    
    public Iterator<Integer> iterator() {
        Iterator<Integer> iti = new Iterator<Integer>() {

            private int pos = 0;
            /**
             * 
             * @see java.util.Iterator#hasNext()
             */
            @Override
            public boolean hasNext() {
                return (pos < folge.size());
            }
            /**
             * 
             * @see java.util.Iterator#next()
             */
            @Override
            public Integer next() {
                return folge.get(pos++);
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
