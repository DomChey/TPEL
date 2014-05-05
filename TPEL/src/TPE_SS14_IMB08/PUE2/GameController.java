package TPE_SS14_IMB08.PUE2;


/**
 * Der GameController startet ein Spiel und besitzt die Kenntnis über die
 * aktuelle Runde und welcher Spieler an der Reihe ist. 
 * 
 * @author IMB08
 *
 */
public class GameController {
    
    public static int AKTUELLE_RUNDE;
    public static Squad AKTUELLER_SPIELER;
    public static Squad AKTUELLER_VERTEIDIGER;
    public static int SCHADEN;
    public static Squad SIEGER; 
    
    
    
   /**
    * Startet ein neues Spiel mit zwei Spielern und lässt diese gegeneinadner 
    * antreten, bis eines der Squads vollständig ausgelöscht ist.
    */
  public static void runGame() {
        Squad player1 = new Squad("AGGRO", Rasse.ORK);
        Squad player2 = new Squad("ASSI", Rasse.MENSCH, Rasse.NACHTELF);
        GameController.AKTUELLE_RUNDE = 0;
        
        while (player1.nochKaempfer() && player2.nochKaempfer()){
           
            AKTUELLE_RUNDE++;
            AKTUELLER_SPIELER = player1;
            AKTUELLER_VERTEIDIGER = player2;
            SCHADEN= AKTUELLER_SPIELER.attackSquad(AKTUELLER_VERTEIDIGER);
            GameViewer.printGame();
            
            AKTUELLER_SPIELER = player2;
            AKTUELLER_VERTEIDIGER = player1;
            SCHADEN= AKTUELLER_SPIELER.attackSquad(AKTUELLER_VERTEIDIGER);
            GameViewer.printGame();
        }
            
            
          
        if(player1.nochKaempfer()){
           SIEGER = player1;
        } else {
            SIEGER = player2;
        }
        GameViewer.printSieger();

        
    }
   
    public static void main(String[] args) {
        runGame();
        
 
    }
}
