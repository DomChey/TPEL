package TPE_SS14_IMB08.PUE3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestKlasse {
    
    @Test
    public void erstelleKnoten(){
        Node<Integer> eins = new Node<Integer>("eins", 1);
        Node<Double> zwei = new Node<Double>("zwei", 2.5);
        Node<String> drei = new Node<String>("drei", "Hallo");
        assertEquals("eins", eins.getName());
        assertEquals("zwei", zwei.getName());
        assertEquals("drei", drei.getName());
        assertEquals((Integer)1, eins.getValue());
        assertEquals((Double)2.5, zwei.getValue());
        assertEquals("Hallo", drei.getValue());
    }
        
        
        @Test
        public void Tiefensuche(){
            Node<String> a = new Node<String>("a", "A");
            Node<String> b = new Node<String>("b", "B");
            Node<String> c = new Node<String>("c", "C");
            Node<String> d = new Node<String>("d", "D");
            Node<String> e = new Node<String>("e", "E");
            Node<String> f = new Node<String>("f", "F");
            Node<String> g = new Node<String>("g", "G");
            Node<String> h = new Node<String>("h", "H");
            Node<String> i = new Node<String>("i", "I");
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
            SearchDeep<String> sD = new SearchDeep<>();
            NodeListImpl<String> sDListe = dracula.search("P", sD);
            NodeListImpl<String> vergleich = new NodeListImpl<String>();
            vergleich.
            
            
            
        }
        
        
//        Graph<String> dracula = new Graph<String>(a);
//        
//        NodeListImpl<String>liste = new NodeListImpl<String>();
//        liste = dracula.copyInto(liste);
//        
//        for(Node<String> knoten: liste) {
//            System.out.print(knoten + ", ");
//        }
//        
//        System.out.println("\n");
//        
//        SearchStrategy<String> sW = new SearchWide<String>();
//        NodeListImpl<String> ergebnis = dracula.search("C", sW);
//        System.out.println(ergebnis);       
//        System.out.println(sW.getPath());
//        
//        SearchStrategy<String> sD = new SearchDeep<String>();
//        NodeListImpl<String> result = dracula.search("C", sD);
//        System.out.println(result);       
//        System.out.println(sD.getPath());
//        
//        
    }

