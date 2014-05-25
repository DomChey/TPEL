package TPE_SS14_IMB08.PUE3;


/**
 * Generische Knoten. Jeder Knoten hat einen Namen, einen Wert beliebigen
 * Typs und beliebig viele Kinder, die in einer Liste verwaltet werden.
 * 
 * @author IMB08
 *
 * @param <E> Typ des Werts des Knoten.
 */
public class Node<E> {
    
    private String name;
    private E wert;
    private NodeListImpl<E> kinder;

    /**
     * Erstellt aus uebergebenem Namen und Wert einen neuen Knoten.
     * @param name Name des Knotens, vom Typ String
     * @param wert Wert des Knotens, von beliebigen Typ
     */
    public Node(String name, E wert) {
        this.name = name;
        this.wert = wert;
        this.kinder = new NodeListImpl<E>();
    }
    /**
     * Fuegt den uebergebenen Knoten als Kind hinzu, sofern er nicht schon ein
     * Kind ist.
     * @param kind Knoten, der als Kind gespeichert werden soll
     */
    public void addChild(Node<E> kind) {
        if (!this.kinder.contains(kind)){
            this.kinder.addLast(kind);
        }
    }
    /**
     * Gibt alle Kinder des Knotens in einer Liste zurueck.
     * @return Liste mit den Kindern des Knotens
     */
    public NodeListImpl<E> getChildren(){
        return this.kinder;
    }
    /**
     * Gibt den Namen des Knotens zurueck.
     * @return Name des Knoten
     */
    public String getName(){
        return this.name;
    }
    /**
     * Gibt den Wert des Knotens zurueck.
     * @return Wert des Knoten
     */
    public E getValue(){
        return this.wert;
    }
    /**
     * Gibt Namen und Wert des Knoten als String aus.
     */
    public String toString() {
        return getName() + getValue().toString();
    }

}
