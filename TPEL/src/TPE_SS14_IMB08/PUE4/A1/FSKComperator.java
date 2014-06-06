package TPE_SS14_IMB08.PUE4.A1;

import java.util.Comparator;

public class FSKComperator implements Comparator<Film> {

    @Override
    public int compare(Film f1, Film f2) {
        return f1.getAltersfreigabe().compareTo(f2.getAltersfreigabe());
    }

}
