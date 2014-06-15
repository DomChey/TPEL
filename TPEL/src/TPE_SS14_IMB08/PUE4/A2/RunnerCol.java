package TPE_SS14_IMB08.PUE4.A2;

import java.util.Iterator;

/**
 * Via Threads nutzbare Klasse um laengste Collatzfolge unterhalb 1 Million 
 * zu finden.
 * 
 * @author IMB08
 *
 */
public class RunnerCol implements Runnable{

    /**
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run(){
        while(Counter.liesZaehler() < 1000000){
            Long startwert = Counter.getZaehler();
            Collatz col = new Collatz(startwert);
            Iterator<Long> iti = col.iterator();
            while(iti.hasNext()){
               iti.next();
                //und wenn er nicht gestorben ist, dann laeuft er noch heute
            }
            Counter.setLaengsteCollatz(col);
        }
    }
  
    /**
     * Innere Klasse zur Verwaltung der Werte der laengsten Collatz-Folge
     * 
     * @author IMB08
     *
     */
    public static class Counter {
        
        private static Long zaehler = 1L;
        private static Collatz laengsteCollatz = new Collatz(1L);
        
        /**
         * Gibt den naechsten Startwert fuer eine Collatzfolge zurueck.
         * 
         * @return Startwert fuer eine neue Folge
         */
        public synchronized static Long getZaehler(){
           zaehler = zaehler +1;
           return zaehler-1;
        }
        
        /**
         * Nimmt eine neue Collatzfolge entgegen und falls diese laenger ist als die
         * aktuell als langeste gespeicherte Folge, wird die uebergeben Folge als 
         * laengste Folge gespeichert.
         * 
         * @param c CollatzFolge, die als Laengste gesetzt werden soll
         */
        public synchronized static void setLaengsteCollatz(Collatz c){
            if (c.getLaengeFolge() > laengsteCollatz.getLaengeFolge()){
                laengsteCollatz = c;

            } 
        }
        
        /** 
         * Gibt die Langste CollatzFolge zurueck.
         * 
         * @return Laengste CollatzFolge
         */
        public static Collatz getLaengsteCollatz(){
            return laengsteCollatz;
        }
        
        /**
         * Gibt den Startwert der laengsten ColatzFolge zurueck.
         * 
         * @return Startwert der langsten CollatzFolge
         */
        public static Long getStartwert(){
            return laengsteCollatz.getStartwert();
        }
        
        /**
         * Liest den aktuellen Wert des Zaehlers, der als Startwert fuer neue 
         * CollatzFolgen dient, aus.
         * 
         * @return aktuller Wert des Zaehlers
         */
        public synchronized static Long liesZaehler(){
            return zaehler;
        }
    }

    
    

}
