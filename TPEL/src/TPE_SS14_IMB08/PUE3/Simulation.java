package TPE_SS14_IMB08.PUE3;

public class Simulation {

    public static void main(String[] args) {
        Node<String> a = new Node<String>("a", "A");
        Node<String> b = new Node<String>("b", "B");
        Node<String> c = new Node<String>("c", "C");
        Node<String> d = new Node<String>("d", "D");
        Node<String> e = new Node<String>("e", "E");
        Node<String> f = new Node<String>("f", "F");
        Node<String> g = new Node<String>("g", "G");
        Node<String> h = new Node<String>("h", "H");
        Node<String> i = new Node<String>("i", "C");
        Node<String> j = new Node<String>("j", "J");
        Node<String> k = new Node<String>("k", "K");
        
        a.addChild(b);
        a.addChild(c);
        a.addChild(d);
        
        b.addChild(a);
        b.addChild(e);
        b.addChild(f);
        b.addChild(g);
        b.addChild(h);
        
        e.addChild(h);
        e.addChild(i);
        
        f.addChild(j);
        f.addChild(k);
        
        g.addChild(d);
        
        h.addChild(b);
        
        j.addChild(i);
        
        k.addChild(d);
    }
}
