import java.io.*;
/**
* Write a description of class LinkFilter here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class LinkFilter
{
  private static final String BEGIN_EXPRESSION = "<a href=";
  private static final String END_EXPRESSION = "</a>";
  private static final String SEPARATOR = ">";
  private static final String FORMAT = "^.*<a href=.*>.*</a>.*$";
  private boolean keineLinks = true;

  public LinkFilter()
  {
  }


  public void start (String dateiName)
  throws Exception
  {

    File datei = new File(dateiName);

    BufferedReader reader = new BufferedReader (new FileReader(datei));

    String aktuelleZeile;

    while ((aktuelleZeile = reader.readLine()) != null) {
      if (aktuelleZeile.matches(FORMAT)){
        keineLinks = false;
        aktuelleZeile = (((aktuelleZeile.split( END_EXPRESSION ))[0]).split( BEGIN_EXPRESSION ))[1];
        System.out.println((aktuelleZeile.split( SEPARATOR))[0] +
        "\t" +
        (aktuelleZeile.split( SEPARATOR))[1]
        );
      }
    }
    reader.close();
    if (keineLinks) { System.out.println("Keine Links gefunden in der Datei : " + dateiName); }
  }

  public static void main(String[] args)
  {
    for ( int lauf = 0; lauf < args.length; lauf++ )
    {
      String dateiName = new String( args[lauf] );
      System.out.println ( "\n\t Datei : " + dateiName);
      try
      {
        LinkFilter LinkFilter = new LinkFilter();
        LinkFilter.start(dateiName);
      }
      catch ( Exception ex )
      {
        System.out.println ( "\n\t Datei : " + dateiName +
        " wurde nicht bearbeitet\n" +
        "\n\t es trat folgender fehler auf " +
        " ----> \n\n\t" + ex.toString()
        );
      }
    }
  }
}
