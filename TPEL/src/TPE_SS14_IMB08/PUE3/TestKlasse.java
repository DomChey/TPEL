package TPE_SS14_IMB08.PUE3;

public class TestKlasse {

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
        Node<String> l = new Node<String>("l", "L");
        Node<String> m = new Node<String>("m", "M");
        Node<String> n = new Node<String>("n", "N");
        Node<String> o = new Node<String>("o", "O");
        Node<String> p = new Node<String>("p", "P");
               
        a.addChild(b);
        a.addChild(c);
        a.addChild(d);
        b.addChild(e);
        b.addChild(f);
        b.addChild(g);
        c.addChild(l);
        c.addChild(m);
        d.addChild(o);
        d.addChild(p);
        e.addChild(h);
        e.addChild(i);
        f.addChild(j);
        f.addChild(k);
        m.addChild(n);
        
        
        Graph<String> dracula = new Graph<String>(a);
        
        NodeList<String>liste = new NodeListImpl<String>();
        liste = dracula.copyInto(liste);        
        for(Node<String> knoten: liste) {
            System.out.print(knoten + ", ");
        }
        
        System.out.println("\n");
        
        
    


        
        SearchStrategy<String> sD = new SearchDeep<String>();
        NodeList<String> result = dracula.search("C", sD);
        System.out.println("DeepErgebnis: " + result);       
        System.out.println("DeepPath: " + sD.getPath());
        
        System.out.println(a.getChildren());
        
        SearchStrategy<String> sW = new SearchWide<String>();
        NodeList<String> ergebnis = dracula.search("C", sW);
        System.out.println("WideErgebnis: " + ergebnis);       
        System.out.println("WidePath: " + sW.getPath());
        
        SearchStrategy<String> swW = new SearchWide<String>();
        NodeList<String> wergebnis = dracula.search("C", swW);
        System.out.println("WideErgebnis: " + wergebnis);       
        System.out.println("WidePath: " + swW.getPath());
    
        System.out.println(a.getChildren());
    }

}
