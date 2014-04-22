package TPE_SS14_IMB08.PUE2.Figuren;
import TPE_SS14_IMB08.PUE2.*;

/**
 * Der Lich ist ein Anführer der Untoten und erweitert deren Fähigkeiten
 * entsprechend um Spezialfähigkeiten.
 * 
 * @author IMB08
 *
 */

public class Lich extends Untoter implements Anfuehrer{
    
    /**
     * Spezialfähigkeit des Lich, die jeder Einheit des gegnerischen Squads 7
     * Lebenspunkte entzieht und die Lebenspunkte des Lich um den entsprechenden
     * Wert erhöht. Sie kann nur jede dritte Runde eingesetzt werden.
     * 
     * @param s Gegnerisches Squad
     */
    public void verwesung(Squad s) {
        if (GameController.AKTUELLE_RUNDE % 3 == 0){
            int zaehler = 0;
            for (int i = 0; i < s.armee.length; i++){
                if(s.armee[i].isLebendig()){
                    s.armee[i].reduziereLebenspunkte(7);
                    zaehler = zaehler + 7;
                }
            }
            this.lebenspunkte = this.lebenspunkte + zaehler;
        }
    }
    

    /**
     * Überschreibt die Methode attack() der Superklasse, da der Lich,
     * wenn er einen anderen Anführer angreift unter der Voraussetzung dass sein
     * Element dessen Element überlegen ist, mehr Schaden verursacht. Ansonsten 
     * zeigt die Methode das gleiche Verhalten wie die Methode der Superklasse.
     */
    @Override
    public int attack(Kaempfer k) {
        Wesen w = (Wesen)k;
        double damage = this.berechneDamage();
        if (w instanceof Anfuehrer){
           Anfuehrer a = (Anfuehrer)w;
           if(a.beherrscheElement() == Element.FEUER){
               damage = damage *2;
            }
        }
        damage = w.werdeVerletzt(damage);
        return (int)damage;
    }
    
    /**
     * Überschreibt die Methode berechneDamgage() der Superklasse, da der
     * Lich als Anführer, mehr Schaden verursacht.
     */
    @Override
    public double berechneDamage() {
        return super.berechneDamage() * bonus();
    }
    
    /**
     * Gibt zurück, welches Element der Lich beherrscht.
     */
    @Override
    public Element beherrscheElement() {
        return Element.WASSER;
    }
    
    /**
     * Gibt den Bonus des Farseer zurück.
     */
    @Override
    public double bonus() {
        return 2.3;
    }
    
    /**
     * Gibt die Rasse der Einheit und ihre aktuellen Lebenspunkte zurück.
     */
    @Override
    public String toString(){
        return "Lich(Untotenanführer, " +this.lebenspunkte +"LP)";
    }
}
