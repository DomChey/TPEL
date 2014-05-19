package TPE_SS14_IMB08.PUE3;

/**
 * Interface zur Suche in Graphen.
 * 
 * @author IMB08
 *
 * @param <T> Typ des zu durchsuchenden Graphen.
 */

public interface SearchStrategy<T> {
    /**
     * Durchsucht vom Startknoten aus den Graphen nach einem bestimmten Wert
     * und bekommt alle passenden Knoten in einer NodeListe zurück.
     * @param wert  zu suchender Wert
     * @param start TODO
     * @return      Liste mit passenden Knoten
     */
    public NodeList<T> search(T wert, Node<T> start);
    
    /**
     * Liefert den Weg, den die Suche beim letzten Durchlauf durch den
     * Graphen genomen hat.
     * @return letzter Weg
     */
    public NodeList<T> getPath();
}
