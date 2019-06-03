 

public class Mitarbeiter extends Person{
    
    private static String email;
    private static Uhrzeit begin;
    private static Uhrzeit ende;

    public Mitarbeiter(String vorname, String name, String email){
        super(vorname, name);
        this.email = email;
    }
    
    public String toString() {
        return String.format("%s %s (%s)", super.getVorname(), super.getName(), email);
    }
    
    public void reserviere(Raum raum, Uhrzeit begin, Uhrzeit ende, String beschreibung) {
        this.begin = begin;
        this.ende = ende;
        Raum.setIstReserviert(1);
        System.out.println(Raum.getIstReserviert());
        System.out.println(raum.toString());
    }
    
    //------------------------ getters + setters ------------------------
    
    public static Uhrzeit getBegin() {
        return begin;
    }
    
    public static void setBegin(Uhrzeit begin) {
        Mitarbeiter.begin = begin;
    }

    public static Uhrzeit getEnde() {
        return ende;
    }

    public static void setEnde(Uhrzeit ende) {
        Mitarbeiter.ende = ende;
    }
    
    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
