
/** Klasse Video (Unterklasse von Artikel)
*
* @author NICOLAS
* @version 2019
*/


public class Video extends Artikel {

  //------------------Attribute----------------------------------

  private  String  titel;
  private  int  spieldauer;
  private  int  erscheinungsjahr ;

  //------------------Konstruktoren-------------------------------

  /**
  * @param artikelnummer muss 4-stellig sein;
  * @param artikelbezeichnung darf nicht leer sein;
  * @param artikelbestand darf nie kleiner als 0 sein.
  * @param artikelpreis muss groesser als 0 sein.
  * @param titel der Video darf nicht leer sein;
  * @param spieldauer der Video darf nie kleiner/gleich 0 sein.
  * @param erscheinungsjahr der Video zwischen 1950 und 2014.
  * @return Ein Klassen-Objekt Video
  */

  public Video ( int artikelnummer, String artikelbezeichnung,
  int artikelbestand, double artikelpreis,
  String  titel, int  spieldauer, int  erscheinungsjahr) {
    super(artikelnummer, artikelbezeichnung, artikelbestand, artikelpreis);
    setTitel(titel);
    setSpieldauer(spieldauer);
    setErscheinungsjahr(erscheinungsjahr);
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

  //------------------Spieldauer-------------------------------


  public void setSpieldauer(int spieldauer) {
    check(spieldauer > 0,
    "Spieldauer darf nie kleiner/gleich 0 sein");
    this.spieldauer = spieldauer;
  }

  public int getSpieldauer()
  {
    return spieldauer;
  }

  //------------------Erscheinungsjahr-------------------------------


  public void setErscheinungsjahr(int erscheinungsjahr) {
    check(((erscheinungsjahr >= 1950) && (erscheinungsjahr <= 2014)),
    "Erscheinungsjahr darf zwischen 1950 und 2014 sein");
    this.erscheinungsjahr = erscheinungsjahr;
  }

  public int getErscheinungsjahr()
  {
    return erscheinungsjahr;
  }

  //------------------Andere Methoden-------------------------------

  /**
  * @return gibt den Titel zurueck
  */
  public String getBeschreibung() {
    return String.format("%s", titel);
  }

  /**
  * Bereitet das Video-Objekt als Zeichenkette auf
  */
  public String toString() {
    return String.format("%s %s %d %4d", super.toString(), titel, spieldauer, erscheinungsjahr);

  }
}
