import java.util.*;

/**
* Décrivez votre classe LagerDialog ici.
* si on met le meme artikelnr, bestand, ...
*
* @author (votre nom)
* @version (un numéro de version ou une date)
*/
public class LagerDialog
{

  private Lager lager;
  private Scanner input;
  private boolean existiert_lager;

  private static final int NEUES_STANDARD_LAGER      = 1;
  private static final int NEUES_LAGER               = 2;
  private static final int ARTIKEL_ANLEGEN           = 3;
  private static final int ARTIKEL_LOESCHEN          = 4;
  private static final int ZUGANG                    = 5;
  private static final int ABGANG                    = 6;
  private static final int PREIS_AENDERN             = 7;
  private static final int PREIS_AENDERN_FUER_ALLE_ARTIKEL = 8;
  private static final int ENDE                      = 0;

  private static final String MSG_LAGER_EXISTIERT_NICHT = "Lager existiert nicht";
  private static final String MSG_LAGER_EXISTIERT_SCHON = "Lager existiert schon";


  /**
  * Constructeur d'objets de classe LagerDialog
  */

  public LagerDialog()
  {
    input = new Scanner(System.in); // initalise les valeurs de départ
    existiert_lager = false;
  }

  public void start() {
    int funktion = -1;

    while (funktion != ENDE) {
      try {
        funktion = einlesenFunktion();
        ausfuehrenFunktion(funktion);
      } catch (IllegalArgumentException e) {
        System.out.println("Ausnahme gefangen: " + e);
      } catch (InputMismatchException e) {
        System.out.println(e);
        input.next();
      // }  catch (NullPointerException e) {
      //    System.out.println(e);
      //    input.next();
      // } 
      catch (Exception e) {
        System.out.println("Ausnahme gefangen: " + e);
        e.printStackTrace(System.out);
      }
    }
  }


  private int einlesenFunktion() {
    int funktion;
    System.out.print(NEUES_STANDARD_LAGER     + ": Neues Standardlager; " +
    NEUES_LAGER     + ": Neues Lager; " +
    ARTIKEL_ANLEGEN     + ": Artikel anlegen; " +
    ARTIKEL_LOESCHEN   + ": Artikel loeschen; " +
    ZUGANG     + ": Zugang; " +
    ABGANG    + ": Abgang; " +
    PREIS_AENDERN + ": Preis aendern; " +
    PREIS_AENDERN_FUER_ALLE_ARTIKEL + ": Preis aendern fuer alle Artikel; " +
    ENDE        + ": beenden -> ");

    funktion = input.nextInt();
    input.nextLine();
    return funktion;

  }

  private void ausfuehrenFunktion(int funktion) {
    String lagername;
    int lagergroesse;

    int artikelnummer, bestand;
    String artikelbezeichnung;
    double artikelpreis;

    switch (funktion) {

      // variable a false de base puis qd Constructeur est crée mettre à true

      case NEUES_STANDARD_LAGER :
      if (!existiert_lager) {
        lager = new Lager();
        existiert_lager = true;
      }
      else {
        System.out.println(MSG_LAGER_EXISTIERT_SCHON);
      }
      break;


      case NEUES_LAGER:
      if (!existiert_lager) {
        lager = new Lager(einleseLagerName(), einleseLagerGroesse());
        existiert_lager = true;
      }
      else {
        System.out.println(MSG_LAGER_EXISTIERT_SCHON);
      }
      break;


      case ARTIKEL_ANLEGEN:
      if (existiert_lager) {
        lager.legeArtikelAn(einleseArtikelNummer()
        , einleseArtikelBezeichnung()
        , einleseArtikelBestand()
        , einleseArtikelPreis()
        );
      }
      else {
        System.out.println(MSG_LAGER_EXISTIERT_NICHT);
      }
      break;

      case ARTIKEL_LOESCHEN: // Trou a voir
      if (existiert_lager) {
        lager.loescheArtikel(einleseArtikelNummer());
      }
      else {
        System.out.println(MSG_LAGER_EXISTIERT_NICHT);
      }
      break;

      case ZUGANG:
      if (existiert_lager) {
        lager.zugang(einleseArtikelNummer(), bestand());
      }
      else {
        System.out.println(MSG_LAGER_EXISTIERT_NICHT);
      }
      break;

      case ABGANG:
      if (existiert_lager) {
        lager.abgang(einleseArtikelNummer(), bestand());
      }
      else {
        System.out.println(MSG_LAGER_EXISTIERT_NICHT);
      }
      break;

      case PREIS_AENDERN:
      if (existiert_lager) {
        lager.aenderePreis(einleseArtikelNummer(), einleseProzensatz());
      }
      else {
        System.out.println(MSG_LAGER_EXISTIERT_NICHT);
      }
      break;

      case PREIS_AENDERN_FUER_ALLE_ARTIKEL:
      if (existiert_lager) {
        lager.aenderePreisFuerAlleArtikel(einleseProzensatz());
      }
      else {
        System.out.println(MSG_LAGER_EXISTIERT_NICHT);
      }
      break;

      case ENDE:
      System.out.println("Programmende");
      break;

      default:
      System.out.println("Falsche Funktion!");
    }
    System.out.println(lager);
  }


  /**
  * Die checks werden in der Hauptfunktion (zB legeArtikelAn) ausgefuehrt
  *
  */

  private String einleseLagerName() {
    System.out.print("Lagername: ");
    return input.nextLine();
  }

  private int einleseLagerGroesse() {
    System.out.print("Lagergroesse: ");
    return input.nextInt();
  }


  private int einleseArtikelNummer() {
    System.out.print("Artikelnummer: ");
    return input.nextInt();
  }

  private String einleseArtikelBezeichnung() {
    System.out.print("Artikelbezeichnung: ");
    input.nextLine();
    return input.nextLine();
  }

  private int einleseArtikelBestand() {
    System.out.print("Artikelbestand: ");
    return input.nextInt();
  }

  private double einleseArtikelPreis() {
    System.out.print("Artikelpreis: ");
    return input.nextDouble();
  }

  private int bestand() {
    System.out.print("Menge von Artikeln: ");
    return input.nextInt();
  }

  private double einleseProzensatz() {
    System.out.print("Prozensatz (kann positiv oder negativ sein): ");
    return input.nextDouble();
  }
  /**
  * Main-Methode zum Erzeugen des BankDialog-Objektes und zum Anstarten der Testschleife
  */
  public static void main (String[] args) {
    try {
      new LagerDialog().start();
    } catch(Throwable e) {
      System.out.println("main: Ausnahme gefangen: " + e);
    }
  }
}
