package TPE_SS14_IMB08.PUE2;

import static org.junit.Assert.*;

import org.junit.Test;

import TPE_SS14_IMB08.PUE2.Figuren.*;


public class TestKlasse {
    Wesen o = new Ork();
    Wesen m = new Mensch();
    Wesen n = new Nachtelf();
    Wesen u = new Untoter();
    Wesen f = new Farseer();
    Wesen e = new Erzmagier();
    Wesen d = new Daemonenjaeger();
    Wesen l = new Lich();
    Geist g = new Geist();
    
    @Test
    public void OrkVsX(){    
        assertEquals(71, o.attack(m));
        assertEquals(93, o.attack(o));
        assertEquals(106, o.attack(n));
        assertEquals(93, o.attack(u));
    }
    
    @Test
    public void MenschVsX(){
        assertEquals(560, m.attack(o));
        assertEquals(432, m.attack(m));
        assertEquals(640, m.attack(n));
        assertEquals(560, m.attack(u));
    }
    
    @Test
    public void NachtelfVsX(){
        assertEquals(91, n.attack(o));
        assertEquals(71, n.attack(m));
        assertEquals(104, n.attack(n));
        assertEquals(91, n.attack(u));
    }
    
    @Test
    public void UntoterVsX(){
        assertEquals(36, u.attack(o));
        assertEquals(28, u.attack(m));
        assertEquals(41, u.attack(n));
        assertEquals(36, u.attack(u));
    }
    
    @Test
    public void GeistVsXh(){
        assertEquals(1, g.attack(m));
    }
    
    @Test
    public void ErzmagierVsX(){
        assertEquals(2800, e.attack(o));
        assertEquals(6400, e.attack(d));
        assertEquals(e.attack(u), e.attack(l));
    }
    
    @Test
    public void FarseerVsX(){
        assertEquals(222, f.attack(l));
        assertEquals(f.attack(n), f.attack(d));
    }
    
    @Test
    public void LichVsX(){
        assertEquals(0, l.attack(e));
        assertEquals(82, l.attack(u));
    }
    
    @Test
    public void DämonenjägerVsX(){
        assertEquals(549, d.attack(f));
        assertEquals(212, d.attack(m));
    }
    
    @Test
    public void Squad(){
        Squad s1 = new Squad("Test1", Rasse.ORK);
        Squad s2 = new Squad("Test2", Rasse.NACHTELF);
        Squad s3 = new Squad("Test3", Rasse.MENSCH);
        Squad s4 = new Squad("Test4", Rasse.UNTOTER);
        Squad s5 = new Squad("Test5", Rasse.ORK, Rasse.MENSCH);
        Squad s6 = new Squad("Test6", Rasse.UNTOTER, Rasse.NACHTELF);
        assertEquals(12, s1.armee.length);
        assertEquals(12, s2.armee.length);
        assertEquals(17, s3.armee.length);
        assertEquals(27, s4.armee.length);
        assertEquals(13, s5.armee.length);
        assertEquals(18, s6.armee.length);
        assertTrue(s1.armee[0] instanceof Farseer);
        assertTrue(s1.armee[1] instanceof Ork);
        assertTrue(s2.armee[0] instanceof Daemonenjaeger);
        assertTrue(s5.armee[0] instanceof Farseer);
        assertTrue(s5.armee[5] instanceof Erzmagier);
        assertTrue(s6.armee[0] instanceof Lich);
        assertTrue(s6.armee[13] instanceof Daemonenjaeger);
    }
}
