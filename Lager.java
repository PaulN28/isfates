
/**
 * Eine Klasse Lager die es ermoeglicht verschiedene zu bearbeiten
 *
 * @Paul Nicolas & Nils Gamlin
 * @date 01/12/2018
 */

public class Lager {
  private String name; // Name des Lagers
  private Artikel [] artikelTab;
  private int anzArtikel;

  private static final String STANDARD_NAME = "Hauptlager";
  private static final int STANDARD_DIMENSION = 10;


  /**
   * Konstruktor fuer Objekte der Klasse Lager
   *
   * @param name Name des Lagers
   * @param maxAnzartikelen  maximale Anzahl an anzulegenden Artikeln
   */

  public Lager(String name, int maxAnzArtikel) { // pas sur de name
      check(maxAnzArtikel > 0, "Die Zahl der Artikel muss > 0 sein!");
      this.name = name;
      artikelTab = new Artikel[maxAnzArtikel];
      anzArtikel = 0;
  }

  public Lager ()
  {
    this(STANDARD_NAME, STANDARD_DIMENSION);
  }

  /**
   * Anlegen eines Lagers. Es ist zu pruefen, ob die
   * Artikelnummer bereits vergeben wurde und ob die
   * Artikeltabelle bereits voll ist.
   *
   * @param  artikelnummer  Artikelnummer des anzulegenden Lagers
   * @param  artikelbezeichnung  Bezeichnung des Artikels
   * @param  artikelbestand  Bestand des Artikels
   * @param  artikelpreis  Preis des Artikels
   */
  public void legeArtikelAn(int artikelnummer, String artikelbezeichnung, int artikelbestand, double artikelpreis) {
      check(findeArtikel(artikelnummer) < 0, "Artikel bereits vorhanden!");
      check(anzArtikel < getMaxAnzArtikel(), "Das Lager ist schon voll");  
      artikelTab[anzArtikel] = new Artikel(artikelnummer, artikelbezeichnung, artikelbestand, artikelpreis);
      anzArtikel++;
  }

  /**
   * Artikel loeschen, wenn die Artikelnummer nicht existiert wird eine Fehlermeldung geworfen
   *
   * @param  artikelnummer   zu uebergebende Artikelnummer
   *
   */
  public void loescheArtikel(int artikelnummer) {
      int i = findeArtikel(artikelnummer);
      check(i >= 0, "Artikel nicht vorhanden!");
      if (i >= 0) {
          artikelTab[i] = artikelTab[anzArtikel-1];
        artikelTab[anzArtikel-1] = null;
          anzArtikel--;
      }
    }
      /**
       * Zugang von Artikeln
       *
       * @param  artikelnummer   zu uebergebende Artikelnummer
       * @param  bestand einzuzahlender Bestand (> 0)
       */
      public void zugang(int artikelnummer, int bestand) {
          int i = findeArtikel(artikelnummer);
          check(i >= 0, "Artikel nicht vorhanden!");
          artikelTab[i].zugang(bestand);
      }

      /**
       * Abgang von Artikeln
       *
       * @param  artikelnummer   zu uebergebende Artikelnummer
       * @param  bestand   abuzahlende Menge (> 0)
       */
      public void abgang(int artikelnummer, int bestand) {
          int i = findeArtikel(artikelnummer);
          check(i >= 0, "Artikel nicht vorhanden!");
          artikelTab[i].abgang(bestand);
      }

      /**
       * Abgang von Artikeln
       *
       * @param  artikelnummer   zu uebergebende Artikelnummer
       * @param  prozentsatz    abuzahlende Menge (> 0)
       */
      public void aenderePreis(int artikelnummer, double prozentsatz) {
          int i = findeArtikel(artikelnummer);
          check(i >= 0, "Artikel nicht vorhanden!");
          artikelTab[i].aenderePreis(prozentsatz);
      }

      public void aenderePreisFuerAlleArtikel(double prozentsatz) {
        for (int i = 0; i <= anzArtikel - 1; i++) {
          artikelTab[i].aenderePreis(prozentsatz);
          }
      }

      /**
     * Interne Methode findeArtikel zur Vereinfachung anderer
     * Methoden
     *
     * @param  artikelnummer   zu uebergebende Artikelnummer
     * @return  Index des gesuchten Artikels oder -1
     *
     */
    private int findeArtikel(int artikelnummer) {
        for (int i = 0; i < anzArtikel; i++) {
            if (artikelTab[i].getArtikelnummer() == artikelnummer)
                return i;
        }
        return -1;
    }

    public int getAnzArtikel() {
        return anzArtikel;
    }

    public int getMaxAnzArtikel() {
	      return artikelTab.length;
    }

    /**
     * Lager-Objekt als Zeichenkette aufbereiten;
     * verwendet implizit die toString-Methode von Artikel
     *
     * @return  Zeichenkette
     *
     */
    public String toString() {
        String s = "Lager: " + name + '\n';
        for (int i = 0; i < anzArtikel; i++) {
            s += i + ": " + artikelTab[i] + '\n';
        }
        return s;
    }

    private static void check(boolean bedingung, String msg) {
    	if (!bedingung)
    		throw new IllegalArgumentException(msg);
    }
}
