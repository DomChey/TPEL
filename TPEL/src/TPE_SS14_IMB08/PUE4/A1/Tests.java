package TPE_SS14_IMB08.PUE4.A1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

    @Test
    public void zeitTest() {
        Zeit a  = new Zeit(7, 17);
        assertEquals("07:17", a.toString());
        Zeit b  = new Zeit("12:17");
        assertEquals("12:17", b.toString());      
    }
    
    @Test (expected= IllegalArgumentException.class)
    public void zeitTestBroken1(){
        new Zeit(99,99);
    }    
    
    @Test (expected= IllegalArgumentException.class)
    public void zeitTestBroken2(){
        new Zeit("0:99");
    }
   
    @Test
    public void  zeitvergleich(){
        Zeit z1 = new Zeit(12,33);
        Zeit z2 = new Zeit(13,55);
        Zeit z3 = new Zeit(12,33);
        Zeit z4 = new Zeit(12,34);
        Zeit z5 = new Zeit(12,35);
        assertEquals(-1, z1.compareTo(z2));
        assertEquals(0, z1.compareTo(z3));
        assertEquals(1, z2.compareTo(z1));
        assertEquals(-1, z3.compareTo(z4));
        assertEquals(1, z5.compareTo(z4));
    }
}
