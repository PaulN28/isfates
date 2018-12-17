import java.io.*;
/**
* Klasse der Link Filter Methode
* Zeigt die URLs verschiedener Webseiten, die sich in verschiedenen HTML Dateien befinden, an
*
* @author NICOLAS Paul & GAMLIN Nils
* @version 14/12/18
*/
public class LinkFilter
{
  // Die verschiedenen REGEX, um die Zeilen zu bearbeiten
  private static final String BEGIN_EXPRESSION = "<a href=";
  private static final String END_EXPRESSION = "</a>";
  private static final String SEPARATOR = ">";
  private static final String FORMAT = "^.*<a href=.*>.*</a>.*$";

  private boolean keineLinks = true;


  /**
  * Die start Methode filtert die URLs die sich in einer gegebenen Datei befinden
  * @param dateiName der Name der Datei
  */

  public void start (String dateiName)
  throws Exception
  {
    File datei = new File(dateiName);
    BufferedReader reader = new BufferedReader (new FileReader(datei));
    String aktuelleZeile;

    while ((aktuelleZeile = reader.readLine()) != null) { //readline() ermoeglicht es jede Zeile zu lesen, und stoppt sobald es keine Zeilen mehr gibt
      if (aktuelleZeile.matches(FORMAT)){ //Ueberprueft ob, die aktuelle Zeile die REGEX enthaelt
        keineLinks = false;
        aktuelleZeile = (((aktuelleZeile.split( END_EXPRESSION ))[0]).split( BEGIN_EXPRESSION ))[1]; // werfe alles hinter END_EXPRESSION und vor BEGIN_EXPRESSION weg
        System.out.println((aktuelleZeile.split( SEPARATOR, 2))[0] + "\t" + (aktuelleZeile.split( SEPARATOR, 2))[1]);
      }
    }
    reader.close();
    if (keineLinks) {
      System.out.println("Keine Links gefunden in der Datei : " + dateiName);
    }
  }

  /**
  * Die main Methode ruft die start Methode so viele Male auf, wie es Argumente gibt
  * @param args die verschiedenen Dateiennamen
  */

  public static void main(String[] args)
  {
    for (int i = 0; i < args.length; i++)
    {
      String dateiName = new String(args[i]);
      System.out.println ( "\n\t Datei : " + dateiName);
      try
      {
        LinkFilter LinkFilter = new LinkFilter();
        LinkFilter.start(dateiName);
      }
      catch (Exception e)
      {
        System.out.println ( "\n\t Datei : " + dateiName + " wurde nicht bearbeitet\n");
      }
    }
  }
}
