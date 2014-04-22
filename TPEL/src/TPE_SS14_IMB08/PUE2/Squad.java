package TPE_SS14_IMB08.PUE2;
import TPE_SS14_IMB08.PUE2.Figuren.*;
/**
 * Squads haben einen Namen und eine Armee, die ein Array aus Wesen ist.
 * Außerdem haben sie ein Startkapital von 2000, das zum Kauf der Armee 
 * aufgewedet wird.
 * 
 * @author IMB08
 *
 */
public class Squad {
    public String name;
    public Wesen[] armee;
    public int kapital = 2000;
    
    /**
     * Erstellt ein neues Suqad mit dem übergebenen Namen und einem Array aus 
     * Wesen der übergebenen Rasse.
     * 
     * @param name Name des Squads
     * @param rasse Rasse der Wesen der Armee des Squads
     */
    Squad (String name, Rasse rasse){
        this.name = name;
        this.armee = WesenFactory.erzeuge(this.kapital, rasse);
    }
    
    /**
     * Erstellt ein neues Suqad mit dem übergebenen Namen und einem Array aus 
     * Wesen der übergebenen Rassen. Dabei wird das Kapital je hälftig für
     * die beiden Rassen genutzt.
     * 
     * @param name Name des Squads
     * @param rasse1 Rasse des einen Teils der Wesen des Squads
     * @param rasse2 Rasse des anderen Teils der Wesen des Squads
     */
    Squad (String name, Rasse rasse1, Rasse rasse2){
        this.name = name;
        this.armee = WesenFactory.erzeuge(this.kapital, rasse1, rasse2);
    }
    
    /**
     * Überprüft, ob in der Armee des Squads noch lebende Einheiten enthalten
     * sind.
     * 
     * @return true, falls noch lebende Einheiten vorhanden sind. Ansonsten
     *         false.
     */
    protected boolean nochKaempfer(){
        boolean lebendig = false;
        for (int i = 0; i < this.armee.length && !lebendig; i++){
            if(this.armee[i].isLebendig()){
                lebendig = true;
            }
        }
        return lebendig; 
    }
    
    /** 
     * Gibt den Namen des Squads zurück.
     */
    @Override
    public String toString(){
        return this.name;
    }
}
