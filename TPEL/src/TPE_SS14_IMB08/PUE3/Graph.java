package TPE_SS14_IMB08.PUE3;

public class Graph<T> implements SearchStrategy<T>{
    private Node<T> head;
    private NodeListImpl<T> path = new NodeListImpl<T>();
    
    public Graph(Node<T> head) {
        this.head = head;
    }
    
    
    public NodeListImpl<T> copyInto(NodeListImpl<T> liste) {
        liste.addLast(head);
        return copyIntoRek(head, liste);
    }
    
    private NodeListImpl<T> copyIntoRek(Node<T> anfang, NodeListImpl<T> liste) {
        NodeListImpl<T> tmp = anfang.getChildren();

        for(Node<T> knoten: tmp) {
            if(!liste.contains(knoten)) {
                liste.addLast(knoten);
                liste = copyIntoRek(knoten, liste);
            }
        }
        return liste;
    }

    @Override   //sollen wir hier ne Benutzerabfrage einbauen?
    public NodeListImpl<T> search(T wert) {
        return searchBreit(wert);
//        return searchTief(wert);
    }

    private NodeListImpl<T> searchBreit(T wert) {
        path.clear();
        NodeListImpl<T> matches = new NodeListImpl<T>();
        
        NodeListImpl<T> queue = new NodeListImpl<T>();
        
        path.add(head);
        //Kinder an Queue haengen       
        queue.addAll(head.getChildren());

        if(head.getValue().equals(wert)) {
            matches.add(head);
        }
        
        while(!queue.isEmpty()){
            Node<T> tmp = queue.pop();
            if(!path.contains(tmp)) {
                path.add(tmp);
                queue.addAll(tmp.getChildren());
                if(tmp.getValue().equals(wert)) {
                    matches.add(tmp);
                }
            }
        }
        
        return matches;
        
    }
    
    private NodeListImpl<T> searchTief(T wert) {
        path.clear();
        NodeListImpl<T> matches = new NodeListImpl<T>();
        path.addLast(head);
        if (head.getValue().equals(wert)) {
            matches.addLast(head);
        }
        return searchTiefRek(head, wert, matches);
    }
    
    
    private NodeListImpl<T> searchTiefRek(Node<T> anfang, T wert,
                                            NodeListImpl<T> matches) {

        NodeListImpl<T> tmp = anfang.getChildren();

        for(Node<T> knoten: tmp) {
            if(!path.contains(knoten)) {
                path.addLast(knoten);
                if (knoten.getValue().equals(wert)) {
                    matches.addLast(knoten);
                }
                matches = searchTiefRek(knoten, wert, matches);
            }
        }
        return matches;
    }
    
    
    @Override
    public NodeListImpl<T> getPath() {
        return path;
    }
}
