package version_finale;

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
  * Die Methode teilersumme alle Teiler einer bestimmten Zahl, und gibt die Summe aus.
  * Das Schlüsselwort static dient dazu die Methode außerhalb der Klasse MeineMathKlasse aufzurufen.
  * @param zahl Benutzer definierte Variable an der die Teilersumme ausgeführt wird. Die Zahl muss positiv und gerade sein.
  */

  public static String teilersumme(int zahl) {
    check(zahl > 0, "Zahl muss positiv sein");
    int teilersumme = 1 + zahl;
    for (int i = 2; i <= zahl / 2; i++) {
      if (zahl % i == 0)
      {
        teilersumme += i;
      }
    }
    return "Die Teilersumme von " + zahl + " ist " + teilersumme;
  }

  /**
  * Die Methode isbnPrüfziffer errechnet dank der 9 ersten Zahlen eine Prüfziffer.
  * Wenn die Prüfziffer gleich 10 ist, wird "X" ausgegeben.
  * Das Schlüsselwort static dient dazu die Methode außerhalb der Klasse MeineMathKlasse aufzurufen.
  * @param isbn Benutzer definierte Variable, die die 9 ersten Zahlen eines ISBN Codes darstellen.
  */

  public static String isbnPruefziffer (long isbn) {
    check(String.valueOf(isbn).length() == EINGABE_ISBN_LENGTH, "Eingabe muss 9-stellig sein");
    int summe = 0;
    int pruefziffer;
    for (int i = 9; i >= 1; i--)
    {
      summe += isbn % 10 * i;
      isbn /= 10;
    }
    pruefziffer = summe % 11;
    if (pruefziffer == 10)
    {
      return "X";
    }
    return String.valueOf(pruefziffer); // gibt die String Value eines Int aus
  }

  /**
  * Die Methode quadratischeGleichung löst eine Gleichung des zweiten Grades.
  * Es gibt drei verschiedene Fälle, die vom Vorzeichen der Diskriminante abhänging sind.
  * Das Schlüsselwort static dient dazu die Methode außerhalb der Klasse MeineMathKlasse aufzurufen.
  * @param p stellt bei einer gLichung der Form: x² + px + q = 0, 'p' dar.
  * @param q stellt bei einer gLichung der Form: x² + px + q = 0, 'q' dar.
  */

  public static String quadratischeGleichung (double p, double q) {
    double diskriminante;
    diskriminante = ((p / 2.0) * (p / 2.0)) - q;
    System.out.println("Die Diskriminante ist gleich " + diskriminante);
    if (diskriminante >  0)
    {
      double x1, x2;
      x1 = -(p / 2.0) + Math.sqrt(diskriminante);
      x2 = -(p / 2.0) - Math.sqrt(diskriminante);
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
  * Iteriert Ã¼ber a, b und c um die Gleichung a³ + b³ = c² zu lösen.
  * @param limit Iterations Grenze.
  * @return Gibt die Zahlentriplets, die die Gleichung lösen, als Zeichenkette zurück.
  */
  public static String a3b3c2(int limit) {
    int limit2 = limit * limit;
    String result = "";
    check(limit > 0, "Grenze muss eine positive Zahl sein");
    for (int a = 1; 2*a*a*a < limit2 ; a ++) {   // 2 a^3 muss KLEINER als limit^2 sein, da c < limit ist
      for (int b = a; b*b*b < limit2; b ++) {    // b^3 muss KLEINER als limit^2 sein, da c < limit ist
        for (int c = 1; c < limit; c ++) {
          if (a*a*a + b*b*b == c*c) {
            result += "\n" + ("a : " + a + " b : " + b + " c : " + c) + "\n";
          }
        }
      }
    }
    return result;
  }

  /**
   * Errechnet den Wert der Summe von ((x - 1) ^n) / (n * (x ^n)).
   * @param n Grad des letzten Term.
   * @param x Benutzer definierte Variable.
   * @return Gibt den Wert der Summe der Terms.
   */

  public static double folge (long n, double x) {
    check(n > 0, "Geben Sie eine Naturliche Zahl an, bei 'n'");
    check(x != 0, "x kann nicht null sein");
    double wert = (x - 1) / x;
    double faktor = (x - 1) / x;
    double aktueller_n_wert = (x - 1) / x;
    for (long i = 2; i <= n; i++)  {
      aktueller_n_wert = aktueller_n_wert * faktor; // Rechnet den n+1-ten Term dank des n-ten Terms
      wert += aktueller_n_wert / i;
    }
    return wert;
  }

  /**
  * Prüft ob die Bedingung erfüllt wurde, wirft andersfalls eine Exception aus.
  */
  public static void check(boolean bedingung, String msg)
  {
    if (!bedingung)
    throw new IllegalArgumentException(msg);
  }
}
