
package TPE_SS14_IMB08.PUE4.A2;

/**
 * @author IMB08
 *
 */
public class Counter {
    private static Integer Wert = 1;
    private static Integer laengsteCollatz = 1;
    
    public synchronized static Integer getWert(){
       Integer tmp = Wert;
       Wert = Wert++;
       return tmp;
    }
    
    public synchronized static void setLaengsteCollatz(Collatz c){
        
        
    }

}
