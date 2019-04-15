package src.ub14;

public class Reservierung {

// Attribute

    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Raum raum;
    private Mitarbeiter mitarbeiter;


// Konstruktor

    public Reservierung (Uhrzeit beginn, Uhrzeit ende) {
        setBeginn(beginn);
        setEnde(ende);
    }

//beginn

    public void setBeginn(Uhrzeit beginn) {
        this.beginn = beginn;
    }
    public Uhrzeit getBegin() {
        return beginn;
    }

    //ende

    public void setEnde(Uhrzeit ende) {
        this.ende = ende;
    }

    public Uhrzeit getEnde() {
        return ende;
    }

    //bemerkung

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getBemerkung() {
        return bemerkung;
    }


    //raum

    public void setRaum(Raum raum) {
        this.raum = raum;
    }

        //mitarbeiter

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }



    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gebucht von " + mitarbeiter);
        sb.append(" von " + beginn + " bis " + ende);
        sb.append(" fuer " + bemerkung);
        return sb.toString();
}

    public static void check(boolean bedingung, String msg) {
        if (!bedingung)
        throw new IllegalArgumentException(msg);
      }


}
