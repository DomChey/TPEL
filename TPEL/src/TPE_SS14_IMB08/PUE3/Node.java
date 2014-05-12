package TPE_SS14_IMB08.PUE3;

public class Node<T> {
    
    public String name;
    public T wert;
    public NodeListImpl<Node<T>> kinder;

    public Node(String name, T wert) {
        this.name = name;
        this.wert = wert;
        this.kinder = new NodeListImpl<Node<T>>();
    }
    
    public void addChild(Node<T> kind) {
        kinder.addLast(kind);
        
    }
    
    public NodeListImpl<Node<T>> getChildren(){
        return this.kinder;
    }
    
    public String getName(){
        return this.name;
    }
    
    public T getValue(){
        return this.wert;
    }
}
