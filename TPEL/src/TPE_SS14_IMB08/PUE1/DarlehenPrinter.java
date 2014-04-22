package TPE_SS14_IMB08.PUE1;

public class DarlehenPrinter {

    public static void main(String[] args) {
        Darlehen d1 = new Darlehen(200000.0, 3.5, 1.5);
        Darlehen d2 = new Darlehen(100000.0, 5.5, 3.0);
        Darlehen d3 = new Darlehen(300000.0, 6.0, 2.5);
       
        Darlehen[] d1jahre = d1.jahresDaten(10);
        Darlehen[] d2jahre = d2.jahresDaten(10);
        Darlehen[] d3jahre = d3.jahresDaten(10);

        
        System.out.println("Jahr" +"\t" +"Zins" +"\t\t" +"Tilgung" +"\t\t" 
                +"Restschuld");
        System.out.println();
        for (int i=0; i<d1jahre.length; i++){
            System.out.println(d1jahre[i].datenToString());
        }
        
        System.out.println();
        System.out.println("Jahr" +"\t" +"Zins" +"\t\t" +"Tilgung" +"\t\t" 
                +"Restschuld");
        System.out.println();
        for (int i=0; i<d2jahre.length; i++){
            System.out.println(d2jahre[i].datenToString());
        }
        
        System.out.println();
        System.out.println("Jahr" +"\t" +"Zins" +"\t\t" +"Tilgung" +"\t\t" 
                +"Restschuld");
        System.out.println();
        for (int i=0; i<d3jahre.length; i++){
            System.out.println(d3jahre[i].datenToString());
        }
        
    }

}
