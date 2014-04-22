package TPE_SS14_IMB08.PUE2.Figuren;
import TPE_SS14_IMB08.PUE2.*;

public class Daemonenjaeger extends Nachtelf implements Anfuehrer{
    
    
    public void goldSchuss(Squad s) {
        
    }

    @Override   //copy&paste!!!!!!!
    public double berechneDamage() {
        return super.berechneDamage() * bonus();
    }
    
    @Override
    public Element beherrscheElement() {
        return Element.LUFT;
    }

    @Override
    public double bonus() {
        return 3.0;
    }
}
