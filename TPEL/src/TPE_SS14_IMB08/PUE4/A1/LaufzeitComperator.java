package TPE_SS14_IMB08.PUE4.A1;

import java.util.Comparator;

public class LaufzeitComperator implements Comparator<Film>{

    @Override
    public int compare(Film f1, Film f2) {
        int tmp = 0;
        if (f1.getLaufzeit() < f2.getLaufzeit()) {
            tmp = -1;
        }
        if (f1.getLaufzeit() > f2.getLaufzeit()) {
            tmp = 1;
        }
            
        return tmp;
    }
    
}
