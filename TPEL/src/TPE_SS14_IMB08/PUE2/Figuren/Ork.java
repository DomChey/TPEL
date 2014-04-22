package TPE_SS14_IMB08.PUE2.Figuren;

import TPE_SS14_IMB08.PUE2.Rasse;


public class Ork extends Wesen {
    private int lebenspunkte = 100;
    private static final int SCHADEN = 33;
    private static final int GESCHWINDIGKEIT = 1;
    private static final int RUESTUNG = 30;
    private static final double SPEZIALATTRIBUT = 4.0;
    public static final Rasse RASSE = Rasse.Ork;
    public static final int KOSTEN = 150;


    @Override
    public int attack(Kaempfer r) {
        // TODO Auto-generated method stub
        return 0;
    }

}
