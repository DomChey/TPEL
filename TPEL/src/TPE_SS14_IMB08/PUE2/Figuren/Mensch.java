package TPE_SS14_IMB08.PUE2.Figuren;

import TPE_SS14_IMB08.PUE2.Rasse;

/**
 * Mensch ist eine der Rassen des Spiels und somit eine Subklasse zu Wesen.
 * 
 * @author IMB08
 *
 */
public class Mensch extends Wesen{
    
    protected int lebenspunkte = 140;
    private static final int SCHADEN = 40;
    private static final int GESCHWINDIGKEIT = 2;
    private static final int RUESTUNG = 40;
    private static final double SPEZIALATTRIBUT = 10.0;
    public static final Rasse RASSE = Rasse.MENSCH;
    
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
     * Errechnet die Schadenshöhe der Einheit.
     * 
     * @return Schadenshöhe
     */
    @Override
    public double berechneDamage(){
        return GESCHWINDIGKEIT * SCHADEN * SPEZIALATTRIBUT;
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
     * Fähigkeit der Einheit, den Schaden zu reduzieren. Wird nur vom Mensch 
     * behrrscht.
     * 
     * @param damage übergebener Schaden
     * @return entsprechend der Rasse der Einheit reduzierter Schaden
     */
    @Override
    public double beschraenkeSchaden(double damage) {
        double beschraenke = (damage*SPEZIALATTRIBUT)/100;
        double newDamage = damage - beschraenke;
        return newDamage;
        
    }
    
    /**
     * Gibt die Rasse der Einheit und ihre aktuellen Lebenspunkte zurück.
     */
    @Override
    public String toString(){
        return "Mensch(" +this.lebenspunkte +"LP)";
    }
    
}
