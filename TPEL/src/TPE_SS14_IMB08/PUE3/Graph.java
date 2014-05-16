package TPE_SS14_IMB08.PUE3;

public class Graph<T> implements SearchStrategy{
    private Node<T> head;
    
    public Graph(Node<T> head) {
        this.head = head;
    }
    
    public void search(T wert, String methode){    //noch nicht durchdacht
       head.getChildren();
    }
    
    public ListImpl<T> copyInto(ListImpl<T> list) {       //wie das?
        return list;
    }
}
