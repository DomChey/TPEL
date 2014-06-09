package TPE_SS14_IMB08.PUE4.A1;

import java.util.*;

public class Saal {
    
    private String name;
    private int sitzplaetze;
    private TreeMap<Zeit, Film> filme;

    
    public Saal(String name, int sitzplaetze) {
        this.name = name;
        this.sitzplaetze = sitzplaetze;
        filme = new TreeMap<Zeit, Film>();
    }

    /** 
     * Fuegt einen neuen Film mit Startzeit in die Liste der Filme des Saals ein
     * 
     * @param film Film der eingefuegt werden soll
     * 
     * @param anfangszeit Zeit, zu welcher der Film starten soll
     * 
     * @throws IllegalTimeException Wenn der neue Film zur gleichen Zeit starten
     *      soll, wie ein bereist vorhandener, oder die Lauf- und Startzeiten
     *      kollidieren, wird eine IllegalTimeException geworfen.
     */
    public void addFilm(Film film, Zeit anfangszeit)
            throws IllegalTimeException {
        //Startet ein Film zur gleichen Zeit?
        if(filme.containsKey(anfangszeit)){ 
            throw new IllegalTimeException("Es startet zur gleichen Zeit ein Film");  
        }
        Zeit endzeit = anfangszeit.addTime(film.getLaufzeit());
        Zeit vorgaenger = filme.floorKey(anfangszeit); // naechst kleinere key, 
                //also Startzeit des vorherigen Films
        
        Zeit nachfolger = filme.ceilingKey(anfangszeit); //naechst groessere key,
                //also Startzeit des nachfolgenden Films
        
        if(vorgaenger != null){ //es gibt ueberhaupt einen Film, der frueher startet
           Zeit vorgaengerEnde = vorgaenger.addTime(filme.get(vorgaenger).getLaufzeit());
           if (vorgaengerEnde.compareTo(anfangszeit) >= 0){
               throw new IllegalTimeException("Der vorhergehende Film läuft noch");
           }
        }
        if (nachfolger != null){ //es gibt ueberhaupt einen nachfolgenden Film
            if(endzeit.compareTo(nachfolger)>= 0){
                throw new IllegalTimeException("Es wuerde ein Film in der "
            +"Laufzeit des Neuen starten");
            }
        }
         //Wenn bis hier keine Exception kam, kann der Film hinzugefuegt werden
        filme.put(anfangszeit, film);
    }
    /**
     * Fuegt einen Film in die Liste der Filme dieses Saales ein
     * 
     * @param film  Film
     * 
     * @param anfangszeit Anfangszeit als String
     * 
     * @return  true, wenn erfolgreich
     */
    public void addFilm(Film film, String anfangszeit)
            throws IllegalTimeException{
        Zeit anfang = new Zeit(anfangszeit);
        addFilm(film, anfang);
    }
    
    /**
     * @return Anzahl Sitzplaetze
     */
    public int getSitzplaetze() {
        return sitzplaetze;
    }

    /**
     * @return Name des Saals
     */
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()*this.sitzplaetze;
    }
    
    @Override
    public boolean equals(Object o) {
        Saal s = (Saal) o;
        if (this.name.equals(s.name) && this.sitzplaetze == s.sitzplaetze) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String tmp = "Saal '" + name + "' (" + sitzplaetze + " Plaetze) \n";
        NavigableSet<Zeit> schluessel = filme.navigableKeySet();
        Iterator<Zeit> iti = schluessel.iterator();
        while (iti.hasNext()){
            Zeit key = iti.next();
           tmp = tmp + key.toString() + " " +filme.get(key).toString() +"\n";
        }
        return tmp; 
    }
    


    public String[] getFilmeMitZeiten() {
        String[] filmMitZeiten = new String[filme.size()];
        int index = 0;
        NavigableSet<Zeit> schluessel = filme.navigableKeySet();
        Iterator<Zeit> iti = schluessel.iterator();
        while (iti.hasNext()){
            Zeit key = iti.next();
            filmMitZeiten[index] = key.toString() + " " +filme.get(key).toString();
            index++;
        }
        return filmMitZeiten;
    }
    
    
    public ArrayList<Film> getAlleFilme() {
        ArrayList<Film> alleFilme = new ArrayList<Film>();
        Collection<Film> tmp = filme.values();
        Iterator<Film> iti = tmp.iterator();
        while(iti.hasNext()){
            alleFilme.add(iti.next()); 
        }
        return alleFilme;
    }
    
    
}
