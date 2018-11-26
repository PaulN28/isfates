import java.util.Scanner;
/**
* Interaktive Testklasse für die MeineMathKlasse
*
* @author Paul NICOLAS und Nils GAMLIN
* @version 14/11/18
*
*/
public class MathDialog
{
  private Scanner input = new Scanner(System.in);

  // Konstanten die benutzt werden um die Funktionen auszuwählen
  private static final int TEILERSUMME = 1;
  private static final int ISBNPRÜFZIFFER = 2;
  private static final int QUADRATISCHE_GLEICHUNG = 3;
  private static final int A3B3C2 = 4;
  private static final int FOLGE = 5;
  private static final int ENDE = 0;

  /**
  * Hauptschleife des Testprogramms
  */

  /**
  * Diese Hauptschleife dient dazu das Programm ohne Aufforderung des Benutzers eine endlos Schleife zu machen
  * Diese Methode wird auch benutzt um die Ausnahmen zu behandeln (zB einen Datentyp bezogenen Fehler)
  */
  public void start() {

      int funktion = -1;
      while (funktion != ENDE) {
      try {
        funktion = einlesenFunktion();
        ausfuehrenFunktion(funktion);
      } catch (AssertionError e) {
        System.out.println(e);
      } catch (java.util.InputMismatchException e) {
        System.out.println(e);
        input.next();
      } catch (Exception e) {
        System.out.println("Irgendeine Ausnahme gefangen: " + e);
        e.printStackTrace(System.out);
      }
    }
  }

  /**
  * Zeigt ein Menu mit den verschiedenen Methoden an, die der Benutzer aufrufen kann
  */

  private int einlesenFunktion() {
    System.out.print(
        TEILERSUMME + ": Teilersumme; " +
        ISBNPRÜFZIFFER + ": ISBN Prüfziffer; " +
        QUADRATISCHE_GLEICHUNG + ": Quadratische Gleichung; " +
        A3B3C2 + ": Zahlentriplet; " +
        FOLGE + ": Folge; " +
        ENDE + ": beenden ");
    return input.nextInt();
  }

  /**
  * Führt die verschiedenen Methoden, die der Benutzer mit dem Menu (einlesenFunktion) aufgerufen hat, aus
  * Die verschiedenen Methoden werden über MeineMathKlasse aufgerufen.
  */

  private void ausfuehrenFunktion(int funktion) {

    switch (funktion)
    {
      case ENDE:
        System.out.println("Programmende");
        break;

      case TEILERSUMME:
        System.out.println("Zahl : ");
        input.nextLine();
        int zahl = input.nextInt();
        System.out.println(MeineMathKlasse.teilersumme(zahl));
        break;

      case ISBNPRÜFZIFFER:
        System.out.println("ISBN : ");
        input.nextLine();
        long isbn = input.nextLong();
        System.out.println(MeineMathKlasse.isbnPruefziffer(isbn));
        break;

      case QUADRATISCHE_GLEICHUNG:
        System.out.println("Eine quadratische Gleichung der Form : x² + px+ q = 0, mit p = ");
        input.nextLine();
        double p = input.nextDouble();
        System.out.println("Und q = ");
        input.nextLine();
        double q = input.nextDouble();
        System.out.println( MeineMathKlasse.quadratischeGleichung(p, q));
        break;

      case A3B3C2:
        System.out.println("Grenze : ");
        input.nextLine();
        int grenze = input.nextInt();
        System.out.println(MeineMathKlasse.a3b3c2(grenze));
        break;
        
      case FOLGE:
        System.out.println("n : ");
        input.nextLine();
        long n = input.nextLong();
        System.out.println("x : ");
        input.nextLine();
        double x = input.nextDouble();
        System.out.println(MeineMathKlasse.folge(n, x));
        break;

      default:
      System.out.println("Bitte wählen Sie eine existierende Methode");
    }
  }

  /**
  * Main-Methode zum Erzeugen des KontoDialog-Objektes und zum Anstarten der
  * Testschleife
  */
  public static void main(String[] args) {
    new MathDialog().start();
  }
}
