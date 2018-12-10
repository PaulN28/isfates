/**
* Eine Klasse, die die Methoden der Uebung 6 beinhaltet
*
* @author Paul NICOLAS und Nils GAMLIN
* @version 07/12/18
*/

public class Ueb06
{
    /**
    * Methode, die zu einem übergebenen Feld mit double-Messwerten das arithmetische Mittel dieser Werte bestimmt,
    * sowie den Messwert, der am nächsten daran liegt und den der am weitesten davon entfernt ist.
    *
    * @param  double[] Ein Feld mit double Messwerten
    * @return double[] Gibt ein Feld mit min, mittel und max
    */
    public static double[] messwerte (double[] tab) {
      double mittel, min, max;
      mittel = 0.0;
      for (int i = 0; i < tab.length; i++) {
        mittel += tab[i];
      }
      mittel = mittel / tab.length;
      min = max = tab[0];
      for (int i = 1; i < tab.length; i++) {
        if (Math.abs(mittel - tab[i]) < Math.abs(mittel - min)) {
          min = tab[i];
        }
        if (Math.abs(mittel - tab[i]) > Math.abs(mittel - max)) {
          max = tab[i];
        }
      }
      return new double[] {min, mittel, max };
    }
    
    /*
    * Zeigt die Messwerte an
    * @param double[] Ein Feld mit double Messwerten
    */
    
    public static void printMesswerte(double[] tab) {
      System.out.println("\ndie Ergebnisswerte : min, mittel, max : \n\t" +
                               java.util.Arrays.toString( messwerte(tab) ));
    }

    /**
    * Methode die zu einem übergebenen String-Array bestimmt, wieviele Strings darin enthalten sind, die ausschließlich aus Klein- oder Großbuchstaben bestehen.
    *
    * @param String[] Array von Strings
    * @return anzahl an Strings in der Tabelle, die ausschließlich aus Klein - oder Großbuchstaben bestehen.
    */
    public static int stringZaehler (String[] stab) {
      int summe = 0;
      for (String s : stab)
          {
           if ( s.matches( "[a-zA-Z]+" ) )
             {
              summe++;
             }
          }
          return summe;
      }

    /**
    * InsertionSort Algorithmus. Sortiert die Zahlen eines uebergebenen Arrays. (klein bis groß)
    *
    * @param  int[] array ist eine unsortierte/sortierte Liste von Zahlen
    * @return insertionSort Gibt das als Parameter eingegebe Array, sortiert zurueck
    */
    public static int[] insertionSort(int[] array)
    {
        int aktuelleZahl;
        int j;
        int arrayLength = array.length;

        for (int i = 1; i < arrayLength; i++) {
            aktuelleZahl = array[i];
            j = i-1;

            while (j >= 0 && array[j] > aktuelleZahl) {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = aktuelleZahl;
        }
        return array;
    }

    /*
    * Zeigt das sortiert Feld an
    * @param int[] Ein Feld mit int Messwerten
    */
    
    public static void printInsertionSort(int[] array) {
      System.out.println(  "\n Das sortierte intArray : \n\t" +
                                java.util.Arrays.toString(insertionSort( array )));
    }

    /**
    * Main Methode fuer die Klasse Ueb06
    * Es ist moeglich in den Feldern beliebig zu aendern
    */
    public static void main(String[] args) {
      double messwerte_tab[] = {0.7, -8.6, -20, 0.8, 9};
      String stringZaehler_tab[] = {"p1", "mml", "p    m", "%pa,", "v"};
      int insertionSort_tab[]  = {2, 8, 5, 7, 1, 3, 15, -9};

      printMesswerte(messwerte_tab);

      System.out.println("\n\n " + stringZaehler(stringZaehler_tab));

      printInsertionSort(insertionSort_tab);

     }
    
}
