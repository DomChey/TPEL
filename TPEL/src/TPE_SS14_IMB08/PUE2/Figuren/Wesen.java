package TPE_SS14_IMB08.PUE2.Figuren;

import TPE_SS14_IMB08.PUE2.*;

public abstract class Wesen implements Kaempfer{
    protected int lebenspunkte;
    protected int schaden;
    protected int geschwindigkeit;
    protected int ruestung;
    protected double spezialattribut;
    protected Rasse rasse;
    
    public boolean isLebendig() {
        return (lebenspunkte > 0);
    }
    public abstract int attack(Kaempfer r);
    
    public double berechneDamage(){
        double damage = geschwindigkeit * schaden * spezialattribut;
        return beschraenkeSchaden(damage);
    }
    
    public double beschraenkeSchaden(double damage) {
        return damage;
    }

}
