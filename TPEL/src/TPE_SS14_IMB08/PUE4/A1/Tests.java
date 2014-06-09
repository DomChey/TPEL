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

}
