/**
 * Eine Uhrzeit besteht aus Minuten und Stunden.
 * Die Methoden in dieser Klasse dienen dazu die Attribute aufzurufen.
 *
 * @author Paul Nicolas und Nils Gamlin
 * @date 13/04/2019
 */

package src.ub14;

public class Uhrzeit {

    //----------------Attribute----------------  

    private int stunde;
    private int minute;

    //----------------Konstruktor----------------  

    /**
     * Konstrukor der Klasse Uhrzeit.
     *
     * @param Stunden (int) die Stunden.
     * @param Minuten (int) die Minuten.
     */  

    public Uhrzeit(int stunde, int minute) {
        setStunde(stunde);
        setMinute(minute);
    }

    //----------------Stunde----------------  

    public void setStunde(int stunde) { 
        check( stunde >= 0 && stunde <= 24, 
            "Stunde darf zwischen 8 und 20 sein");
        this.stunde = stunde;
    }

    public int getStunde() {
        return stunde;
    }

    //----------------Minute----------------  

    public void setMinute(int minute) { 
        check( minute >= 0 && minute < 60, 
            "Gebaude darf groesser als 0 sein");
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    /**
     * Gibt die Informationen zur Uhrzeit als String zurueck.
     *
     * @return String 
     */	

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