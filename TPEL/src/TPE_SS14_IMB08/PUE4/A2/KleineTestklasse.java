
package TPE_SS14_IMB08.PUE4.A2;

/**
 * @author Domi
 *
 */
public class KleineTestklasse {
    
    public static void main(String[] args){
        
        Collatz c1 = new Collatz(13);
        Collatz c2 = new Collatz(150);
        Collatz c3 = new Collatz(120);
        Collatz c4 = new Collatz(1000000);
        
        for(Integer blubb : c1){
            System.out.println(blubb);
        }
        System.out.println();
        for(Integer blubb : c2){
            System.out.println(blubb);
        }
        System.out.println();
        for(Integer blubb : c3){
            System.out.println(blubb);
        }
        System.out.println();
        for(Integer blubb : c4){
            System.out.println(blubb);
        }
        
        

    }

}
