package TPE_SS14_IMB08.PUE3;

public class KleineTestklasse {

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>("Node1", 9);
        Node<Integer> n2 = new Node<Integer>("Node1", 17);
        Node<Integer> n3 = new Node<Integer>("Node1", 8);
        
        n1.addChild(n3);
        n1.addChild(n2);
        System.out.println(n1.getChildren().pollFirst().getValue());
        System.out.println(n1.getChildren().pollFirst().getValue());

    }

}
