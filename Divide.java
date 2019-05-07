import java.util.Arrays;

/**
 * Die Klasse Divide ermöglicht es, ohne Anonyme Klasse, die Funktion divide zu implementieren.
 *
 * @author Paul Nicolas u. Nils Gamlin
 * @version 03.05.2019
 */
public class Divide
{
    public Divide()
    {
    }
 
 /**
 * Teilt den groessten Wert mit dem kleinsten und speichert in dan an Stelle des groessten Werts. 
 * Teilt den 2. groessten Wert mit dem 2. kleinsten und speichert in dann an Stelle des 2. groessten Werts. etc...
 *
 * @param float[] Array durch den iteriert wird.
 */

    public static void divide(float[] floatArray){
        int arrayGroesse = floatArray.length;
        Arrays.sort(floatArray);
        System.out.println("Before divide: " + Arrays.toString(floatArray));
        int counter = 0;

        for(int i = 0; i < arrayGroesse / 2; i++){ 
            System.out.println("anfang :" + floatArray[i]);
            System.out.println("ende: " + floatArray[(arrayGroesse - 1) - counter]);
            floatArray[(arrayGroesse - 1) - counter] = floatArray[(arrayGroesse - 1) - counter] / floatArray[i];
            counter++;
        }
        System.out.println("After divide: " + Arrays.toString(floatArray));
    }
}
