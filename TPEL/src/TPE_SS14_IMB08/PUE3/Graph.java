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
     * Erstellt einen neuen Graphen mit dem uebergebenen Knoten als 
     * Anfangsknoten. 
     * 
     * @param head  Anfagngsknoten des Graphen
     */
    public Graph(Node<T> head) {
        this.head = head;
    }
    
    /**
     * Kopiert alle Knoten des Graphen in eine uebergebene Liste.
     * 
     * @param liste uebergebene Liste, in welche die Knoten eingetragen werden.
     * @return veraenderte Liste mit eingetragenen Knoten.
     */
    public NodeList<T> copyInto(NodeList<T> liste) {
        liste.addLast(head);
        return copyIntoRek(head, liste);
    }
    
    private NodeList<T> copyIntoRek(Node<T> anfang, NodeList<T> liste) {
        NodeList<T> tmp = anfang.getChildren();

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
     * uebergebenen Suchstrategie
     * @param wert  zu suchender Wert
     * @param strategie Strategie entsprechend welcher der Graph durchsucht
     *                  werden soll
     * @return Liste der Knoten, die den gesuchten Wert enthalten
     */
    public NodeList<T> search(T wert, SearchStrategy<T> strategie) {
        return strategie.search(wert, this.head);
    }
        

}
