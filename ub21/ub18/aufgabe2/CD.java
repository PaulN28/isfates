package aufgabe2;

/** Klasse CD (Unterklasse von Artikel)
*
* @author NICOLAS
* @version 2019
*/

public class CD extends Artikel {

  //------------------Attribute----------------------------------

  private  String  interpret;
  private  String  titel;
  private  int     anzahlMusikTitel;

  //------------------Konstruktoren-------------------------------

  /**
  * @param artikelnummer muss 4-stellig sein;
  * @param artikelbezeichnung darf nicht leer sein;
  * @param artikelbestand darf nie kleiner als 0 sein.
  * @param artikelpreis muss groesser als 0 sein.
  * @param interpret der CD darf nicht leer sein.
  * @param titel der CD darf nicht leer sein.
  * @param anzahlMusikTitel der CD muss groesser als 0.
  * @return Ein Klassen-Objekt CD
  */

  public CD ( int artikelnummer, String artikelbezeichnung,
  int artikelbestand, double artikelpreis,
  String interpret, String titel, int anzahlMusikTitel) {
    super(artikelnummer, artikelbezeichnung, artikelbestand, artikelpreis);
    setInterpret(interpret);
    setTitel(titel);
    setAnzahlMusikTitel(anzahlMusikTitel);
  }


  //------------------Interpret-------------------------------


  public void setInterpret(String interpret) {
    check(interpret != null,
    "Interpret darf nicht leer sein");
    this.interpret = interpret;
  }

  public String getInterpret()
  {
    return interpret;
  }

  //------------------Titel-------------------------------


  public void setTitel(String titel) {
    check(titel != null,
    "Titel darf nicht leer sein");
    this.titel = titel;
  }

  public String getTitel()
  {
    return titel;
  }

  //------------------AnzahlMusikTitel-------------------------------


  public void setAnzahlMusikTitel(int anzahlMusikTitel) {
    check(anzahlMusikTitel > 0,
    "AnzahlMusikTitel darf nie kleiner/gleich 0 sein");
    this.anzahlMusikTitel = anzahlMusikTitel;
  }

  public int getAnzahlMusikTitel()
  {
    return anzahlMusikTitel;
  }

  //------------------Andere Methoden-------------------------------

  /**
  * @return gibt den Interpret und den Titel zurueck
  */
  public String getBeschreibung() {
    return String.format("%s: %s", interpret, titel);
  }

  /**
  * Bereitet das CD-Objekt als Zeichenkette auf
  */
  public String toString() {

    return String.format("%s %s %s %3d ", super.toString(), interpret, titel, anzahlMusikTitel);

  }
}
