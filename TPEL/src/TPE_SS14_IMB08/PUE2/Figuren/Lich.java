package TPE_SS14_IMB08.PUE2.Figuren;
import TPE_SS14_IMB08.PUE2.*;

public class Lich extends Untoter implements Anfuehrer{

    public void verwesung(Squad s) {
        //...
    }

    @Override
    public double berechneDamage() {
        return super.berechneDamage() * bonus();
    }
    
    @Override
    public Element beherrscheElement() {
        return Element.WASSER;
    }

    @Override
    public double bonus() {
        return 2.3;
    }
}
