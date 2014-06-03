package TPE_SS14_IMB08.PUE4.A1;

public class Zeit {
    private int stunden;
    private int minuten;
    
    public Zeit (int stunden, int minuten) {
        if (stunden < 0) {
            stunden = 0;
        }
        if (stunden > 23) {
            stunden = 23;
        }
        if (minuten < 0) {
            minuten = 0;
        }
        if (minuten > 59) {
            minuten = 59;
        }
        
        this.stunden = stunden;
        this.minuten = minuten;
    }

    public Zeit(String zeitString) {
        this.stunden = (int)Double.parseDouble((String)zeitString.substring(0, 2));
        this.minuten = (int)Double.parseDouble((String)zeitString.substring(3, 5));        
    }
    
    
    public void addTime(int minuten) {
        int addStunden = minuten/60;
        int addMinuten = minuten%60;
        this.stunden = this.stunden + addStunden;
        this.minuten = this.minuten + addMinuten;
        if(this.minuten > 59) {
            this.minuten = this.minuten - 60;
            this.stunden = this.stunden + 1;
        }
        if(this.stunden > 23) {
            this.stunden = this.stunden - 24;
        }
        
    }

    @Override
    public String toString() {
        String a = "";
        String b = "";
        if (stunden<10) {
            a = "0";
        }
        if (minuten<10) {
            b = "0";
        }
        return "" + a + this.stunden + ":" + b + this.minuten;
    }
    
    
    @Override
    public boolean equals(Object o) {
        Zeit z = (Zeit) o;
        if(this.toString().equals(z.toString())) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.stunden*this.minuten;
    }
}
