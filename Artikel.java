/**
* Ein Artikel hat eine Nummer, eine Bezeichnung und einen bestimmten Bestand
* Es gibt Methoden um den Bestand zu verändern (vermindern und addieren)
*
* @Paul Nicolas & Nils Gamlin
* @date 01/12/2018
*/
public class Artikel
{
  private static final int MIN_ARTIKEL_NR = 1000;
  private static final int MAX_ARTIKEL_NR = 9999;
  private static final int MIN_ARTIKEL_BESTAND = 0;
  private static final double MIN_ARTIKEL_PREIS = 0.0;
  private int artikelnummer;
  private String artikelbezeichnung;
  private int artikelbestand;
  private double artikelpreis;


  /**
   * Konstruktor für Objekte der Klasse Artikel mit 4 Argumenten
   * @param artikelnummer muss 4-stellig sein;
   * @param artikelbezeichnung darf nicht leer sein;
   * @param artikelbestand darf nie kleiner als 0 sein.
   * @param artikelpreis muss groesser als 0 sein.
   * @return Eine Klassen-Objekt Artikel
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
  */
 public Artikel(int artikelnummer, String artikelbezeichnung)
  {
      this(artikelnummer,artikelbezeichnung, MIN_ARTIKEL_BESTAND, MIN_ARTIKEL_PREIS); //
  }

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
   * @param  prozentsatz : um den Preis zu aendern
   * Die setArtikelpreis Methode wird aufgerufen, um den Artikelpreis zu überprüfen und ändert die Variable artikelpreis
   */
  public void aenderePreis(double prozentsatz) { // prozentsatz kann positiv sowie negativ sein
    setArtikelpreis(artikelpreis + artikelpreis * prozentsatz / 100.0); // Die setMethode ueberprueft, dass der Preis groeßer als null ist
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
   * Bereitet Artikel-Objekt als Zeichenkette auf
   */
  public String toString()
  {
      return "Artikel : " + artikelnummer +
      " Bezeichnung : " + artikelbezeichnung +
      " Bestand : " + artikelbestand +
      " Preis : " + artikelpreis;

  }

  public int getArtikelnummer()
  {
      return artikelnummer;
  }

  public String getArtikelbezeichnung()
  {
      return artikelbezeichnung;
  }

  public int getArtikelbestand()
  {
      return artikelbestand;
  }

  public double getArtikelpreis()
  {
      return artikelpreis;
  }

  public void setArtikelbezeichnung(String artikelbezeichnung)
  {
    check( artikelbezeichnung != null,
          "Artikelbezeichnung darf nicht leer sein");
    this.artikelbezeichnung = artikelbezeichnung;
  }

  public void setArtikelbestand(int artikelbestand)
  {
    check( artikelbestand >= MIN_ARTIKEL_BESTAND,
          "Artikelbestand darf nie kleiner als 0 werden");
    this.artikelbestand = artikelbestand;
  }

  public void setArtikelpreis(double artikelpreis)
  {
    check( artikelpreis > MIN_ARTIKEL_PREIS,
          "Artikelpreis darf nie kleiner/gleich 0 sein");
    this.artikelpreis = artikelpreis;
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
