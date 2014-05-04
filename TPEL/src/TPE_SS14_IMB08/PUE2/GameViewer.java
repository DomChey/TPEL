package TPE_SS14_IMB08.PUE2;

public class GameViewer {
    
    public static void printGame(){
        System.out.println("Spielrunde " + GameController.AKTUELLE_RUNDE);
        System.out.println(GameController.AKTUELLER_SPIELER +" ist an der Reihe.");
        System.out.println("Er attackiert " +
        GameController.AKTUELLER_VERTEIDIGER + " und verursacht "
        + GameController.SCHADEN +" Schaden. ");
        System.out.println();
        }
   
   
    public static void printSieger(){
        System.out.println("Sieger ist " +GameController.SIEGER);
    }

}
