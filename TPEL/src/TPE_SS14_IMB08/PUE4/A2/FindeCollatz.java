package TPE_SS14_IMB08.PUE4.A2;

public class FindeCollatz {

    public static void main(String[] args) {
        
       
        Runnable runner1 = new RunnerCol();
        Runnable runner2 = new RunnerCol();
//        Runnable runner3 = new RunnerCol();
//        Runnable runner4 = new RunnerCol();
        
        Thread erster = new Thread(runner1);
        Thread zweiter = new Thread(runner2);
//        Thread dritter = new Thread(runner3);
//        Thread vierter = new Thread(runner4);
       
        erster.start();
        zweiter.start();
//        dritter.start();
//        vierter.start();
        try {
            erster.join();
            zweiter.join();
//            dritter.join();
//            vierter.join();
        }
        catch(InterruptedException ex){
                
        }
        System.out.println("Laengste Folge " +Counter.getLaenge());
        System.out.println("Startwert Laengste " +Counter.getStartwert());
         
    }

}
