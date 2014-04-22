package TPE_SS14_IMB08.PUE2.Figuren;
import TPE_SS14_IMB08.PUE2.*;

/**
 * Der Farseer ist ein Anführer der Orks und erweitert deren Fähigkeiten
 * entsprechend um Spezialfähigkeiten.
 * 
 * @author IMB08
 *
 */

public class Farseer extends Ork implements Anfuehrer {
    
    /**
     * Eine Spezialfähigkeit des Farseer, die es ihm ermöglicht zwei zufällige
     * Einheiten des gegenerischen Squads vollständig auszulöschen. Sie kann 
     * nur jede dritte Runde eingesetzt werden.
     * 
     * @param s Gegenerisches Squad.
     */
    public void doppelschlag(Squad s) {
        if (GameController.AKTUELLE_RUNDE % 3 == 0){
            int erster = (int) (Math.random()*s.armee.length);
            int zweiter = (int) (Math.random()*s.armee.length);
            s.armee[erster].lebenspunkte = 0;
            s.armee[zweiter].lebenspunkte = 0;   
        }
    }
    
    /**
     * Überschreibt die Methode attack() der Superklasse, da der Farseer,
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
           if(a.beherrscheElement() == Element.WASSER){
               damage = damage *2;
            }
        }
        damage = w.werdeVerletzt(damage);
        return (int)damage;
    }
    
    /**
     * Überschreibt die Methode berechneDamgage() der Superklasse, da der
     * Farseer als Anführer, mehr Schaden verursacht.
     */
    @Override 
    public double berechneDamage() {
        return super.berechneDamage() * bonus();
    }
    
    /**
     * Gibt zurück, welches Element der Farseer beherrscht.
     */
    @Override
    public Element beherrscheElement() {
        return Element.ERDE;
    }
    
    /**
     * Gibt den Bonus des Farseer zurück.
     */
    @Override
    public double bonus() {
        return 1.2;
    }
    
    /**
     * Gibt die Rasse der Einheit und ihre aktuellen Lebenspunkte zurück.
     */
    @Override
    public String toString(){
        return "Farseer(Orkanführer, " +this.lebenspunkte +"LP)";
    }
}
