package TPE_SS14_IMB08.PUE2.Figuren;
import TPE_SS14_IMB08.PUE2.*;

/**
 * Der Erzmagier ist ein Anführer der Menschen und erweitert deren Fähigkeiten 
 * entsprechend um Spezialfähigkeiten.
 * 
 * @author IMB08
 *
 */

public class Erzmagier extends Mensch implements Anfuehrer {

    /** 
     * Spezialfähigkeit des Erzmagiers, die nur jede dritte Runde eingesetzt
     * werden kann. Kann sie eingesetzt werden, erleidet der Erzmagier in dieser
     * Runde keinen Schaden. 
     * 
     * @return  gibt zurück, ob die Methode angewendet werden konnte, oder nicht.
     */
    public boolean absorption() {
        return (GameController.AKTUELLE_RUNDE % 3 == 0);
    }
    
    
    /**
     * Überschreibt die Methode werdeVerletzt() der Superklasse, da der 
     * Erzmagier in der Lage ist Verletzungen zu absorbieren.
     */
    @Override
    protected int werdeVerletzt(double damage){
        if (absorption()){
            return super.werdeVerletzt(0);
        } else{
            return super.werdeVerletzt(damage);
        }
    }
    
    /**
     * Überschreibt die Methode attack() der Superklasse, da der Erzmagier,
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
           if(a.beherrscheElement() == Element.LUFT){
               damage = damage *2;
            }
        }
        damage = w.werdeVerletzt(damage);
        return (int)damage;
    }
    
    /**
     * Überschreibt die Methode berechneDamgage() der Superklasse, da der
     * Erzmagier als Anführer, mehr Schaden verursacht.
     */
    @Override   //copy&paste!!!!!!!
    public double berechneDamage() {
        return super.berechneDamage() * bonus();
    }
    
    /**
     * Gibt zurück, welches Element der Erzmagier beherrscht.
     */
    @Override
    public Element beherrscheElement() {
        return Element.FEUER;
    }

    /**
     * Gibt den Bonus des Erzmagiers zurück.
     */
    @Override
    public double bonus() {
        return 5.0;
    }
    
    /**
     * Gibt die Rasse der Einheit und ihre aktuellen Lebenspunkte zurück.
     */
    @Override
    public String toString(){
        return "Erzmagier(Menschenanführer, " +this.lebenspunkte +"LP)";
    }
}
