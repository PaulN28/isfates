/**
 * Eine Reservierung hat einen Terminbeginn, einen Terminende.
 *
 * @author Paul Nicolas und Nils Gamlin
 * @date 13/04/2019
 */

package src.ub14;

public class Reservierung {

    //----------------Attribute---------------- 

    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Raum raum;
    private Mitarbeiter mitarbeiter;

    //----------------Konstruktor---------------- 
    /**
     * Konstrukor der Klasse Reservierung.
     *
     * @param beginn (Uhrzeit) der Terminbeginn der Reservierung.
     * @param ende (Uhrzeit) das Terminende der Reservierung.
     */  

    public Reservierung (Uhrzeit beginn, Uhrzeit ende) {
        setBeginn(beginn);
        setEnde(ende);
    }

    //----------------Beginn---------------- 

    public void setBeginn(Uhrzeit beginn) {
        this.beginn = beginn;
    }

    public Uhrzeit getBegin() {
        return beginn;
    }

    //----------------Ende---------------- 

    public void setEnde(Uhrzeit ende) {
        this.ende = ende;
    }

    public Uhrzeit getEnde() {
        return ende;
    }

    //----------------Bemerkung---------------- 

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    //----------------Raum---------------- 
    public void setRaum(Raum raum) {
        this.raum = raum;
    }

    //----------------Mitarbeiter---------------- 

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    /**
     * Gibt die Informationen zur Reservierung als String zurueck.
     *
     * @return String 
     */	

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gebucht von " + mitarbeiter);
        sb.append(" von " + beginn + " bis " + ende);
        sb.append(" fuer " + bemerkung + "\n");
        return sb.toString();
    }

    public static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }

}