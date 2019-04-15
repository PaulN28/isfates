
package src.ub14;
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
        check( email != null,
            "email darf nicht leer sein");
        this.email = email;
    }

    public String getEmail() {
        return email;
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
