package TPE_SS14_IMB08.PUE3;

/**
 * Suchklasse zur Breitensuche in einem Graphen.
 * @author IMB08
 *
 * @param <T> Typ des Graphen.
 */
public class SearchWide<T> implements SearchStrategy<T> {

    private NodeList<T> path;
    
    /**
     * Erstellt ein neues Suchobjekt mit einem Pfad in dem der Verlauf der
     * zuletzt ausgefuehrten Suche gespeichert wird.
     */
    public SearchWide(){
        this.path = new NodeListImpl<T>();
    }
    /**
     * 
     * @see TPE_SS14_IMB08.PUE3.SearchStrategy#search(java.lang.Object, 
     *  TPE_SS14_IMB08.PUE3.Node)
     */
    @Override
    public NodeList<T> search(T wert, Node<T> start) {
        path.clear();
        NodeList<T> matches = new NodeListImpl<T>();
        NodeListImpl<T> queue = new NodeListImpl<T>();

        queue.add(start);
        
        while(!queue.isEmpty()){
            Node<T> tmp = queue.pollFirst();
            if(!path.contains(tmp)) {
                path.add(tmp);
                NodeListImpl<T> tmpKind = tmp.getChildren();
//              while (!tmpKind.isEmpty()) {
//              queue.add(tmpKind.pollFirst());
//            }
                queue.addAll(tmpKind);
                if(tmp.getValue().equals(wert)) {
                    matches.add(tmp);
                }
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
