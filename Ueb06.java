
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
    */
    public static void messwerte (double[] tab) {
      double mittel, min, max;
      mittel = 0.0;
      for (int i = 0; i < tab.length; i++) {
        mittel += tab[i];
      }
      mittel /= tab.length;
      min = max = tab[0];
      for (int i = 1; i < tab.length; i++) {
        if (Math.abs(mittel - tab[i]) < Math.abs(mittel - min)) {
          min = tab[i];
        }
        if (Math.abs(mittel - tab[i]) > Math.abs(mittel - max)) {
          max = tab[i];
        }
      }
      System.out.print("\n Mittel: " + mittel + " Min: " + min + " Max: "+ max);
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
    */
    public static void insertionSort(int[] array)
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

        System.out.println(  "\n Das sortierte intArray : \n\t" +
                                  java.util.Arrays.toString(array));
    }

    /**
    * Main Methode fuer die Klasse Ueb06
    * Es ist moeglich in den Feldern beliebig zu aendern
    */
    public static void main(String[] args) {
      double messwerte_tab[] = {0,1,2,3,4,5};
      String stringZaehler_tab[] = {"p1", "mml", "p    m", "%pa,", "v"};
      int insertionSort_tab[]  = {2, 8, 5, 7, 1, 3, 15, -9};

      messwerte(messwerte_tab);

      System.out.println("\n\n " + stringZaehler(stringZaehler_tab));

      insertionSort(insertionSort_tab);

     }
}
