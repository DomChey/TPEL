package TPE_SS14_IMB08.PUE3;

/**
 *Graph bestehend aus einer beliebigen Anzahl von Knoten, wobei einer der
 *Knoten als Anfangsknoten ausgezeichnet wird.
 *
 * @author IMB 08
 * 
 * @param <T> Typ der Knoten
 * 

 */

public class Graph<T> implements SearchStrategy<T>{
    private Node<T> head;
    private NodeListImpl<T> path = new NodeListImpl<T>();
    
    /** 
     * Erstellt einen neuen Graphen mit dem übergebenen Knoten als 
     * Anfangsknoten. 
     * 
     * @param head  Anfagngsknoten des Graphen
     */
    public Graph(Node<T> head) {
        this.head = head;
    }
    
    /**
     * Kopiert alle Knoten des Graphen in eine übergebene Liste.
     * 
     * @param liste übergebene Liste, in welche die Knoten eingetragen werden.
     * @return veränderte Liste mit eingetragenen Knoten.
     */
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
