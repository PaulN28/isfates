import java.io.*;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private String name; // Name des Lagers
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
        anzArtikel = -1;
    }

    public Lager ()
    {
        this(STANDARD_NAME, STANDARD_DIMENSION);
    }

    //------------------Name----------------------------------
    /*public static void main(String[] args){
    Artikel trikot = new Artikel(8521, "trikot", 12, 89);
    Artikel ball = new Artikel(7896, "ball", 56, 15);
    Lager lager = new Lager();
    lager.legeArtikelAn(trikot);
    lager.legeArtikelAn(ball);
    lager.applyToArticles(artikel -> artikel.setArtikelpreis(artikel.getArtikelpreis() + (artikel.getArtikelpreis() * 0.1)));
    System.out.println(trikot.toString());
    System.out.println(ball.toString());
    }*/

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
     * Artikelnummer bereits vergeben wurde und ob das
     * Lager bereits voll ist.
     *
     * @param  artikel  ein Objekt der Klasse Artikel
     */
    public void legeArtikelAn(Artikel artikel) {
        check(findeArtikel(artikel.getArtikelnummer()) < 0, "Artikel bereits vorhanden!");
        check(anzArtikel < getMaxAnzArtikel(), "Das Lager ist schon voll");
        lager.put(++anzArtikel, artikel);
    }

    //------------------Zugang/Abgang von Artikeln----------------------------------

    /**
     * Artikel loeschen, wenn die Artikelnummer nicht existiert wird eine Fehlermeldung geworfen
     *
     * @param  artikelnummer zu uebergebende Artikelnummer
     *
     */
    public void loescheArtikel(int artikelnummer) {
        int i = findeArtikel(artikelnummer);
        check(i >= 0, "Artikel nicht vorhanden!");
        if (i >= 0) {
            lager.put(i, lager.get(anzArtikel - 1));
            lager.put(anzArtikel-1, null);
            anzArtikel--;
        }
    }

    /**
     * Zugang von Artikeln
     *
     * @param  artikelnummer   zu uebergebende Artikelnummer
     * @param  bestand einzuzahlender Bestand (> 0)
     */
    public void zugang(int artikelnummer, int bestand) {
        int i = findeArtikel(artikelnummer);
        check(i >= 0, "Artikel nicht vorhanden!");
        lager.get(i).zugang(bestand);
    }

    //------------------Preis aendern----------------------------------

    /**
     * Abgang von Artikeln
     *
     * @param  artikelnummer   zu uebergebende Artikelnummer
     * @param  bestand   abuzahlende Menge (> 0)
     */
    public void abgang(int artikelnummer, int bestand) {
        int i = findeArtikel(artikelnummer);
        check(i >= 0, "Artikel nicht vorhanden!");
        lager.get(i).abgang(bestand);
    }

    /**
     * Preis von Artikel(n) aendern
     *
     * @param  artikelnummer   zu uebergebende Artikelnummer
     * @param  prozentsatz    abuzahlende Menge (> 0)
     */
    public void aenderePreis(int artikelnummer, double prozentsatz) {
        int i = findeArtikel(artikelnummer);
        check(i >= 0, "Artikel nicht vorhanden!");
        lager.get(i).aenderePreis(prozentsatz);
    }

    public void aenderePreisFuerAlleArtikel(double prozentsatz) {
        for (int i = 0; i <= anzArtikel - 1; i++) {
            lager.get(i).aenderePreis(prozentsatz);
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

        formatter.format("Lagerort : %s ", name +
            "\n\nArtNr \t Beschreibung \t\t\t Preis \t Bestand \t\t Gesamt\n");

        for (int i=0; i <= anzArtikel-1; i++) {
            gesamtPreis = lager.get(i).getArtikelpreis() * lager.get(i).getArtikelbestand();
            gesamtWert += gesamtPreis;

            formatter.format("%4d \t %s \t\t\t %.2f \t %d \t\t %.2f\n",
                lager.get(i).getArtikelnummer(),
                lager.get(i).getBeschreibung(),
                lager.get(i).getArtikelpreis(),
                lager.get(i).getArtikelbestand(),
                gesamtPreis);
        }
        formatter.format("\nGesamtwert: \t\t%.2f", gesamtWert);
        return bestandsListe.toString();
    }

    /**
     * Interne Methode findeArtikel zur Vereinfachung anderer
     * Methoden
     *
     * @param  artikelnummer   zu uebergebende Artikelnummer
     * @return  Index des gesuchten Artikels oder -1
     *
     */
    private int findeArtikel(int artikelnummer) {
        for (int i = 0; i < anzArtikel; i++) {
            if (lager.get(i).getArtikelnummer() == artikelnummer)
                return i;
        }
        return -1;
    }

    public int getAnzArtikel() {
        return anzArtikel;
    }

    //------------------Sortierte Liste-------------------------------

    public int getMaxAnzArtikel() {
        return lager.size();
    }

    /**
     * Gibt Artikel als sortierte Liste zurueck. Benutzt die sort() Methode um of die Liste zu iterieren.
     * Die Methode ist so implementiert,dass das Sortierkriterium als Parameter an die Methode uebergeben wird.
     *
     * @param BiPredicate<Artikel, Artikel> Sortierkriterium
     * @return Artikel[] sortierte Liste
     */

    public LinkedHashMap<Integer, Artikel> getSorted(BiPredicate<Artikel, Artikel> sortierKriterium){
        LinkedHashMap<Integer, Artikel> clonedLager = new LinkedHashMap<Integer, Artikel>(lager);
        clonedLager.putAll(lager);
        sort(sortierKriterium, clonedLager);
        return clonedLager;
    }

    /**
     * Iteriert ueber ein gegebenes Array, und sortiert diesen mithilfe des Sortierkriteriums
     *
     * @param BiPredicate<Artikel, Artikel> Sortierkriterium
     * @param LinkedHashMap<Integer, Artikel> Array
     */

    private void sort(BiPredicate<Artikel, Artikel> sortKriterium, LinkedHashMap<Integer, Artikel> artikelArray) {
        for (int i = 0; i < artikelArray.size(); i++) {
            for (int j = 1; j < artikelArray.size() - i; j++) {
                if (sortKriterium.test(artikelArray.get(j - 1), artikelArray.get(j))) {
                    Artikel temp = artikelArray.get(i);
                    artikelArray.put(i, artikelArray.get(j));
                    artikelArray.put(j, temp);
                }
            }
        }
    }

  
    /**
     * Gibt die Artikel des Lagers zurueck welche ein bestimmtes Filterkriterium erfuellen.
     *
     * @param Predicate<Artikel> Filterkriterium
     * @return ArrayList<Artikel> Arrayliste mit den gefilterten Artikel
     */
    private ArrayList<Artikel> filter(Predicate<Artikel> filterFunction){
        ArrayList<Artikel> filteredArray = new ArrayList<Artikel>();
        for(int i = 0; i < anzArtikel; i++){
            if (filterFunction.test(lager.get(i)) == true){
                filteredArray.add(lager.get(i));
            }
        }
        return filteredArray;
    }

    /*public static void main(String[] args){
    Artikel stuhl = new Artikel(4521, "Stuhl", 8, 9.99 );
    Artikel ball = new Artikel(8512, "ball", 9, 10);
    Artikel trikot = new Artikel(8521, "trikot", 12, 89);
    Lager lager = new Lager();
    lager.legeArtikelAn(stuhl);
    lager.legeArtikelAn(ball);
    lager.legeArtikelAn(trikot);
    System.out.println(lager.filter((Artikel x) -> x.getArtikelbestand() > 8 ));
    }*/

    /**
     * Wendet die uebergegebene Operation auf alle Artikel des Lagers.
     *
     * @param Consumer<Artikel> Operation die durchgefuehrt werden soll
     */

    private void applyToArticles(Consumer<Artikel> operation){
        for(int i = 0; i < anzArtikel; i++){
            operation.accept(lager.get(i));
        }
        System.out.println("A");
    }

    /**
     * Wendet die uebergegebene Operation auf alle Artikel des Lagers die dem Filterkriterium entsprechen aus.
     *
     * @param Consumer<Artikel> Operation die durchgefuehrt werden soll
     * @param Predicate<Artikel> Filterkriterium 
     */

    public void applyToSomeArticles(Consumer<Artikel> operation, Predicate<Artikel> filterFunction) {
        for (int i = 0; i < anzArtikel; i++) {
            if (filterFunction.test(lager.get(i)) == true){
                operation.accept(lager.get(i));
                System.out.println(lager.get(i));
            }
        }

    }

    /*public static void main(String[] args){
    Artikel trikot = new Artikel(8521, "trikot", 12, 89);
    Artikel ball = new Artikel(7896, "ball", 56, 15);
    Artikel schienbeinschoner = new Artikel(4523, "schienbeinschoner", 85, 30.0);
    Lager lager = new Lager();
    lager.legeArtikelAn(trikot);
    lager.legeArtikelAn(ball);
    lager.legeArtikelAn(schienbeinschoner);
    lager.applyToSomeArticles((Artikel y) -> y.setArtikelbezeichnung(y.getArtikelbezeichnung() + " Sonderangebot"), (Artikel x) -> x.getArtikelbestand() > 48 );
    System.out.println(trikot.toString());
    System.out.println(ball.toString());
    System.out.println(schienbeinschoner.toString()) ;
    }*/

    /**
     * Gibt eine sortierte Liste der Artikel zurueck, welche ein bestimmtes Suchkriterium erfuellen.
     *
     * @param BiPredicate<Artikel, Artikel> Sortierkriterium
     * @param Predicate<Artikel> Filterkriterium 
     *
     * @return Artikel[] gefiltertes und sortiertes Array
     */

    private LinkedHashMap<Integer, Artikel> getArticles(BiPredicate<Artikel, Artikel> sortKriterium, Predicate<Artikel> filterKriterium){
        ArrayList<Artikel> list = new ArrayList<Artikel>(filter(filterKriterium));
        LinkedHashMap<Integer, Artikel> array = new LinkedHashMap<Integer, Artikel>();
        sort(sortKriterium, array);
        return array;
    }

    /**
     * Nimmt eine beliebige Menge an Filterkriterien als Parameter entgegen 
     * und gibt die Artikel des Lagers zurueck die alle Filterkriterien erfuellen
     *
     * @param Predicate<Artikel>... beliebig viele Sortierkriterien.
     *
     * @return Artikel[] gefiltertes und sortiertes Array
     */

    public void filterAll(Predicate<Artikel>... filterCriterias){
        LinkedHashMap<Integer, Artikel> filteredArray = new LinkedHashMap<Integer, Artikel>(lager);
        for(int i =0; i <filterCriterias.length; i++){
            for(int n =0; n < anzArtikel; n++){
                if(filterCriterias[i].test(lager.get(n)) == false){
                    filteredArray.remove(lager.get(n));
                }
            }
        }
        //filteredArray.removeAll(Collections.singleton(null));
        System.out.println(filteredArray);
    }

    /*public static void main(String[] args){
    Artikel trikot = new Artikel(8521, "trikot", 12, 89);
    Artikel ball = new Artikel(7896, "ball", 56, 15);
    Artikel schienbeinschoner = new Artikel(4523, "schienbeinschoner", 85, 30.0);
    Lager lager = new Lager();
    lager.legeArtikelAn(trikot);
    lager.legeArtikelAn(ball);
    lager.legeArtikelAn(schienbeinschoner);
    lager.filterAll((Artikel x) -> x.getArtikelnummer() < 8000, (Artikel y) -> y.getArtikelbestand() < 60);
    }*/

    //------------------Andere Methoden-------------------------------
    /**
     * Lager-Objekt als Zeichenkette aufbereiten;
     * verwendet implizit die toString-Methode von Artikel
     *
     * @return  Zeichenkette
     *
     */
    public String toString(){
        String s = "\nLager: " + name + '\n';
        for (int i = 0; i < anzArtikel; i++) {
            s += i + ": " + lager.get(i) + '\n';
        }
        return s;
    }

    private static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
