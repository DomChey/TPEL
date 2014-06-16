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
    
    
    Film[] sammlung = {new Film("Batman Begins", 134, FSK.ab12),
            new Film("Pulp Fiction", 148, FSK.ab16),
            new Film("From Dusk till Dawn", 87, FSK.ab16),
            new Film("Machete", 100, FSK.ab18)
    };
    
    Saal gelb = new Saal("gelber Saal", 234);
    Saal rot = new Saal("roter Saal", 10);
    Kino odeo = new Kino("Odeon Theater", "Entenhausen", gelb);
    
    @Test
    public void saalZuweisen() {
        odeo.addSaal(rot);
        
        assertEquals("Odeon Theater in Entenhausen\n"+
                    "Saal 'gelber Saal' (234 Plaetze) \n\n" +
                    "Saal 'roter Saal' (10 Plaetze) \n\n", odeo.toString());
        
    }
    
    @Test (expected=IllegalTimeException.class)
    public void filmEinfuegen() throws IllegalTimeException{
        gelb.addFilm(sammlung[0], new Zeit(17,00));
        gelb.addFilm(sammlung[1], new Zeit(16,10));
    }
    
    
}
