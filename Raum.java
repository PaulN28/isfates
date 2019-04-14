import java.util.ArrayList;

public class Raum {
    private int gebaeude;
    private int etage;
    private int raum;
    private static int istReserviert = 0;
    public static ArrayList<String> reservierungen = new ArrayList<String>();

    public Raum(int gebaeude, int etage, int raum) {
        this.gebaeude = gebaeude;
        this.etage = etage;
        this.raum = raum;
    }

    public String toString() {
        if(getIstReserviert() == 1) {
            System.out.println(String.format("\nRaum %d-%d.%d", gebaeude, etage, raum));
            String nachricht = String.format("gebucht von %s %s (%s) von %s bis %s fuer %s. \n",
                    Person.getVorname(),
                    Person.getName(),
                    Mitarbeiter.getEmail(),
                    Ueb14Dialog.getBegin(),
                    Ueb14Dialog.getEnde(), 
                    Mitarbeiter.getBeschreibung());
            
            reservierungen.add(nachricht);
            return nachricht;
                
        }
        return String.format("Raum %d-%d.%d", gebaeude, etage, raum);
    }

    public static int getIstReserviert() {
        return istReserviert;
    }

    public static void setIstReserviert(int wert) {
        istReserviert = wert;
    }
}
