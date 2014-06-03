package TPE_SS14_IMB08.PUE4.A1;

import java.util.*;

public class Saal implements Iterable<Object>{
    //iterable ueber Object, da FilmZeit innere Klasse ist,
    //und wir ausserhalb nur die toString()-Methode brauchen
    
    private String name;
    private int sitzplaetze;
    private ArrayList<FilmZeit> filme;

    /**
     * Innere Klasse, um Filme mit Anfangszeiten zusammenzufuegen
     * @author Dominik
     *
     */
    class FilmZeit {
        Film film;
        Zeit anfangszeit;
        
        FilmZeit(Film film, Zeit anfangszeit) {
            this.film = film;
            this.anfangszeit = anfangszeit;
        }
        
        @Override
        public boolean equals(Object o) {
            FilmZeit f = (FilmZeit) o;
            if(this.film.equals(f.film) && this.anfangszeit.equals(f.anfangszeit)) {
                return true;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            
            return this.film.hashCode()*this.anfangszeit.hashCode();
            
        }
        
        @Override
        public String toString() {
            return "" + anfangszeit + " -- " + film;
        }
    }
    
    public Saal(String name, int sitzplaetze) {
        this.name = name;
        this.sitzplaetze = sitzplaetze;
        filme = new ArrayList<FilmZeit>();
    }

    /**
     * Fuegt einen Film in die Liste der Filme dieses Saales ein
     * @param film  Film
     * @param anfangszeit   Anfangszeit
     * @return  true, wenn erfolgreich
     */ 
    //abfragen, ob anderer Film laeuft!
    public boolean addFilm(Film film, Zeit anfangszeit) {
        FilmZeit neuerFilm = new FilmZeit(film, anfangszeit);
        if(!filme.contains(neuerFilm)) {
            filme.add(neuerFilm);
            return true;
        }
        return false;
    }
    /**
     * Fuegt einen Film in die Liste der Filme dieses Saales ein
     * @param film  Film
     * @param anfangszeit Anfangszeit als String
     * @return  true, wenn erfolgreich
     */
    public boolean addFilm(Film film, String anfangszeit) {
        Zeit anfang = new Zeit(anfangszeit);
        return addFilm(film, anfang);
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
        for (Object o: this) {
            tmp = tmp + o + "\n";
        }
        return tmp;
               
        
    }

    @Override
    public Iterator<Object> iterator() {
        Iterator<Object> iti = new Iterator<Object>() {

            private int pos = 0;
            
            @Override
            public boolean hasNext() {
                return (pos < filme.size());
            }

            @Override
            public FilmZeit next() {
                return filme.get(pos++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
        return iti;
    }
    
    
    
}
