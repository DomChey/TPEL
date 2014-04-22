package TPE_SS14_IMB08.PUE2.Figuren;
import TPE_SS14_IMB08.PUE2.*;

public class Erzmagier extends Mensch implements Anfuehrer {

    public void absorption(Squad s) {
        
    }

    @Override   //copy&paste!!!!!!!
    public double berechneDamage() {
        return super.berechneDamage() * bonus();
    }
    

    @Override
    public Element beherrscheElement() {
        return Element.FEUER;
    }


    @Override
    public double bonus() {
        return 5.0;
    }
}
