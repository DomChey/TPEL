package TPE_SS14_IMB08.PUE1;


public class Darlehen {
    
    private Festkommazahl darlehensSumme;
    private double zinssatz;
    private double tilgungsquote;
    private Festkommazahl restschuld;
    private Festkommazahl jaehrlicheZahlung;
    private Festkommazahl zinsZahlung;
    private Festkommazahl tilgung;
    private int darlehensJahr;
    
    /**
     * Legt ein neues Darlehen an.
     * @param darlehensSumme    Darlehenssumme als <code>double</code>-Wert
     * @param zinssatz          Zinssatz in Prozent als <code>double</code>-Wert
     * @param tilgungsquote     Tilgungsquote in Prozent als 
     *                          <code>double</code>-Wert
     */
    public Darlehen (double darlehensSumme, double zinssatz,
            double tilgungsquote) {
        this.darlehensSumme = new Festkommazahl(darlehensSumme);
        this.zinssatz = zinssatz;
        this.tilgungsquote = tilgungsquote;
        this.restschuld = new Festkommazahl(darlehensSumme);
        this.jaehrlicheZahlung = 
            this.darlehensSumme.prozent(this.zinssatz+this.tilgungsquote);
        this.zinsZahlung = this.restschuld.prozent(this.zinssatz);
        this.tilgung = this.jaehrlicheZahlung.subtrahiere(this.zinsZahlung);
        this.darlehensJahr = 1;
        
    }
    
    private Darlehen (){
    }
    
    private void neuesDarlehensjahr() {
        this.restschuld = this.restschuld.subtrahiere(this.tilgung);
        this.zinsZahlung = this.restschuld.prozent(this.zinssatz);
        this.tilgung = this.jaehrlicheZahlung.subtrahiere(this.zinsZahlung);
        this.darlehensJahr = this.darlehensJahr + 1;
    }
   
    /**
     * Berechnet für das gegebene Darlehen die Entwicklung im Verlauf
     * (mehrerer) Jahre.
     * @param jahre Gewuenschte Anzahl von Jahren als <code>int</code>, 
     *              fuer die die Entwicklung berechnet werden soll. 
     * @return  Gibt die Darlehen als Array zurueck.
     */
    public Darlehen[] jahresDaten(int jahre){
        Darlehen[] darlehensEntwicklung = new Darlehen[jahre];
        darlehensEntwicklung[0] = 
                new Darlehen(this.darlehensSumme.getAsDouble(), 
                        this.zinssatz, this.tilgungsquote);
        for (int i=1; i < jahre; i++){
            Darlehen tmp = darlehensEntwicklung[i-1].deepCopyOf();
            tmp.neuesDarlehensjahr();
            darlehensEntwicklung[i] = tmp;
        }
        return darlehensEntwicklung;
    }
    
   private Darlehen deepCopyOf(){
       Darlehen copy = new Darlehen();
       copy.darlehensSumme = this.darlehensSumme;
       copy.zinssatz = this.zinssatz;
       copy.tilgungsquote = this.tilgungsquote;
       copy.restschuld = this.restschuld;
       copy.jaehrlicheZahlung = this.jaehrlicheZahlung;
       copy.zinsZahlung = this.zinsZahlung;
       copy.tilgung = this.tilgung;
       copy.darlehensJahr = this.darlehensJahr;
       return copy;
   }
   
   /**
    * Erzeugt einen formatierten String aus dem Darlehensjahr, der Zinszahlung
    * der Tilgung und der Restschuld.
    * @return gibt diesen <code>String</code> zurueck.
    */
   public String datenToString() {
       return ""+darlehensJahr+"\t"+zinsZahlung+"\t\t"+tilgung+"\t\t"+
               ""+restschuld;
   }
}
