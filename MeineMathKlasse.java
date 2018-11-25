import java.util.ArrayList;



/**
* MeineMathKlasse enthÃ¤lt ein paar mathematische Methoden
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
  * Das SchlÃ¼sselwort static dient dazu die Methode auÃŸerhalb der Klasse MeineMathKlasse aufzurufen
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
  * Das SchlÃ¼sselwort static dient dazu die Methode auÃŸerhalb der Klasse MeineMathKlasse aufzurufen
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
  * Die Methode quadratischeGleichung lÃ¶st eine Gleichung des zweiten Grades
  * Es gibt drei verschiedene FÃ¤lle, die vom Vorzeichen der Diskriminante abhÃ¤nging sind
  * Das SchlÃ¼sselwort static dient dazu die Methode auÃŸerhalb der Klasse MeineMathKlasse aufzurufen
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
   * Prüft ob die Bedingung erfÃ¼llt wurde, wirft andersfalls eine Exception aus
   */
  public static void check(boolean bedingung, String msg)
  {
    if (!bedingung)
    throw new IllegalArgumentException(msg);
  }
  
  public void loeseKubikSumme(int MAX){
        /*ArrayList<int[]> result = new ArrayList<int[]>();
        
        for(int c = 1; c <= MAX - 1; c++){
            for(int b = 1; (b * b * b) < (c * c); b++){ //da aÂ³ + bÂ³ = cÂ², kÃ¶nnen aÂ³ und bÂ³ nie grÃ¶ÃŸer sein als cÂ²
                for(int a = 1; (a * a * a) < (c * c) || a < b; a++){
                    double sum = (Math.pow(a, 3) + Math.pow(b, 3)); //sum muss ein double sein, da die Methode pow() einen double returned
                    if(sum == Math.pow(c, 2)){
                        System.out.println(a);
                        System.out.println(b);
                        System.out.println(c);
                        System.out.println(" ");
                        
                        int[] array = {a, b, c};
                        result.add(array);
                        
                    }
                }
            }
        }
        //toString(result.toArray());7
        result.toString();*/
        
        
        ArrayList<int[]> result = new ArrayList<int[]>();
        for (int c = 1; c <= MAX; c++){
            for (int b = 1; b <= myIntSqrt(c); b++){
                double a = Math.cbrt((c * c) - (b * b * b));
                if ((c * c) == (a * a * a) + (b * b * b) && a == (int) a && a > 0){
                    int[] values = {(int)a, b, c};
                    result.add(values);
                }
            }
        }
        for(int[] el: result){
            System.out.println(el);
        }
}
    
    public int myIntSqrt(int a){
        Double b = (Math.pow(a, 0.5));
        Integer c = b.intValue();
        return c; 
    }
    
    public double function(int n, double x){ //Probleme bei großen n Zahlen, "overflow error
        check(n >= 0, "Geben Sie eine Natürliche Zahl an, bei 'n'.");
        double sum = 0;
        for (int i = 1; i <= n; i++){
            sum += Math.pow((x - 1), i) / (i * Math.pow(x, i));
        }
        System.out.println(sum);
        return sum;
    }
}
