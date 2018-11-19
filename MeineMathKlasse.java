/**
* MeineMathKlasse enthält ein paar mathematische Methoden
*
* @author Paul NICOLAS und Nils GAMLIN
* @version 14/11/18
*
*/
public class MeineMathKlasse
{

  private static final int EINGABE_ISBN_LENGTH = 9;

  /**
  * Die Methode teilersumme alle Teiler einer bestimmten Zahl, und gibt die Summe aus
  * Das Schlüsselwort static dient dazu die Methode außerhalb der Klasse MeineMathKlasse aufzurufen
  */

  public static String teilersumme(int zahl) {
    int teilersumme = 0;
    for (int i = 1; i <= zahl; i++) {
      if (zahl % i == 0)
      {
        teilersumme += i;
      }
    }
    return "Die Teilersumme von " + zahl + " ist " + teilersumme;
  }

  /**
  * Die Methode isbnPrüfziffer errechnet dank der 9 ersten Zahlen eine Prüfziffer
  * Wenn die Prüfziffer gleich 10 ist, wird "X" ausgegeben
  * Das Schlüsselwort static dient dazu die Methode außerhalb der Klasse MeineMathKlasse aufzurufen
  */

  public static String isbnPrüfziffer (long isbn) {
    check(String.valueOf(isbn).length() == EINGABE_ISBN_LENGTH, "Eingabe muss 9-stellig sein");
    int summe = 0;
    int prüfziffer;
    for (int i = 9; i >= 1; i--)
    {
      summe += isbn % 10 * i;
      isbn /= 10;
    }
    prüfziffer = summe % 11;
    if (prüfziffer == 10)
    {
      return "X";
    }
    return String.valueOf(prüfziffer); // gibt die String Value eines Int aus
  }

  /**
  * Die Methode quadratischeGleichung löst eine Gleichung des zweiten Grades
  * Es gibt drei verschiedene Fälle, die vom Vorzeichen der Diskriminante abhänging sind
  * Das Schlüsselwort static dient dazu die Methode außerhalb der Klasse MeineMathKlasse aufzurufen
  */

  public static String quadratischeGleichung (double p, double q) {
    double diskriminante;
    diskriminante = Math.pow(p / 2, 2) - q;
    System.out.println("Die Diskriminante ist gleich " + diskriminante);
    if (diskriminante >  0)
    {
      double x1, x2;
      x1 = -(p / 2) + Math.sqrt(diskriminante);
      x2 = -(p / 2) - Math.sqrt(diskriminante);
      return "Die Ergebnisse sind x1 :" +  x1 + " x2 :" + x2;
    }
    else if (diskriminante == 0)
    {
      double x;
      x = -(p / 2) + Math.sqrt(diskriminante);
      return "Das Ergebnis ist " + x;
    }
    else {
      return "Die Diskriminante ist kleiner als 0. Deswegen gibt es keine reelle Nullstellen, sondern zwei komplexe Nullstellen";
    }
  }

  /**
   * Prüft ob die Bedingung erfüllt wurde, wirft andersfalls eine Exception aus
   */
  public static void check(boolean bedingung, String msg)
  {
    if (!bedingung)
    throw new IllegalArgumentException(msg);
  }
}
