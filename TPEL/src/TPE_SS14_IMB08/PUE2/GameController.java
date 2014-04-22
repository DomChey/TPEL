package TPE_SS14_IMB08.PUE2;

/**
 * Der GameController startet ein Spiel und besitzt die Kenntniss über die
 * aktuelle Runde und welcher Spieler an der Reihe ist. 
 * 
 * @author IMB08
 *
 */
public class GameController {
    
    public static int AKTUELLE_RUNDE;
    public static Squad AKTUELLER_SPIELER;
    
   /**
    * Startet ein neues Spiel mit zwei Spielern und lässt diese gegeneinadner 
    * antreten, bis eines der Squads vollständig ausgelöscht ist.
    */
  public static void runGame() {
        Squad player1 = new Squad("AGGRO", Rasse.ORK);
        Squad player2 = new Squad("ASSI", Rasse.MENSCH, Rasse.NACHTELF);
        GameController.AKTUELLE_RUNDE = 0;
        
        while (player1.nochKaempfer() && player2.nochKaempfer()){
            GameController.AKTUELLE_RUNDE++;
            GameController.AKTUELLER_SPIELER = player1;

            System.out.println("Spielrunde " + AKTUELLE_RUNDE);
            System.out.println(AKTUELLER_SPIELER +" ist an der Reihe.");
            AKTUELLER_SPIELER.attackSquad(player2);
            
            
            GameController.AKTUELLER_SPIELER = player2;
            System.out.println(AKTUELLER_SPIELER +" ist an der Reihe.");
            AKTUELLER_SPIELER.attackSquad(player1);

        }
        System.out.println("");
        if(player1.nochKaempfer()){
            System.out.println("Sieger ist " +player1);
        } else {
            System.out.println("Sieger ist " +player2);
        }
        
    }
   
    public static void main(String[] args) {
        runGame();
        
 
    }
}
