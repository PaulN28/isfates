/**
 * Klasse der Methode StringCount
 *
 * @author  Nils Gamlin
 * @version 1.0
 */

public class HowManyStrings
{
    /**
    * Methode die zu einem übergebenen String-Array bestimmt, wieviele Strings darin enthalten sind, die ausschließlich aus Klein- oder Großbuchstaben bestehen.
    *
    * @param String Array  Nils Gamlin
    * @return anzahl an Strings in der Tabelle, die ausschließlich aus Klein- oder Großbuchstaben bestehen.
    */

    public int StringCount(String[] stringArray){
        int acc = 0;
        
        for(int i= 0; i < stringArray.length; i++){
            if (stringArray[i].matches("[a-zA-Z][^\\s]+")){  //"^" = not; "\\s" = whitespace character; "+" = wiederholung 1 oder beliebig viel
                acc++;
            }
        }
        return acc;
    }
}
