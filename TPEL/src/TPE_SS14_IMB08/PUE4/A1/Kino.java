package TPE_SS14_IMB08.PUE4.A1;

import java.util.*;
/**
 * Ein Kino mit Saeaelen, in einer Stadt
 * 
 * @author IMB08
 *
 */
public class Kino implements Iterable<Saal>{

    private String name;
    private String stadt;
    private ArrayList<Saal> saele;
    
    private static Scanner eingabe;
    
    /**
     * neues Kino erstellen mit
     * 
     * @param name  Name des Kinos
     * 
     * @param stadt Stadt des Kinos
     * 
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
    
    /**
     * Neues Kino erstellen mit Namen und Stadt. Saal wird waehrend des
     * Konstruktoraufrufes fuer Kino vom Nutzer neu erstellt.
     * 
     * @param name Name des Kinos
     * 
     * @param stadt Stadt des Kinos
     */
    public Kino(String name, String stadt) {
        this(name, stadt, erstelleSaal());
    }
     /** 
      * Ein neuer Saal wird erstellt und dem Kino hinzugefuegt.
      */
    public void addNeuerSaal() {
        Saal neuerSaal = erstelleSaal();
        addSaal(neuerSaal);
    }
    
    /**
     * Fuegt dem Kino einen neuen Saal hinzu.
     * 
     * @param neuerSaal hinzuzufuegender Saal
     */
    public void addSaal(Saal neuerSaal) {
        if (!saele.contains(neuerSaal)) {
            saele.add(neuerSaal);
        }
    }
    
    /**
     * Erstellt einen neuen Saal fuer das Kino.
     * 
     * @return neu erstellter Saal
     */
    public static Saal erstelleSaal() {
        //Benutzereingabe:
        System.out.println("Name des Saals:");
        String name = eingabe.next();
        System.out.println("Anzahl Sitzplaetze:");
        int sitzplaetze = eingabe.nextInt();
        
        Saal neuerSaal = new Saal(name, sitzplaetze);
        
        return neuerSaal;
        
    }
    /**
     * 
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<Saal> iterator() {
        Iterator<Saal> iti = new Iterator<Saal>() {

            private int pos = 0;
            /**
             * 
             * @see java.util.Iterator#hasNext()
             */
            @Override
            public boolean hasNext() {
                return (pos < saele.size());
            }
            /**
             * 
             * @see java.util.Iterator#next()
             */
            @Override
            public Saal next() {
                return saele.get(pos++);
            }
            /**
             * 
             * @see java.util.Iterator#remove()
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
          
        return iti;
    }
    
    /**
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String tmp = name + " in " + stadt + "\n";
        for(Object o: this) {
           tmp = tmp + o + "\n"; 
        }
        return tmp;
    }
    
    /**
     * Gibt alle Filme des Kinos mit ihren Laufzeiten und nach diesen sortiert
     * zurueck. Filme koenne doppelt vorkommen, wenn sie zu unterschiedlichen 
     * Zeiten laufen.
     * 
     * @return Filme mit Starzeiten in Form eines String-Arrays
     */
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
        alleFilmeMitZeiten = tmp1.toArray(alleFilmeMitZeiten);
        return alleFilmeMitZeiten;
    }
    
    /**
     * Gibt die Filme eines Saales des Kinos zurueck. Filme koennen
     * doppelt vorkommen, wenn sie zu unterschiedlichen Zeiten laufen.
     * 
     * @param s Saal des Kinos, dessen Filme gesucht sind
     * 
     * @return Filme mit Startzeiten in Form eines StringArrays
     */
    public String[] getFilmefuerSaalMitZeiten(Saal s) {
        return s.getFilmeMitZeiten();
    }
    
    /**
     * Gibt alle Filme des Kinos sortiert nach Titel zurueck. Filme kommen
     * hierbei nicht doppelt vor.
     * 
     * @return alle Filme des Kinos in Form eines Film-Arrays
     */
    public Film[] getAlleFilme() {
        return getAlleFilme(SortKrit.TITEL);
    }
    
    /**
     * Gibt alle Filme des Kinos sortiert nach dem jeweils gegeben Kriterium 
     * zurueck. Hierbei koennen Filme nicht doppelt vorkommen. 
     * 
     * @param kriterium Kriterium, nach dem die Filme soritert werden sollen. 
     *          Entwerder nach Titel, Laufzeit oder FSK.
     *          
     * @return alle Filme des Kinos in Form eines Film-Arrays
     */
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
        
        Film[] tmp = new Film[alleFilmeOhneDup.size()];
        tmp = alleFilmeOhneDup.toArray(tmp);
        
        switch (kriterium){
        case TITEL:
            Arrays.sort(tmp, new Film.TitelComparator());
            break;
        case LAUFZEIT:
            Arrays.sort(tmp, new Film.LaufzeitComparator());
            break;
        case FSK:
            Arrays.sort(tmp, new Film.FSKComparator());
            break;
        }
        return tmp;
    }
}
