package TPE_SS14_IMB08.PUE3;

public class Node<E> {
    
    private String name;
    private E wert;
    private NodeListImpl<E> kinder;

    public Node(String name, E wert) {
        this.name = name;
        this.wert = wert;
        this.kinder = new NodeListImpl<E>();
    }
    
    public void addChild(Node<E> kind) {
        kinder.addLast(kind);
        
    }
    
    public NodeListImpl<E> getChildren(){
        return this.kinder;
    }
    
    public String getName(){
        return this.name;
    }
    
    public E getValue(){
        return this.wert;
    }
    
    public String toString() {
        return getValue().toString();
    }
}
