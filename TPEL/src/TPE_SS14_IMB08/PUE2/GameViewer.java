package TPE_SS14_IMB08.PUE2;


/**
 * Der GameViewer gibt Infotmationen über den Spielverlauf aus, wie 
 * Rundenzahl, Angreifer, verursachten Schaden.
 * 
 * @author IMB08
 *
 */
public class GameViewer {
    /**
     * Gibt Nummer der aktuellen Spielrunde an, welcher Spieler dran ist, 
     * welcher angegriffen wird und wieviel Schaden durch die Attacke
     * verursacht wird.
     */
    public static void printGame(){
        System.out.println("Spielrunde " + GameController.AKTUELLE_RUNDE);
        System.out.println(GameController.AKTUELLER_SPIELER +" ist an der Reihe.");
        System.out.println("Er attackiert " +
        GameController.AKTUELLER_VERTEIDIGER + " und verursacht "
        + GameController.SCHADEN +" Schaden. ");
        System.out.println();
        }

   /**
    * Gibt den Sieger des Spiels aus. 
    */
    public static void printSieger(){
        System.out.println("Sieger ist " +GameController.SIEGER);
    }

}
