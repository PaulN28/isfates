package src.ub14;

public class Uhrzeit {
    
    //Attribute
    
    private int stunde;
    private int minute;
    
    //Konstruktor
    
    public Uhrzeit(int stunde, int minute) {
        setStunde(stunde);
        setMinute(minute);
    }
    
    //Stunde
    
    public void setStunde(int stunde) { 
        check( stunde >= 0 && stunde <= 24, 
        "Stunde darf zwischen 8 und 20 sein");
        this.stunde = stunde;
    }
        
    public int getStunde() {
        return stunde;
    }
    
    //Minute
    
    public void setMinute(int minute) { 
        check( minute >= 0 && minute < 60, 
        "Gebaude darf groesser als 0 sein");
        this.minute = minute;
    }
        
    public int getMinute() {
        return minute;
    }
    
    public String toString() {
        return String.format("%d:%d Uhr",
        stunde, minute);
     }
    
    public static void check(boolean bedingung, String msg) {
        if (!bedingung) {
        throw new IllegalArgumentException(msg);
        }
      }

}
