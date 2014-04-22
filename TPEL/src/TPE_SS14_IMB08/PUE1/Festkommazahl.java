package TPE_SS14_IMB08.PUE1;

/**
 * Klasse fuer finanzmathematische Berechnungen ohne Rundungsfehler
 * 
 * @author IMB08
 * 
 */

public class Festkommazahl {
    private long wert;
    private int genauigkeit;

    /**
     * Erzeugt eine Festkommazahl mit folgenden Parametern:
     * 
     * @param vorkomma  Stellen vor dem Komma
     *            
     * @param nachkomma Nachkommastellen (genau 2, führende Nullen werden 
     *                  erzeugt)
     *            
     * @param genauigkeit   Genauigkeit in Nachkommastellen (min 2, max 6)
     *            
     */
    public Festkommazahl(long vorkomma, long nachkomma, int genauigkeit) {
        long tmp = vorkomma * 100;
        long ntmp = nachkomma;
        while (ntmp > 99) {
            ntmp = ntmp / 10;
        }
        tmp = tmp + ntmp;

        if (genauigkeit > 6) {
            genauigkeit = 6;
        }
        if (genauigkeit < 2) {
            genauigkeit = 2;
        }

        tmp = tmp * (long) Math.pow(10, genauigkeit - 2);

        this.wert = tmp;
        this.genauigkeit = genauigkeit;
    }

    /**
     * Erzeugt neue Festkommazahl mit der Genauigkeit 4 Nachkommastellen
     * 
     * @param vorkomma  Stellen vor dem Komma
     *            
     * @param nachkomma  Nachkommastellen
     *           
     */
    public Festkommazahl(long vorkomma, long nachkomma) {
        this(vorkomma, nachkomma, 4);
    }

    /**
     * Erzeugt neue Festkommazahl mit der Genauigkeit 4 Nachkommastellen
     * 
     * @param zahl  Zahlenwert in <code>double</code>
     *            
     */
    public Festkommazahl(double zahl) {
        this.wert = ((long) (zahl * 100)) * 100;
        this.genauigkeit = 4;
    }

    /**
     * Erzeugt neue Festkommazahl mit der Genauigkeit 4 Nachkommastellen
     * 
     * @param s String in der Form 'vorkomma.nachkomma'
     *            
     */
    public Festkommazahl(String s) {
        this(Double.parseDouble(s));
    }

    Festkommazahl(long wert, int genauigkeit) {
        this.wert = wert;
        this.genauigkeit = genauigkeit;
    }

    /**
     * liefert Minimum der Genauigkeiten, da Genauigkeit nicht vergroessert
     * werden kann
     * 
     * @param a Genauigkeit FKZ 1
     *            
     * @param b Genauigkeit FKZ 2
     *            
     * @return geringere Genauigkeit
     */
    private int genauigkeitsTest(int a, int b) {
        if (a <= b) {
            return a;
        }
        return b;
    }

    /**
     * Kürzt die Genauigkeit der Festkommazahl
     * 
     * @param genau neue Genauigkeit
     *            
     * @return long-Wert mit neuer Genauigkeit
     */
    private long angepasstGenau(int genau) {
        return (this.wert / (long) Math.pow(10, (this.genauigkeit - genau)));
    }

    /**
     * Addiert zwei Festkommazahlen
     * 
     * @param summand2  zu addierende FKZ
     *            
     * @return Ergebnis als neue FKZ
     */
    public Festkommazahl addiere(Festkommazahl summand2) {

        int genau = genauigkeitsTest(this.genauigkeit, summand2.genauigkeit);

        long f1 = this.angepasstGenau(genau);
        long f2 = summand2.angepasstGenau(genau);

        long erg = f1 + f2;

        return new Festkommazahl(erg, genau);
    }

    /**
     * Subtrahiert zwei FKZ voneinander
     * 
     * @param subtrahend    zu subtrahierende FKZ
     *            
     * @return Ergebnis als neue FKZ
     */
    public Festkommazahl subtrahiere(Festkommazahl subtrahend) {
        return this.addiere(new Festkommazahl(subtrahend.wert * (-1),
                subtrahend.genauigkeit));

    }

    /**
     * Multipliziert zwei Festkommazahlen
     * 
     * @param faktor2   Zahl, mit der multipliziert wird
     *            
     * @return Ergebnis als neue FKZ
     */
    public Festkommazahl multipliziere(Festkommazahl faktor2) {

        int genau = genauigkeitsTest(this.genauigkeit, faktor2.genauigkeit);

        long f1 = this.angepasstGenau(genau);
        long f2 = faktor2.angepasstGenau(genau);

        long erg = f1 * f2;
        erg = erg / (long) Math.pow(10, genau);

        return new Festkommazahl(erg, genau);
    }

    /**
     * Multipliziert FKZ mit einer Double-Zahl
     * 
     * @param faktor2   <code>double</code>-Zahl, mit der multipliziert wird
     *            
     * @return Ergebnis als neue FKZ
     */
    public Festkommazahl multipliziere(double faktor2) {
        return this.multipliziere(new Festkommazahl(faktor2));
    }

    private Festkommazahl dividiere(Festkommazahl divisor) {
        if (divisor.wert == 0){
            return new Festkommazahl(this.wert, this.genauigkeit);
        }
        long f1 = this.wert;
        f1 = f1 * (long) Math.pow(10, divisor.genauigkeit);
        f1 = f1 / divisor.wert;
        return new Festkommazahl(f1, this.genauigkeit);
    }

    /**
     * Dividiert eine Festkommazahl durch eine double-Zahl. Falls diese Null
     * ist wird die zu dividierende Zahl zurück gegeben.
     * 
     * @param divisor   Divisor als <code>double</code>
     *            
     * @return Ergebnis als neue FKZ
     */
    public Festkommazahl dividiere(double divisor) {
        return dividiere(new Festkommazahl(divisor));
    }

    /**
     * Berechnet den prozentualen Anteil einer Festkommazahl
     * 
     * @param prozent   zu berechnender Anteil
     *            
     * @return Ergebnis als neue FKZ
     */
    public Festkommazahl prozent(double prozent) {
        Festkommazahl erg = this.multipliziere(prozent);
        erg = erg.dividiere(100.0);
        return erg;
    }

    /**
     * Liefert die Festkommazahl als String mit zwei Nachkommastellen
     * 
     * @return FKZ als String
     */
    public String toString() {
        String erg = getVorkomma() + ",";
        if (this.getNachkomma() < 10L) {
            erg = erg + "0";
        }
        erg = erg + this.getNachkomma();
        return erg;
    }

    /**
     * Liefert die zwei ersten Nachkommastellen
     * 
     * @return Nachkommastellen als <code>long</code>-Wert
     */
    public long getNachkomma() {
        long vorK = this.getVorkomma();
        vorK = vorK * (long) Math.pow(10, this.genauigkeit);
        long erg = this.wert - vorK;
        erg = erg / (long) Math.pow(10, this.genauigkeit - 2);
        return erg;
    }

    /**
     * Liefert die Vorkommastellen
     * 
     * @return Vorkommastellen als <code>long</code>-Wert
     */
    public long getVorkomma() {
        return (this.wert / (long) Math.pow(10, this.genauigkeit));
    }

    /**
     * Konvertiert die FKZ in einen double-Wert mit 2 Nachkommastellen
     * 
     * @return Wert als <code>double</code>-Wert
     */
    public double getAsDouble(){
        double vorK = (double) this.getVorkomma();
        double nachK = ((double) this.getNachkomma())/100; 

        double erg = vorK + nachK;
        //String test = String.valueOf(this.getVorkomma()) + "." + String.valueOf(this.getNachkomma());
        //System.out.println(Double.parseDouble(test));
        return erg;
    }

    /**
     * Vergleicht zwei FKZ auf Gleichheit, wobei sie nur gleich sind, wenn alle
     * Stellen übereinstimmen
     * 
     * @param f2    zu vergleichende Zahl
     *            
     * @return <code>true</code>, wenn gleich.
     */
    public boolean equals(Object o) {
        Festkommazahl f2 = (Festkommazahl) o;
        if (this.genauigkeit == f2.genauigkeit) {
            if (f2.wert == this.wert) {
                return true;
            }
        }
        return false;
    }

}
