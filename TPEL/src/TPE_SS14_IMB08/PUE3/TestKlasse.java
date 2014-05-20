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
            dracula.search("P", sD);
            NodeList<String> sDListe = sD.getPath();
            NodeList<String> vergleich = new NodeListImpl<String>();
            vergleich.addLast(a);
            vergleich.addLast(b);
            vergleich.addLast(e);
            vergleich.addLast(h);
            vergleich.addLast(i);
            vergleich.addLast(f);
            vergleich.addLast(j);
            vergleich.addLast(k);
            vergleich.addLast(g);
            vergleich.addLast(c);
            vergleich.addLast(l);
            vergleich.addLast(m);
            vergleich.addLast(n);
            vergleich.addLast(d);
            vergleich.addLast(o);
            vergleich.addLast(p);
            assertEquals(vergleich, sDListe); 
        }
        
        @Test
        public void Breitensuche(){
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
            SearchWide<String> sW = new SearchWide<>();
            dracula.search("P", sW);
            NodeList<String> sWListe = sW.getPath();
            NodeList<String> vergleich = new NodeListImpl<String>();
            vergleich.addLast(a);
            vergleich.addLast(b);
            vergleich.addLast(c);
            vergleich.addLast(d);
            vergleich.addLast(e);
            vergleich.addLast(f);
            vergleich.addLast(g);
            vergleich.addLast(l);
            vergleich.addLast(m);
            vergleich.addLast(o);
            vergleich.addLast(p);
            vergleich.addLast(h);
            vergleich.addLast(i);
            vergleich.addLast(j);
            vergleich.addLast(k);
            vergleich.addLast(n);
            assertEquals(vergleich, sWListe); 
        }
    


        
       
    }

