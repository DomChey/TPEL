package TPE_SS14_IMB08.PUE3;

/**
 * Suchklasse zur Tiefensuche in einem Graphen.
 * @author IMB08
 *
 * @param <T> Typ des Graphen.
 */
public class SearchDeep<T> implements SearchStrategy<T> {
    
    private NodeList<T> path;
    
    /**
     * Erstellt ein neues Suchobjekt mit einem Pfad in dem der Verlauf der
     * zuletzt ausgefuehrten Suche gespeichert wird.
     */
    public SearchDeep(){
        this.path = new NodeListImpl<>();
    }
   /**
    * @see TPE_SS14_IMB08.PUE3.SearchStrategy#search(java.lang.Object, 
    *   TPE_SS14_IMB08.PUE3.Node)
    */
    @Override
    public NodeList<T> search(T wert, Node<T> start) {
        path.clear();
        NodeList<T> matches = new NodeListImpl<T>();
        path.addLast(start);
        if (start.getValue().equals(wert)) {
            matches.addLast(start);
        }
        return searchTiefRek(wert, start, matches);
    }
    
    
    private NodeList<T> searchTiefRek(T wert, Node<T> anfang,
                                            NodeList<T> matches) {

        NodeList<T> tmp = anfang.getChildren();

        for(Node<T> knoten: tmp) {
            if(!path.contains(knoten)) {
                path.addLast(knoten);
                if (knoten.getValue().equals(wert)) {
                    matches.addLast(knoten);
                }
                matches = searchTiefRek(wert, knoten, matches);
            }
        }
        return matches;
    }
    /**
     * 
     * @see TPE_SS14_IMB08.PUE3.SearchStrategy#getPath()
     */
    @Override
    public NodeList<T> getPath() {
        return this.path;
    }
    

}
