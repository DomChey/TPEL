package TPE_SS14_IMB08.PUE2.Figuren;

import TPE_SS14_IMB08.PUE2.*;
/**
 * Abstrakte Superklasse zu den einzelen Rassen des Spiels, die alle 
 * Gemeinsamkeiten der Rassen beinhaltet und das Interface Kaempfer 
 * implementiert.
 * 
 * @author IMB08
 *
 */
public abstract class Wesen implements Kaempfer{
    
    protected int lebenspunkte;
    protected int schaden;
    protected int geschwindigkeit;
    protected int ruestung;
    protected double spezialattribut;
    protected Rasse rasse;
    
    /**
     * Gibt an, ob die Einheit noch lebt.
     * 
     * @return true, wenn sie noch lebt, ansonsten false.
     */
    public abstract boolean isLebendig();
    
    /**
     * Ermöglicht es der Einheit eine beliebige andere Einheit anzugreifen.
     * 
     * @param k Einheit, die angegriffen wird.
     * @return verursachter Schaden
     */
    public abstract int attack(Kaempfer k);
    
    /**
     * Errechnet die Schadenshöhe der Einheit.
     * 
     * @return Schadenshöhe
     */
    public abstract double berechneDamage();
    
    /**
     * Errechnet aus der übergebenen Schadenshöhe und der Rüstung der Einheit
     * den tatsächlich erhaltenen Schaden.
     * 
     * @param damage Schadenshöhe
     * @return tatsächlich verursachter Schaden
     */
    protected abstract int werdeVerletzt(double damage); 
    
    /**
     * Reduziert die Lebenspunkte der Einheit um den übergeben Schaden.
     * 
     * @param damage Schaden, der der Einheit verursacht wird.
     */
    protected abstract void reduziereLebenspunkte(int damage);
    
    /**
     * Fähigkeit der Einheit, den Schaden zu reduzieren. Wird nur vom Mensch 
     * behrrscht.
     * 
     * @param damage übergebener Schaden
     * @return entsprechend der Rasse der Einheit reduzierter Schaden
     */
    public double beschraenkeSchaden(double damage) {
        return damage;
    }

}
