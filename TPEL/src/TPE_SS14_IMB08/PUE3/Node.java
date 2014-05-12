package TPE_SS14_IMB08.PUE3;

public class Node<T> {
    
    public String name;
    public T wert;
    public NodeListImpl kinder;

    public Node(String name, T wert) {
        this.name = name;
        this.wert = wert;
    }
    
    public void addChild(Node kind) {
        kinder.addLast(kind);
        
    }
}
