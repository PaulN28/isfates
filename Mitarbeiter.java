package src.ub14;

public class Mitarbeiter extends Person{

//Attribute

    private String email;



//Konstrukor

    public Mitarbeiter (String vorname, String name, String email) {
        super(vorname, name);
        setEmail(email);
    }



//email peut etre ajouter oblig� d'avoir un @

    public void setEmail(String email) {
        check( email != null,
        "email darf nicht leer sein");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung)  {
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        reservierung.setMitarbeiter(this);
        reservierung.setRaum(raum);
}


    public String toString() {
        return String.format("%s (%s)", super.toString(), email);
    }


}
