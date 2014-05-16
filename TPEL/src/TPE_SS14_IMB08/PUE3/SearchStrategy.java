package TPE_SS14_IMB08.PUE3;

public interface SearchStrategy<T> {
    /**
     * Durchsucht vom Startknoten aus den Graphen nach einem bestimmten Wert
     * und bekommt alle passenden Knoten in einer NodeListe zurück.
     * @param wert  zu suchender Wert
     * @return      Liste mit passenden Knoten
     */
    public NodeListImpl<T> search(T wert);
    
    /**
     * Liefert den Weg, den die Suche beim letzten Durchlauf durch den
     * Graphen genomen hat.
     * @return letzter Weg
     */
    public NodeListImpl<T> getPath();
}
