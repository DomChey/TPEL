package TPE_SS14_IMB08.PUE4.A1;

public enum FSK implements Comparable<FSK>{
    OHNE("ohne Altersbeschraenkung", 0), ab6("ab 6 Jahre", 1), ab12("ab 12 Jahre", 2),
        ab16("ab 16 Jahre", 3), ab18("keine Jugendfreigabe", 4);
    
    private String text;
    private int reihenfolge;
    
    FSK(String text, int reihenNummer) {
        this.text = text;
        this.reihenfolge = reihenNummer;
    }
    
    public String toString() {
        return "[" + text + "]";
    }
    
//    public int compareTo(FSK freigabe) {
//        if(this.reihenfolge == freigabe.reihenfolge) {
//            return 0;
//        }
//        if(this.reihenfolge < freigabe.reihenfolge) {
//            return -1;
//        }
//        return 1;
//    }
}
