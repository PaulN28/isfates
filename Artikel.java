package aufgabe2;

/**
* Ein Artikel hat eine Nummer, eine Bezeichnung, einen bestimmten Bestand und einen Preis
* Es gibt Methoden um den Bestand/Preis zu verändern
*
* @author Paul Nicolas & Nils Gamlin
* @date 01/12/2018
*/
public class Artikel
{

  //------------------Attribute----------------------------------

  private static final int MIN_ARTIKEL_NR = 1000;
  private static final int MAX_ARTIKEL_NR = 9999;
  private static final int MIN_ARTIKEL_BESTAND = 0;
  private static final double MIN_ARTIKEL_PREIS = 0.0;
  private int artikelnummer;
  private String artikelbezeichnung;
  private int artikelbestand;
  private double artikelpreis;

  //------------------Konstruktoren-------------------------------

  /**
  * Konstruktor für Objekte der Klasse Artikel mit 4 Argumenten
  * @param artikelnummer muss 4-stellig sein;
  * @param artikelbezeichnung darf nicht leer sein;
  * @param artikelbestand darf nie kleiner als 0 sein.
  * @param artikelpreis muss groesser als 0 sein.
  * @return Ein Klassen-Objekt Artikel
  */
  public Artikel(int artikelnummer, String artikelbezeichnung,int artikelbestand, double artikelpreis)
  {
    check(artikelnummer >= MIN_ARTIKEL_NR && artikelnummer <= MAX_ARTIKEL_NR,
    "Artikelnummer muss 4-stellig sein");
    this.artikelnummer = artikelnummer;
    setArtikelbezeichnung(artikelbezeichnung);
    setArtikelbestand(artikelbestand);
    setArtikelpreis(artikelpreis);

  }

  /**
  * Konstruktor für Objekte der Klasse Artikel mit 2 Argumenten
  * Dieser Konstruktor bezieht sich auf den vorherigen Konstruktor (this Methode)
  * @param artikelnummer muss 4-stellig sein;
  * @param artikelbezeichnung darf nicht leer sein;
  * @return Eine Klassen-Objekt Artikel
  */
  public Artikel(int artikelnummer, String artikelbezeichnung)
  {
    this(artikelnummer,artikelbezeichnung, MIN_ARTIKEL_BESTAND, MIN_ARTIKEL_PREIS);
  }

  //------------------Methoden zugang, abgang, aenderePreis-------------------------------

  /**
  * Fügt Artikel zum Bestand hinzu
  *
  * @param  bestand : Menge von Artikeln (muss größer als 0 sein), die man zum aktuellen Bestand hinzufügen möchte
  * Die setArtikelbestand Methode wird aufgerufen, um den Artikelbestand zu überprüfen und ändert die Variable artikelbestand
  */
  public void zugang(int bestand)
  {
    check( bestand > MIN_ARTIKEL_BESTAND, "Du kannst nicht 0 oder weniger Artikel hinzufügen");
    setArtikelbestand(this.artikelbestand + bestand);
  }

  /**
  * Bucht Artikel vom Bestand ab
  *
  * @param  bestand : Menge von Artikeln (muss größer als 0 sein), die man vom aktuellen Bestand abbuchen möchte
  * Die setArtikelbestand Methode wird aufgerufen, um den Artikelbestand zu überprüfen und ändert die Variable artikelbestand
  */

  public void abgang(int bestand)
  {
    check( bestand > MIN_ARTIKEL_BESTAND, "Du kannst nicht 0 oder weniger Artikel abbuchen");
    setArtikelbestand(this.artikelbestand - bestand);
  }

  /**
  * Methode um den Preis zu aendern
  *
  * @param  prozentsatz : um den Preis zu aendern
  * Die setArtikelpreis Methode wird aufgerufen, um den Artikelpreis zu überprüfen und ändert die Variable artikelpreis
  */
  public void aenderePreis(double prozentsatz) { // prozentsatz kann positiv sowie negativ sein
    setArtikelpreis(artikelpreis + artikelpreis * prozentsatz / 100.0); // Die setMethode ueberprueft, dass der Preis groeßer als null ist
  }

  //------------------Artikelnummer-------------------------------

  public int getArtikelnummer()
  {
    return artikelnummer;
  }

  //------------------Artikelbezeichnung-------------------------------

  public void setArtikelbezeichnung(String artikelbezeichnung)
  {
    check( artikelbezeichnung != null,
    "Artikelbezeichnung darf nicht leer sein");
    this.artikelbezeichnung = artikelbezeichnung;
  }

  public String getArtikelbezeichnung()
  {
    return artikelbezeichnung;
  }

  //------------------Artikelbestand-------------------------------

  public void setArtikelbestand(int artikelbestand)
  {
    check( artikelbestand >= MIN_ARTIKEL_BESTAND,
    "Artikelbestand darf nie kleiner als 0 werden");
    this.artikelbestand = artikelbestand;
  }

  public int getArtikelbestand()
  {
    return artikelbestand;
  }

  //------------------Artikelpreis-------------------------------

  public void setArtikelpreis(double artikelpreis)
  {
    check( artikelpreis >= MIN_ARTIKEL_PREIS,
    "Artikelpreis darf nie kleiner/gleich 0 sein");
    this.artikelpreis = artikelpreis;
  }

  public double getArtikelpreis()
  {
    return artikelpreis;
  }

  //------------------Andere Methoden-------------------------------

  public String getBeschreibung() {
    return String.format("%s", artikelbezeichnung);
  }

  /**
  * Bereitet das Artikel-Objekt als Zeichenkette auf
  */
  public String toString()
  {
    return String.format("| %4d; %s; %d; %.2f |",
    artikelnummer, artikelbezeichnung
    , artikelbestand, artikelpreis);
  }

  /**
  * Prueft ob die Bedingung (zB, dass die Artikelnummer 4-stellig sein muss,...) erfuellt wurde, wenn nicht, wirft eine IllegalArgumentException und bricht das Programm ab
  */
  public static void check(boolean bedingung, String msg)
  {
    if (!bedingung)
    throw new IllegalArgumentException(msg);
  }
}
