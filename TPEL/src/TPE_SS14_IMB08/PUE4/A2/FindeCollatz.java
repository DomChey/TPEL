package TPE_SS14_IMB08.PUE4.A2;

/**
 * Klasse um laengste CollatzFolge zu finden, gemaess Aufgabenstellung des 
 * Plichtuebungsblattes Nr. 4
 * 
 * @author IMB08
 *
 */
public class FindeCollatz {

    public static void main(String[] args) {
        
       
        Runnable runner1 = new RunnerCol();
        Runnable runner2 = new RunnerCol();
        Runnable runner3 = new RunnerCol();
        Runnable runner4 = new RunnerCol();
        
        Thread erster = new Thread(runner1);
        Thread zweiter = new Thread(runner2);
        Thread dritter = new Thread(runner3);
        Thread vierter = new Thread(runner4);
       
        erster.start();
        zweiter.start();
        dritter.start();
        vierter.start();
        try {
            erster.join();
            zweiter.join();
            dritter.join();
            vierter.join();
        }
        catch(InterruptedException ex){
                
        }
        
        System.out.println("Laengste CollatzFolge ist " 
                +RunnerCol.Counter.getLaengsteCollatz().getLaengeFolge()
                + " Folgeglieder lang.");
        System.out.println("Startwert der laengsten CollatzFolge ist: " 
                    +RunnerCol.Counter.getStartwert());
         
    }

}
