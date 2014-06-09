package TPE_SS14_IMB08.PUE4.A1;

import java.util.*;

public class Kino implements Iterable<Saal>{

    private String name;
    private String stadt;
    private ArrayList<Saal> saele;
    
    private static Scanner eingabe;
    
    /**
     * neues Kino erstellen mit
     * @param name  Name des Kinos
     * @param stadt Stadt des Kinos
     * @param saal erster Saal des Kinos
     */
    public Kino(String name, String stadt, Saal saal) {
        this.name = name;
        this.stadt = stadt;
        eingabe = new Scanner(System.in);
        saele = new ArrayList<Saal>();
        saele.add(saal); //im neuen Kino muss noch nicht
                        //auf Duplikate ueberprueft werden
    }
    
    public Kino(String name, String stadt) {
        this(name, stadt, erstelleSaal());
    }
    
    public void addNeuerSaal() {
        Saal neuerSaal = erstelleSaal();
        addSaal(neuerSaal);
    }
    
    public void addSaal(Saal neuerSaal) {
        if (!saele.contains(neuerSaal)) {
            saele.add(neuerSaal);
        }
    }
    
    
    public static Saal erstelleSaal() {
        //Benutzereingabe:
        System.out.println("Name des Saals:");
        String name = eingabe.next();
        System.out.println("Anzahl Sitzplaetze:");
        int sitzplaetze = eingabe.nextInt();
        
        Saal neuerSaal = new Saal(name, sitzplaetze);
        
        return neuerSaal;
        
    }

    @Override
    public Iterator<Saal> iterator() {
        Iterator<Saal> iti = new Iterator<Saal>() {

            private int pos = 0;
            
            @Override
            public boolean hasNext() {
                return (pos < saele.size());
            }

            @Override
            public Saal next() {
                return saele.get(pos++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
          
        return iti;
    }
    
    @Override
    public String toString() {
        String tmp = name + " in " + stadt + "\n";
        for(Object o: this) {
           tmp = tmp + o + "\n"; 
        }
        return tmp;
    }
    
    public String[] getAlleFilmeMitZeiten() {
        LinkedList<String> tmp1 = new LinkedList<>();
        
        for(Saal aktuellerSaal: this) {
            String[] tmp2 = aktuellerSaal.getFilmeMitZeiten();
            for(int i = 0; i<tmp2.length; i++) {
                if(!tmp1.contains(tmp2[i])){
                    tmp1.add(tmp2[i]);
                }
            }
        }
        String[] alleFilmeMitZeiten = new String[tmp1.size()];
        tmp1.toArray(alleFilmeMitZeiten);
        return alleFilmeMitZeiten;
    }
    
    public String[] getFilmefuerSaalMitZeiten(Saal s) {
        return s.getFilmeMitZeiten();
    }
    
    public Film[] getAlleFilme() {
        return getAlleFilme(SortKrit.TITEL);
    }
    
    public Film[] getAlleFilme(SortKrit kriterium) {
        ArrayList<Film> alleFilmeDup = new ArrayList<>();
        for(Saal aktuellerSaal: this) {
            alleFilmeDup.addAll(aktuellerSaal.getAlleFilme());
        }
        
        ArrayList<Film> alleFilmeOhneDup = new ArrayList<>();
        for(Film aktFilm: alleFilmeDup) {
            if(!alleFilmeOhneDup.contains(aktFilm)) {
                alleFilmeOhneDup.add(aktFilm);
            }
        }
        
        Collections.sort(alleFilmeOhneDup);
    
        Film[] tmp = new Film[alleFilmeOhneDup.size()];
        return alleFilmeOhneDup.toArray(tmp);
    }
}
