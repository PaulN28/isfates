/** Klasse Buch (Unterklasse von Artikel)
*
* @author NICOLAS
* @version 2019
*/

public class Buch extends Artikel {

  //------------------Attribute----------------------------------

  private  String  titel ;
  private  String  autor;
  private  String  verlag;

  //------------------Konstruktoren-------------------------------

  /**
  * @param artikelnummer muss 4-stellig sein;
  * @param artikelbezeichnung darf nicht leer sein;
  * @param artikelbestand darf nie kleiner als 0 sein.
  * @param artikelpreis muss groesser als 0 sein.
  * @param titel des Buches darf nicht leer sein.
  * @param autor des Buches darf nicht leer sein.
  * @param verlag des Buches darf nicht leer sein.
  * @return Ein Klassen-Objekt Buch
  */
  public Buch ( int artikelnummer, String artikelbezeichnung,
  int artikelbestand, double artikelpreis,
  String titel, String autor, String  verlag) {
    super(artikelnummer, artikelbezeichnung, artikelbestand, artikelpreis);
    setTitel(titel);
    setAutor(autor);
    setVerlag(verlag);
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

  //------------------Autor-------------------------------


  public void setAutor(String autor) {
    check(autor != null,
    "Autor darf nicht leer sein");
    this.autor = autor;
  }

  public String setAutor()
  {
    return autor;
  }

  //------------------Verlag-------------------------------


  public void setVerlag(String verlag) {
    check(verlag != null,
    "Verlag darf nicht leer sein");
    this.verlag = verlag;
  }

  public String setVerlag()
  {
    return verlag;
  }

  //------------------Andere Methoden-------------------------------

  /**
  * @return gibt den Autor und den Titel zurueck
  */
  public String getBeschreibung() {
    return String.format("%s: %s", autor, titel);
  }

  /**
  * Bereitet das Buch-Objekt als Zeichenkette auf
  */
  public String toString() {

    return String.format("%s %s %s %s", super.toString(), titel, autor, verlag);

  }
}
