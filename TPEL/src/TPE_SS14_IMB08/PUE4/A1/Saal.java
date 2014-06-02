package TPE_SS14_IMB08.PUE4.A1;

import java.util.Collection;

public class Saal {
    private String name;
    private int sitzplaetze;
    private Collection<FilmZeit> filme;

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
    }
    
    public Saal(String name, int sitzplaetze) {
        this.name = name;
        this.sitzplaetze = sitzplaetze;
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
        return "Saal '" + name + "' (" + sitzplaetze + " Plaetze)";
        
    }
    
}
