
package TPE_SS14_IMB08.PUE4.A2;

/**
 * @author Domi
 *
 */
public class KleineTestklasse {
    
    public static void main(String[] args){
        
        Collatz c1 = new Collatz(13L);
        Collatz c2 = new Collatz(150L);
        Collatz c3 = new Collatz(120L);
        Collatz c4 = new Collatz(1000000L);
        Collatz c5 = new Collatz(837799L);
        
        for(Long blubb : c1){
            System.out.println(blubb);
        }
        System.out.println();
        for(Long blubb : c2){
            System.out.println(blubb);
        }
        System.out.println();
        for(Long blubb : c3){
            System.out.println(blubb);
        }
        System.out.println();
        for(Long blubb : c4){
            System.out.println(blubb);
        }
        for(Long blubb : c5){
            System.out.println(blubb);
            
        }
        System.out.println(c5.getLaengeFolge());
        
        

    }

}
