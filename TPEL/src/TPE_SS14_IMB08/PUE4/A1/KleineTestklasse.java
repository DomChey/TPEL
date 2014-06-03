package TPE_SS14_IMB08.PUE4.A1;

public class KleineTestklasse {

    public static void main(String[] args) {

        Film[] sammlung = {new Film("Batman Begins", 134, FSK.ab12),
                new Film("Pulp Fiction", 148, FSK.ab16),
                new Film("From Dusk till Dawn", 87, FSK.ab16),
                new Film("Machete", 100, FSK.ab18)
        };
        
        Saal gelb = new Saal("gelber Saal", 234);
        Kino odeo = new Kino("Odeon Theater", "Entenhausen", gelb);
        
        gelb.addFilm(sammlung[0], "10:57");
        gelb.addFilm(sammlung[2], "11:01");
        
        Saal rot = new Saal("roter Saal", 10);
        odeo.addSaal(rot);
        odeo.addSaal(rot);
        
        rot.addFilm(sammlung[3], "17:00");
        
        System.out.println(odeo);
        
        
//        for(Object o: odeo) {
//            System.out.println(o);
//        }
        
    }

}
