package TPE_SS14_IMB08.PUE3;

public class SearchDeep<T> implements SearchStrategy<T> {
    
    private NodeListImpl<T> path;
    
    public SearchDeep(){
        this.path = new NodeListImpl<>();
    }

    @Override
    public NodeListImpl<T> search(T wert, Node<T> start) {
        path.clear();
        NodeListImpl<T> matches = new NodeListImpl<T>();
        path.addLast(start);
        if (start.getValue().equals(wert)) {
            matches.addLast(start);
        }
        return searchTiefRek(wert, start, matches);
    }
    
    
    private NodeListImpl<T> searchTiefRek(T wert, Node<T> anfang,
                                            NodeListImpl<T> matches) {

        NodeListImpl<T> tmp = anfang.getChildren();

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

    @Override
    public NodeListImpl<T> getPath() {
        return this.path;
    }
    

}
