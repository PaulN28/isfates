
/**
 * Décrivez votre classe Recursive ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.io.*;

public class PalindromeRecursive
{
  public static boolean isPalindromeRecursive (String test) {

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


  public void start (String dateiName)
  throws IOException
  {

    File datei = new File(dateiName);
    BufferedReader reader = new BufferedReader (new FileReader(datei));
    String aktuelleZeile;

    while ((aktuelleZeile = reader.readLine()) != null){

      System.out.println(isPalindromeRecursive(aktuelleZeile));
    }
    reader.close();
  }

  public static void main(String[] args) {
      for (int i = 0; i < args.length; i++)
    {
      String dateiName = new String(args[i]);
      System.out.println ( "\n\t Datei : " + dateiName);
        try {
            if (args.length > 0) {
                PalindromeRecursive palindromerecursive = new PalindromeRecursive();
                palindromerecursive.start(dateiName);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
}
