package aufgabe2;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Comparator;

/**
 * Eine Klasse Lager die es ermoeglicht verschiedene Artikel zu bearbeiten
 *
 * @author Paul Nicolas & Nils Gamlin
 * @date 01/12/2018
 */

public class Lager {

    //------------------Attribute----------------------------------

    private static final String STANDARD_NAME = "Hauptlager";
    private static final int STANDARD_DIMENSION = 20;
    private String name;
    private LinkedHashMap<Integer, Artikel> lager;
    private int anzArtikel;

    //------------------Konstruktoren----------------------------------

    /**
     * Konstruktor fuer Objekte der Klasse Lager
     *
     * @param name Name des Lagers
     * @param maxAnzArtikel  maximale Anzahl an anzulegenden Artikeln
     */

    public Lager(String name, int maxAnzArtikel) {
        check(maxAnzArtikel > 0, "Die Zahl der Artikel muss > 0 sein!");
        setName(name);
        lager = new LinkedHashMap<>();
        anzArtikel = 0;
    }

    public Lager ()
    {
        this(STANDARD_NAME, STANDARD_DIMENSION);
    }

    //------------------Name----------------------------------

    public String getName(){
        return name;
    }

    //------------------Artikel anlegen/loeschen----------------------------------

    public void setName(String name) {
        check(name != null, "Name darf nicht leer sein");
        this.name = name;
    }

    /**
     * Anlegen eines Artikels. Es ist zu pruefen, ob die
     * Artikelnummer bereits vergeben wurde.
     *
     * @param artikel ein Objekt der Klasse Artikel
     */
    public void legeArtikelAn(Artikel artikel) {
        check(!lager.containsKey(artikel.getArtikelnummer()), "Artikel bereits vorhanden!");
        lager.put(artikel.getArtikelnummer(), artikel);
        anzArtikel++;
    }

    /**
     * Artikel loeschen, wenn die Artikelnummer nicht existiert wird eine Fehlermeldung geworfen
     *
     * @param artikelnummer zu uebergebende Artikelnummer
     *
     */
    public void loescheArtikel(int artikelnummer) {
        check(lager.containsKey(artikelnummer), "Artikel nicht vorhanden!");
        lager.remove(artikelnummer);
        anzArtikel--;
    }

    //------------------Zugang/Abgang von Artikeln----------------------------------

    /**
     * Zugang von Artikeln
     *
     * @param  artikelnummer   zu uebergebende Artikelnummer
     * @param  bestand einzuzahlender Bestand (> 0)
     */
    public void zugang(int artikelnummer, int bestand) {
        check(lager.containsKey(artikelnummer), "Artikel nicht vorhanden!");
        lager.get(artikelnummer).zugang(bestand); //Zugang der Artikel-Klasse
    }

    /**
     * Abgang von Artikeln
     *
     * @param  artikelnummer   zu uebergebende Artikelnummer
     * @param  bestand   abuzahlende Menge (> 0)
     */
    public void abgang(int artikelnummer, int bestand) {
        check(lager.containsKey(artikelnummer), "Artikel nicht vorhanden!");
        lager.get(artikelnummer).abgang(bestand); //Abgang der Artikel-Klasse
    }

    //------------------Preis aendern----------------------------------

    /**
     * Preis von Artikel(n) aendern
     *
     * @param  artikelnummer   zu uebergebende Artikelnummer
     * @param  prozentsatz    kann negativ oder positiv sein
     */
    public void aenderePreis(int artikelnummer, double prozentsatz) {
        check(lager.containsKey(artikelnummer), "Artikel nicht vorhanden!");
        lager.get(artikelnummer).aenderePreis(prozentsatz);
    }

    public void aenderePreisFuerAlleArtikel(double prozentsatz) {
        for (Artikel artikel : lager.values()) {
            artikel.aenderePreis(prozentsatz);
        }
    }

    //------------------Interne Methode----------------------------------

    /**
     * erzeugt einen String, der eine Bestandsliste repraesentiert
     * @return Eine formatierte Bestandsliste
     */

    public String ausgebenBestandsListe() {

        double gesamtPreis, gesamtWert = 0;

        StringBuilder bestandsListe = new StringBuilder();
        Formatter formatter = new Formatter(bestandsListe);

        formatter.format("Lagerort : %s ", getName() +
            "\n\nArtNr \t Beschreibung \t\t\t Preis \t Bestand \t\t Gesamt\n");

        for (Artikel artikel : lager.values()) {
            gesamtPreis = artikel.getArtikelpreis() * artikel.getArtikelbestand();
            gesamtWert += gesamtPreis;

            formatter.format("%4d \t %s \t\t\t %.2f \t %d \t\t %.2f\n",
                artikel.getArtikelnummer(),
                    artikel.getBeschreibung(),
                    artikel.getArtikelpreis(),
                    artikel.getArtikelbestand(),
                gesamtPreis);
        }
        formatter.format("\nGesamtwert: \t\t%.2f", gesamtWert);
        return bestandsListe.toString();
    }

    public int getAnzArtikel() {
        return anzArtikel;
    }

    //------------------Sortierte Liste-------------------------------

    /**
     * Gibt Artikel als sortierte Liste zurueck.
     * @param comp
     * @return List<Artikel>
     */

    public List<Artikel> getSorted(Comparator<Artikel> comp){
        return lager.values().stream().sorted(comp).collect(Collectors.toList());
    }

    /**
     * Gibt die Artikel des Lagers zurueck welche ein bestimmtes Filterkriterium erfuellen.
     *
     * @param filterFunction<Artikel> Filterkriterium
     * @return List<Artikel>
     */
    private List<Artikel> filter(Predicate<Artikel> filterFunction){
        return lager.values().stream().filter(filterFunction).collect(Collectors.toList());
    }

    /**
     * Wendet die uebergegebene Operation auf alle Artikel des Lagers.
     *
     * @param operation Operation die durchgefuehrt werden soll
     */

    private void applyToArticles(Consumer<Artikel> operation){
        lager.values().stream().forEach(operation);
    }

    /**
     * Wendet die uebergegebene Operation auf alle Artikel des Lagers die dem Filterkriterium entsprechen aus.
     *
     * @param operation Operation die durchgefuehrt werden soll
     * @param filterFunction Filterkriterium
     */

    public void applyToSomeArticles(Consumer<Artikel> operation, Predicate<Artikel> filterFunction) {
        lager.values().stream().filter(filterFunction).forEach(operation);

    }

    /**
     * Gibt eine sortierte Liste der Artikel zurueck, welche ein bestimmtes Suchkriterium erfuellen.
     *
     * @param comp
     * @param filterKriterium Filterkriterium
     *
     * @return List gefiltertes und sortiertes Array
     */

    private List getArticles(Comparator<Artikel> comp, Predicate<Artikel> filterKriterium){
        return lager.values().stream().filter(filterKriterium).sorted(comp).collect(Collectors.toList());
    }

    /**
     * Nimmt eine beliebige Menge an Filterkriterien als Parameter entgegen 
     * und gibt die Artikel des Lagers zurueck die alle Filterkriterien erfuellen
     *
     * @param filterCriterias ... beliebig viele Sortierkriterien.
     *
     * @return List gefiltertes und sortiertes Array
     */

    public List<Artikel> filterAll(Predicate<Artikel>... filterCriterias){
        List<Artikel> list = lager.values().stream().collect(Collectors.toList());

        for(Predicate<Artikel> j : filterCriterias) {
            list = list.stream().filter(j).collect(Collectors.toList());
        }
        return list;
    }

    //------------------Andere Methoden-------------------------------
    /**
     * Lager-Objekt als Zeichenkette aufbereiten;
     * verwendet implizit die toString-Methode von Artikel
     *
     * @return  Zeichenkette
     *
     */
    public String toString(){
        String s = "\nLager: " + getName() + '\n' +
        "Anzahl der Artikel " + getAnzArtikel();
        return s;
    }

    private static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
