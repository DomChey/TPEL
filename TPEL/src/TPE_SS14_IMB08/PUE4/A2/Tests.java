
package TPE_SS14_IMB08.PUE4.A2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author IMB08
 *
 */
public class Tests {

    @Test
    public void testCollatzErstellen() {
        Collatz c1 = new Collatz(3L);
        Collatz c2 = new Collatz(13L);
        Collatz c3 = new Collatz(5L);
        long s1 = c1.getStartwert();
        long s2 = c2.getStartwert();
        long s3 = c3.getStartwert();
        assertEquals(3L, s1);
        assertEquals(13L, s2);
        assertEquals(5L, s3);
    }
    
    @Test
    public void testCollatzLaenge(){
        Collatz c1 = new Collatz(3L);
        Collatz c2 = new Collatz(13L);
        Collatz c3 = new Collatz(5L);
        
        for( Long iti: c1){
            
        }
        for(Long iti: c2){
            
        }
        for(Long iti: c3){
            
        }
        
        long l1 = c1.getLaengeFolge();
        long l2 = c2.getLaengeFolge();
        long l3 = c3.getLaengeFolge();
        
        assertEquals(8L, l1);
        assertEquals(10L, l2);
        assertEquals(6L, l3);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void CollatzTestBroken1(){
        Collatz c1 = new Collatz(0L);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void CollatzTestBroken2(){
        Collatz c1 = new Collatz(-1L);
    }

}
