 /**
 * Klasse die die Iterative Loesung der isPalindrome Methode.
 *
 * @author Paul Nicolas, Nils Gamlin
 * @version 20.04.2019
 */

import java.io.*;

public class PalindromeIterative
{
 
  private File datei;
  private BufferedReader reader;
 
 /**
 * Bestimmt ob ein Wort, ein Palindrome ist. Benutzt eine Iterative Implementierung.
 *
 * @param String Wort das getestet wird.
 * @return boolean Gibt zurück ob ein Wort ein Palindrome ist (true) oder nicht (false).
 */
 
  public static boolean isPalindromeIterative (String test) {

    int testLength = test.length();

    for (int i = 0; i < (testLength / 2) + 1; i++){

      if (testLength < 2) {
        return true;
      }

      if (test.charAt(i) != test.charAt(testLength - i  - 1)){
        return false;
      }
  }
  return true;
}

 /**
 * Ermoeglicht es die Woerter einer Datei, Zeile per Zeile, auf ihre Palindromitaet zu ueberpruefen.
 *
 * @param String Dateiname.
 */

  public void start (String dateiName)
  throws IOException
  {

    File datei = new File(dateiName);

    if (!datei.exists() || !datei.canRead())
    throw new IOException("Datei nicht lesbar");

    reader = new BufferedReader (new FileReader(datei));
    String aktuelleZeile;

    while ((aktuelleZeile = reader.readLine()) != null){

      System.out.println(isPalindromeIterative(aktuelleZeile));
    }
    reader.close();
  }

  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++)
    {
      String dateiName = new String(args[i]);
      System.out.println ( "\nDatei : " + dateiName);
      try {
        if (args.length > 0) {
          PalindromeIterative palindromeiterative = new PalindromeIterative();
          palindromeiterative.start(dateiName);
        }
      } catch (IOException e) {
        System.out.println(e);
      }
    }
  }
}
