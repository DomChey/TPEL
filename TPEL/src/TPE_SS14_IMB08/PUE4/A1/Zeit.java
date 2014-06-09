package TPE_SS14_IMB08.PUE4.A1;

/**
 * Eine Zeitklasse im Format hh:mm. Die Zeit kann im Bereich von O:OO bis 23:59
 * entprechend der ueblichen Stunden- und Minutenwerte beliebig gewaehlt
 * werden.
 * 
 * @author IMB08
 *
 */
public class Zeit implements Comparable<Zeit> {
    private int stunden;
    private int minuten;
    private final static int MAX_STD = 23;
    private final static int MIN_STD = 0;
    private final static int MAX_MIN = 59;
    private final static int MIN_MIN = 0;
    
    
    /**
     * Erstellt eine neue Zeit aus den einzeln uebergebenen Werten für Stunden
     * und Minuten
     * 
     * @param stunden Wert der Stunden als int
     * 
     * @param minuten Wert der Minuten als int
     * 
     * @throws IllegalArgumentException Sollten die angegebenen Werte fuer 
     *      Stunden und Minuten nicht den gaengigen Stunden- und Minutenwerten
     *      entsprechen, wird eine IllegalArgument Exception geworfen.
     */
    public Zeit (int stunden, int minuten) throws IllegalArgumentException {
        if ((stunden < MIN_STD || stunden > MAX_STD)
                ||( minuten < MIN_MIN) || minuten > MAX_MIN ) {
           throw new IllegalArgumentException("Falsche Werte für Studen/Minuten");
        }
        this.stunden = stunden;
        this.minuten = minuten;
    }
    
    /**
     * Erstellt eine neue Zeit aus einem String.
     * 
     * @param zeitString Zeit als String uebergeben im Format hh:mm.
     * 
     * @throws IllegalArgumentException Sollten die angegebenen Werte fuer 
     *      Stunden und Minuten nicht den gaengigen Stunden- und Minutenwerten
     *      entsprechen, wird eine IllegalArgument Exception geworfen.
     */
    public Zeit(String zeitString) throws IllegalArgumentException {
        int index = zeitString.indexOf(":");
        String std = zeitString.substring(0, index);
        String min = zeitString.substring((index+1),zeitString.length());
        int stunden = ((int) Double.parseDouble(std));
        int minuten = ((int) Double.parseDouble(min));
        if ((stunden < MIN_STD || stunden > MAX_STD)
                ||( minuten < MIN_MIN) || minuten > MAX_MIN ) {
           throw new IllegalArgumentException("Falsche Werte fuer Studen/Minuten");
        }
        this.stunden = stunden;
        this.minuten = minuten;
    }
    
   /**
    * Addiert gegebene Minuten auf eine Zeit auf und gibt das Ergebnis als neue
    * Zeit zurueck
    * 
    * @param minuten Aufzuaddierende Minuten
    * 
    * @return Neue Zeit, die eine Summe aus der alten und den gegebenen Minuten 
    *       ist
    */
    public Zeit addTime(int minuten) {
        int addStunden = minuten/60;
        int addMinuten = minuten%60;
        int newStunden = this.stunden + addStunden;
        int newMinuten = this.minuten + addMinuten;
        if(newMinuten > 59) {
            newMinuten = newMinuten - 60;
            newStunden = newStunden + 1;
        }
        if(newStunden > 23) {
            newStunden = newStunden - 24;
        }
        return new Zeit(newStunden, newMinuten);
        
    }
    
    /**
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String a = "";
        String b = "";
        if (stunden<10) {
            a = "0";
        }
        if (minuten<10) {
            b = "0";
        }
        return "" + a + this.stunden + ":" + b + this.minuten;
    }
    
    /**
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        Zeit z = (Zeit) o;
        if(this.toString().equals(z.toString())) {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.stunden*this.minuten;
    }
    
    /**
     * Vergleicht zwei Zeiten miteinander
     * 
     * @param z Zu vergleichende Zeit
     * 
     * @return  0, wenn Zeiten gleich
     *          -1, wenn zu vergleichende Zeit größer
     *          1, wenn zu vergleichende Zeit kleiner
     */
    @Override public int compareTo(Zeit z){
        if(this.stunden < z.stunden){
            return -1;
        } else if(this.stunden > z.stunden){
            return 1;
        } else if (this.minuten < z.minuten){ //Stunden gleich, Minuten kleiner
            return -1;
        } else if (this.minuten > z.minuten){ //Stunden gleich, Minuten groeßer
            return 1;
        } else {  //Stunden und Minuten gleich
            return 0;
        }
    }
}
