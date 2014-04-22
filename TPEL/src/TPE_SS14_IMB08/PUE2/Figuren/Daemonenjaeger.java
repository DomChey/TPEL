package TPE_SS14_IMB08.PUE2.Figuren;
import TPE_SS14_IMB08.PUE2.*;

/**
 * Der Daemonenjaeger ist ein Anführer der Nachtelfen und erweitert deren 
 * Fähigkeiten entsprechend um Spezialfähigkeiten.
 * 
 * @author IMB08
 *
 */
public class Daemonenjaeger extends Nachtelf implements Anfuehrer{
    
    /**
     * Spezialfähigkeit des Dämonenjägers, die es ihm ermöglicht jeder Einheit
     * des gegnerischen Squads 25 Lebenspunkte zu entziehen. Sie kann nur jede
     * dritte Runde eingesetzt werden.
     * 
     * @param s gegenerisches Squad
     */
    public void goldSchuss(Squad s) {
        if (GameController.AKTUELLE_RUNDE % 3 == 0){
            for(int i = 0; i < s.armee.length; i++){
                if (s.armee[i].isLebendig()){
                   s.armee[i].reduziereLebenspunkte(25);
                }
            }
        }
    }
    /**
     * Überschreibt die Methode attack() der Superklasse, da der Dämonenjäger,
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
           if(a.beherrscheElement() == Element.ERDE){
               damage = damage *2;
            }
        }
        damage = w.werdeVerletzt(damage);
        return (int)damage;
    }
    /**
     * Überschreibt die Methode berechneDamgage() der Superklasse, da der
     * Dämonenjäger als Anführer, mehr Schaden verursacht.
     */
    @Override  
    public double berechneDamage() {
        return super.berechneDamage() * bonus();
    }
    /**
     * Gibt zurück, welches Element der Dämonenjäger beherrscht.
     */
    @Override
    public Element beherrscheElement() {
        return Element.LUFT;
    }
    
    /**
     * Gibt den Bonus des Dämonenjägers zurück.
     */
    @Override
    public double bonus() {
        return 3.0;
    }
    
    /**
     * Gibt die Rasse der Einheit und ihre aktuellen Lebenspunkte zurück.
     */
    @Override
    public String toString(){
        return "Dies ist ein Dämonenjäger. Er ist Anführer der Nachtelfen. "
                + "Er hat noch " +this.lebenspunkte +" Lebenspunkte.";
    }
}
