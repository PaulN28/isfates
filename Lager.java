import java.io.*;
import java.util.*;

/**
* Eine Klasse Lager die es ermoeglicht verschiedene Artikel zu bearbeiten
*
* @Paul Nicolas & Nils Gamlin
* @date 01/12/2018
*/

public class Lager {

  //------------------Attribute----------------------------------

  private String name; // Name des Lagers
  private Artikel [] lager;
  private int anzArtikel;

  private static final String STANDARD_NAME = "Hauptlager";
  private static final int STANDARD_DIMENSION = 10;

  //------------------Konstruktoren----------------------------------

  /**
  * Konstruktor fuer Objekte der Klasse Lager
  *
  * @param name Name des Lagers
  * @param maxAnzartikelen  maximale Anzahl an anzulegenden Artikeln
  */

  public Lager(String name, int maxAnzArtikel) {
    check(maxAnzArtikel > 0, "Die Zahl der Artikel muss > 0 sein!");
    setName(name);
    lager = new Artikel[maxAnzArtikel];
    anzArtikel = 0;
  }

  public Lager ()
  {
    this(STANDARD_NAME, STANDARD_DIMENSION);
  }

  //------------------Name----------------------------------

  public void setName(String name) {
    check(name != null, "Name darf nicht leer sein");
    this.name = name;
  }

  public String getName(){
    return name;
  }

  //------------------Artikel anlegen/loeschen----------------------------------

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
    lager[anzArtikel] = artikel;
    anzArtikel++;
  }


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
      lager[i] = lager[anzArtikel-1];
      lager[anzArtikel-1] = null;
      anzArtikel--;
    }
  }

  //------------------Zugang/Abgang von Artikeln----------------------------------
  /**
  * Zugang von Artikeln
  *
  * @param  artikelnummer   zu uebergebende Artikelnummer
  * @param  bestand einzuzahlender Bestand (> 0)
  */
  public void zugang(int artikelnummer, int bestand) {
    int i = findeArtikel(artikelnummer);
    check(i >= 0, "Artikel nicht vorhanden!");
    lager[i].zugang(bestand);
  }

  /**
  * Abgang von Artikeln
  *
  * @param  artikelnummer   zu uebergebende Artikelnummer
  * @param  bestand   abuzahlende Menge (> 0)
  */
  public void abgang(int artikelnummer, int bestand) {
    int i = findeArtikel(artikelnummer);
    check(i >= 0, "Artikel nicht vorhanden!");
    lager[i].abgang(bestand);
  }

  //------------------Preis aendern----------------------------------

  /**
  * Preis von Artikel(n) aendern
  *
  * @param  artikelnummer   zu uebergebende Artikelnummer
  * @param  prozentsatz    abuzahlende Menge (> 0)
  */
  public void aenderePreis(int artikelnummer, double prozentsatz) {
    int i = findeArtikel(artikelnummer);
    check(i >= 0, "Artikel nicht vorhanden!");
    lager[i].aenderePreis(prozentsatz);
  }

  public void aenderePreisFuerAlleArtikel(double prozentsatz) {
    for (int i = 0; i <= anzArtikel - 1; i++) {
      lager[i].aenderePreis(prozentsatz);
    }
  }

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
      gesamtPreis = lager[i].getArtikelpreis() * lager[i].getArtikelbestand();
      gesamtWert += gesamtPreis;

      formatter.format("%4d \t %s \t\t\t %.2f \t %d \t\t %.2f\n",
                          lager[i].getArtikelnummer(),
                          lager[i].getBeschreibung(),
                          lager[i].getArtikelpreis(),
                          lager[i].getArtikelbestand(),
                          gesamtPreis);
    }
    formatter.format("\nGesamtwert: \t\t%.2f", gesamtWert);
    return bestandsListe.toString();
  }

  //------------------Interne Methode----------------------------------

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
      if (lager[i].getArtikelnummer() == artikelnummer)
      return i;
    }
    return -1;
  }

  public int getAnzArtikel() {
    return anzArtikel;
  }

  public int getMaxAnzArtikel() {
    return lager.length;
  }

  //------------------Andere Methoden-------------------------------

  /**
  * Lager-Objekt als Zeichenkette aufbereiten;
  * verwendet implizit die toString-Methode von Artikel
  *
  * @return  Zeichenkette
  *
  */
  public String toString() {
    String s = "\nLager: " + name + '\n';
    for (int i = 0; i < anzArtikel; i++) {
      s += i + ": " + lager[i] + '\n';
    }
    return s;
  }


  private static void check(boolean bedingung, String msg) {
    if (!bedingung)
    throw new IllegalArgumentException(msg);
  }
}
