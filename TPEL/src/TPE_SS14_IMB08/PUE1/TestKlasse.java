package TPE_SS14_IMB08.PUE1;

    import static org.junit.Assert.*;

import org.junit.Test;
    
    
    

public class TestKlasse {
    @Test
    public void testToString2() {
        assertEquals("123456,09", new Festkommazahl(123456L, 9L).toString());
        assertEquals("0,09", new Festkommazahl(0L, 9L).toString());
        assertEquals("56,00", new Festkommazahl(56L, 0L).toString());
    }

    
    
    @Test
    public void testAddition(){
        Festkommazahl f1 = new Festkommazahl(12L, 5L);
        Festkommazahl f2 = new Festkommazahl(0L, 0L);
        Festkommazahl f3 = new Festkommazahl(12L, 5L);
        
        assertEquals(f3,(f1.addiere(f2)));
    }
    
    @Test
    public void testSubtraktion(){
        Festkommazahl f1 = new Festkommazahl(12L, 5L);
        Festkommazahl f2 = new Festkommazahl(0L, 0L);
        Festkommazahl f3 = new Festkommazahl(12L, 5L);
        
        assertEquals(f3,(f1.subtrahiere(f2)));
    }
    
    
    @Test
    public void testMultFKZ(){
        Festkommazahl f1 = new Festkommazahl(12.25);
        Festkommazahl f2 = new Festkommazahl(12L, 25L, 4);
        Festkommazahl f3 = new Festkommazahl(1500625L, 4);
        
        assertEquals(f3,(f1.multipliziere(f2)));
    }
    
    @Test
    public void testMultDouble() {
        Festkommazahl f1 = new Festkommazahl(12.55);
        Festkommazahl f2 = new Festkommazahl(25.10);
        
        assertEquals(f2,(f1.multipliziere(2.0)));
    }
    
    @Test
    public void testDivision() {
        Festkommazahl f1 = new Festkommazahl(21.7);
        Festkommazahl f2 = new Festkommazahl(3.1);
        
        assertEquals(f2,(f1.dividiere(7.0)));
    }
    
    @Test
    public void testDivisionNull() {
        Festkommazahl f1 = new Festkommazahl(21.7);
        
        assertEquals(f1, f1.dividiere(0.0));
    }
    
    @Test
    public void testProzent() {
        Festkommazahl f1 = new Festkommazahl(12.5);
        Festkommazahl f2 = new Festkommazahl(6.25);
        
        assertEquals(f2,(f1.prozent(50.0)));         
    }
    
    @Test
    public void testGetVorkommaDouble(){
        Festkommazahl f1 = new Festkommazahl(12.5);
       
        assertEquals(12, f1.getVorkomma());        
    }
    
    @Test
    public void testGetVorkommaLong(){
        Festkommazahl f1 = new Festkommazahl(1234L, 4567L, 4);
        
        assertEquals(1234, f1.getVorkomma());
    }
    
    @Test
    public void testGetNachkommaDouble(){
        Festkommazahl f1 = new Festkommazahl(675.9889);
        
        assertEquals(98, f1.getNachkomma());
    }
    
    @Test
    public void testGetNachkommaLong(){
        Festkommazahl f1 = new Festkommazahl(1234L, 4556L);
        
        assertEquals(45, f1.getNachkomma());
    }
    
    @Test
    public void testGetAsDouble(){
        Festkommazahl f1 = new Festkommazahl(568L, 986L);
        double d1 = f1.getAsDouble();
        
        assertEquals(568.98, d1, 0.0001);
        
    }
    
    @Test
    public void testEqual(){
        Festkommazahl f1 = new Festkommazahl(12.5);
        Festkommazahl f2 = new Festkommazahl(12L, 50L, 4);
        
        assertTrue(f1.equals(f2));
    }
    
    @Test
    public void testToString(){
        Festkommazahl f1 = new Festkommazahl(0.0);
        
        assertEquals("0,00", f1.toString());
    }
    
}
