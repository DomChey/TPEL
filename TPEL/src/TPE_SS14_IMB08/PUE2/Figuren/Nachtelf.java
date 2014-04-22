package TPE_SS14_IMB08.PUE2.Figuren;

import TPE_SS14_IMB08.PUE2.Rasse;

/**
 * Nachtelf ist eine der Rassen des Spiels und somit eine Subklasse zu Wesen.
 * 
 * @author IMB08
 *
 */
public class Nachtelf extends Wesen {
    
    protected int lebenspunkte = 120;
    private static final int SCHADEN = 15;
    private static final int GESCHWINDIGKEIT = 3;
    private static final int RUESTUNG = 20;
    private static final double SPEZIALATTRIBUT = 2.9;
    public static final Rasse RASSE = Rasse.NACHTELF;
    
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
        this.lebenspunkte= this.lebenspunkte - schaden;
        return schaden;
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
     * Reduziert die Lebenspunkte der Einheit um den übergeben Schaden.
     * 
     * @param damage Schaden, der der Einheit verursacht wird.
     */
    @Override
    protected void reduziereLebenspunkte(int damage){
        this.lebenspunkte = this.lebenspunkte - damage;
    }
    
    /**
     * Gibt die Rasse der Einheit und ihre aktuellen Lebenspunkte zurück.
     */
    @Override
    public String toString(){
        return "Dies ist ein Nachtelf. "
                + "Er hat noch " +this.lebenspunkte +" Lebenspunkte.";
    }

}
