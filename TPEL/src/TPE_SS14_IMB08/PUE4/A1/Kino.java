package TPE_SS14_IMB08.PUE4.A1;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Kino implements Iterable<Kino>{

    String name;
    String stadt;
    Set<Saal> saele;
    
    public Kino(String name, String stadt) {
        this.name = name;
        this.stadt = stadt;
        saele = new HashSet<Saal>();
        addSaal();
    }
    
    public void addSaal() {
        //Benutzereingabe:
        String name = "Hallo";
        int sitzplaetze = 12;
        
        Saal neuerSaal = new Saal(name, sitzplaetze);
        
        saele.add(neuerSaal);
        
    }

    @Override
    public Iterator<Kino> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
