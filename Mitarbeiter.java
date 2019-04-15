
package src.ub14;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Ein Mitarbeiter hat ein Name und ein Vorname den er von der Klasse Person erbt. Ausserdem hat ein Mitarbeiter eine Email Adresse.
 * Die Methoden in dieser Klasse dienen dazu die Attribute aufzurufen.
 *
 * @author Paul Nicolas und Nils Gamlin
 * @date 13/04/2019
 */

public class Mitarbeiter extends Person{
    //----------------Attribute----------------

    private String email;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    //----------------Konstruktor----------------

    /**
     * Konstrukor der Klasse Mitarbeiter.
     *
     * @param vorname (String) des Mitarbeiters.
     * @param name (String) des Mitarbeiters.
     * @param email (String) Email Adresse des Mitarbeiters.
     */   

    public Mitarbeiter (String vorname, String name, String email) {
        super(vorname, name);
        setEmail(email);
    }

    public void setEmail(String email) {
        check( validate(email) == true, "email ist nicht richtig");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    
    /**
     * Checkt ob die Email Adresse korrekt ist.
     * 
     * @param email (String) zu testen.
     */
    
    public static boolean validate(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
}

    /**
     * Reservierung eines Raumes.
     *
     * @param raum (Raum) Raum der reserviert werden soll.
     * @param beginn (Uhrzeit) Beginn der effektiven Reservierung.
     * @param ende (Uhrzeit) Ende der effektiven Reservierung.
     * @param bemerkung (String) Veranstaltung fuer welche der Raum reserviert wurde.
     */ 

    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung)  {
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        reservierung.setMitarbeiter(this);
        reservierung.setRaum(raum);
        raum.addReservierung(reservierung);
    }

    /**
     * Gibt die Informationen zur Reservierung eines Mitarbeiters, als String zurueck.
     *
     * @return String 
     */  

    public String toString() {
        return String.format("%s (%s)", super.toString(), email);
    }

}
