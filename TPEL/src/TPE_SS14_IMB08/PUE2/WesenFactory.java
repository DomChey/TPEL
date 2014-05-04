package TPE_SS14_IMB08.PUE2;
import TPE_SS14_IMB08.PUE2.Figuren.*;

/**
 * Erstellt die Armeen der Squads
 */

public class WesenFactory {
    /**
     * Erstellt ein Array aus Wesen der übergebenen Rasse. Sollte das 
     * investierte Kapital nicht ausreichen, wird ein leeres Array zurück 
     * gegeben.
     * 
     * @param kapital Kapital, das investiert werden soll
     * @param rasse gewünschte Rasse der Wesen im Array
     * @return Array entsprechend den Vorgaben
     */
    public static Wesen[] erzeuge(int kapital, Rasse rasse) {
        int anzahl = (kapital/rasse.kosten) - 1; // -1 da Anführer das Doppelte  
        if (anzahl > 0){                            //kostet
            Wesen[] squad = new Wesen[anzahl];
            switch (rasse){
                case ORK:
                    squad[0] = new Farseer();
                    for (int i = 1; i < squad.length; i++){
                        squad[i] = new Ork();
                    }
                    break;
                case UNTOTER:
                    squad[0] = new Lich();
                    for (int i = 1; i < squad.length; i++){
                        squad[i] = new Untoter();
                    }
                    break;
                case MENSCH:
                    squad[0] = new Erzmagier();
                    for (int i = 1; i < squad.length; i++){
                        squad[i] = new Mensch();
                    }
                    break;
                case NACHTELF:
                    squad[0] = new Daemonenjaeger();
                    for (int i = 1; i < squad.length; i++){
                        squad[i] = new Nachtelf();
                    }
                    break;
            }
            return squad;
        }else{
            return new Wesen[0];
        }
       
    }
    /**
     * Erstellt ein Array aus Wesen der übergebenen Rassen. Dabei wird das 
     * Kapital hälftig auf die Rassen verteilt. Sollte das investierte Kapital 
     * nicht ausreichen, wird ein leeres Array zurück gegeben.
     * 
     * @param kapital Kapital, das investiert werden soll
     * @param rasse1   gewünschte Rasse des einen Teils des Arrays
     * @param rasse2    gewünschte Rasse das anderen Teils des Arrays
     * @return  Array entsprechend den Vorgaben.
     */
    public static Wesen[] erzeuge(int kapital, Rasse rasse1, Rasse rasse2) {
        if (rasse1 == rasse2){
            return WesenFactory.erzeuge(kapital, rasse1); 
        } else{
            Wesen[] teil1 = WesenFactory.erzeuge(kapital/2, rasse1);
            Wesen[] teil2 = WesenFactory.erzeuge(kapital/2, rasse2);
            Wesen[] squad = new Wesen[teil1.length + teil2.length];
            System.arraycopy(teil1, 0, squad, 0, teil1.length);
            System.arraycopy(teil2, 0, squad, teil1.length, teil2.length);
            return squad;
        }
     
    }
}
