
package TPE_SS14_IMB08.PUE4.A2;

/**
 * @author IMB08
 *
 */
public class Counter {
    
    private static Long Wert = 1L;
    private static Long laengsteCollatz = 1L;
    private static Long startwertLaengsteFolge; 
    
    public synchronized static Long getWert(){
       Wert = Wert +1;
       return Wert-1;
    }
    
    public synchronized static void setLaengsteCollatz(Collatz c){
        if (c.getLaengeFolge() > laengsteCollatz){
            laengsteCollatz = c.getLaengeFolge();
            startwertLaengsteFolge = c.getStartwert();
        } 
    }
    public static Long getLaenge(){
        return laengsteCollatz;
    }
    
    public static Long getStartwert(){
        return startwertLaengsteFolge;
    }
}
