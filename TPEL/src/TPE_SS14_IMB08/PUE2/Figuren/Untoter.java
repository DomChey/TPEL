package TPE_SS14_IMB08.PUE2.Figuren;

import TPE_SS14_IMB08.PUE2.Rasse;
/**
 * Untoter ist eine der Rassen des Spiels und somit eine Subklasse zu Wesen.
 * 
 * @author IMB08
 *
 */
public class Untoter extends Wesen {
    
    protected int lebenspunkte = 120;
    private static final int SCHADEN = 16;
    private static final int GESCHWINDIGKEIT = 2;
    private static final int RUESTUNG = 30;
    private static final double SPEZIALATTRIBUT = 1.6;
    public static final Rasse RASSE = Rasse.UNTOTER;
    
    /**
     * Errechnet die Schadenshöhe der Einheit.
     * 
     * @return Schadenshöhe
     */
    @Override
    public double berechneDamage(){
        return GESCHWINDIGKEIT * SCHADEN * SPEZIALATTRIBUT;
    }
    
    /**
     * Gibt an, ob die Einheit noch lebt.
     * 
     * @return true, wenn sie noch lebt, ansonsten false.
     */
    @Override
    public boolean isLebendig() {
        return (lebenspunkte > 0);
    }
    
    /**
     * Errechnet aus der übergebenen Schadenshöhe und der Rüstung der Einheit
     * den tatsächlich erhaltenen Schaden.
     * 
     * @param damage Schadenshöhe
     * @return tatsächlich verursachter Schaden
     */
    @Override
    protected int werdeVerletzt(double damage){
        int schaden = (int)beschraenkeSchaden(damage);
        int schutz = schaden*this.RUESTUNG/100;
        schaden = schaden - schutz;
        this.reduziereLebenspunkte(schaden);
        return schaden;
    }
    
    /**
     * Reduziert die Lebenspunkte der Einheit um den übergeben Schaden.
     * 
     * @param damage Schaden, der der Einheit verursacht wird.
     */
    @Override
    protected void reduziereLebenspunkte(int damage){
        this.lebenspunkte = this.lebenspunkte - damage;
    }
    
    /**
     * Ermöglicht es der Einheit eine beliebige andere Einheit anzugreifen.
     * 
     * @param k Einheit, die angegriffen wird.
     * @return verursachter Schaden
     */
    @Override
    public int attack(Kaempfer k) {
        Wesen w = (Wesen)k;
        double damage = this.berechneDamage();
        damage = w.werdeVerletzt(damage);
        return (int)damage;
    }
    
    /**
     * Gibt die Rasse der Einheit und ihre aktuellen Lebenspunkte zurück.
     */
    @Override
    public String toString(){
        return "Untoter(" +this.lebenspunkte +"LP)";
    }



}
