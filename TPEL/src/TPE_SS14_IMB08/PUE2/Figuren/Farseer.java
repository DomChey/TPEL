package TPE_SS14_IMB08.PUE2.Figuren;
import TPE_SS14_IMB08.PUE2.*;

public class Farseer extends Ork implements Anfuehrer {
        
    public void doppelschlag(Squad s) {
        //...
    }

    @Override
    public Element beherrscheElement() {
        return Element.ERDE;
    }

    @Override
    public double bonus() {
        return 1.2;
    }
}
