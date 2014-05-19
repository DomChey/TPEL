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

public class Graph<T>{
    private Node<T> head;
    
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
    /**
     * Durchsucht den Graphen nach einem bestimmten Wert entsprechend der 
     * übergebenen Suchstrategie
     * @param wert  zu suchender Wert
     * @param strategie Strategie nach der gesucht werden soll
     * @return Liste der Knoten, die den gesuchten Wert enthalten
     */
    public NodeListImpl<T> search(T wert, SearchStrategy<T> strategie) {
        return strategie.search(wert, this.head);
    }
        

}
