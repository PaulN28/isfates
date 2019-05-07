import java.util.Arrays;

/**
 * Die Klasse Sum ermöglicht es, ohne Anonyme Klasse, die Funktion sum zu implementieren.
 *
 * @author Paul Nicolas u. Nils Gamlin
 * @version 03.05.2019
 */
public class Sum
{
    public Sum()
    {
    }

 /**
 * Summiert die Elemente des Arrays paarweise von links nach rechts auf und speichert
 * den neuen Wert in dem jeweils rechten Datenfeld. D.h.: a[1] = a[0] + a[1]; a[2] = a[1] + a[2] usw.
 *
 * @param float[] Array durch den iteriert wird. 
 */
 
    public static void sum(float[] floatArray){

        int arrayGroesse = floatArray.length;
        System.out.println("Before sum: " + Arrays.toString(floatArray));
        for(int i = 1; i < arrayGroesse; i++){
            floatArray[i] = floatArray[i] + floatArray[i - 1];
        }
        System.out.println("After sum" + Arrays.toString(floatArray));
    }
}
