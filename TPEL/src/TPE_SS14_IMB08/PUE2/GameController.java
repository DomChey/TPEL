package TPE_SS14_IMB08.PUE2;

import TPE_SS14_IMB08.PUE2.Figuren.*;

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
        Squad player1 = new Squad("eins", Rasse.ORK);
        Squad player2 = new Squad("zwei", Rasse.MENSCH, Rasse.NACHTELF);
        GameController.AKTUELLE_RUNDE = 0;
        
        while (player1.nochKaempfer() && player2.nochKaempfer()){
            GameController.AKTUELLE_RUNDE++;
            GameController.AKTUELLER_SPIELER = player1;
            System.out.println("Spielrunde " + AKTUELLE_RUNDE);
            System.out.println(AKTUELLER_SPIELER +" ist an der Reihe.");
            for (int i = 0; i < player1.armee.length; i++){
                Wesen angreifer = player1.armee[i];
                Wesen verteidiger = 
                     player2.armee[(int)(Math.random()*(player2.armee.length))];
                if (angreifer.isLebendig() && verteidiger.isLebendig()){
                   System.out.println(player1 +" attackiert " + player2 
                           + " und verursacht " +angreifer.attack(verteidiger)
                           + " Schaden.");
                } else if (angreifer.isLebendig()){
                    System.out.println(player1 + " verfehlt seinen Gegener.");
                }
            }
            GameController.AKTUELLER_SPIELER = player2;
            System.out.println(AKTUELLER_SPIELER +" ist an der Reihe.");
            for (int i = 0; i < player2.armee.length; i++){
                Wesen angreifer = player2.armee[i];
                Wesen verteidiger = 
                     player1.armee[(int)(Math.random()*(player1.armee.length))];
                if (angreifer.isLebendig() && verteidiger.isLebendig()){
                    System.out.println(player2 +" attackiert " + player1 
                            + " und verursacht " +angreifer.attack(verteidiger)
                            + " Schaden.");
                } else if (angreifer.isLebendig()){
                    System.out.println(player2 + " verfehlt seinen Gegener.");
                }
                
            }

        }
        
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
