import java.util.Random;
import java.util.Arrays;

/**
 * Die Klasse Average ermöglicht es, ohne Anonyme Klasse, den Durchschnitt aller Werte eines gegebenen Arrays zu berechnen.
 *
 * @author Paul Nicolas u. Nils Gamlin
 * @version 03.05.2019
 */
public class Average
{
    public Average()
    {
    }
    
 /**
 * Berechnet den Durchschnitt aller Werte und speichert den berechenten Wert an Stelle des groessten Werts im Array.
 *
 * @param float[] Array wo Durchschnitt berechnet wird.
 */
    public static void average(float[] floatArray){
        int arrayGroesse = floatArray.length;
        System.out.println("Before average: " + Arrays.toString(floatArray));
        float acc = 0;
        float average;

        for(float i : floatArray){
            acc += i;
        }

        int maxIndex = getMaxIndex(floatArray);

        floatArray[maxIndex] = acc / (float) arrayGroesse;

        System.out.println("After average: " + Arrays.toString(floatArray));
    }
 
 /**
 * Findet den Index des groessten Werts im Array.
 *
 * @param float[] Array durch welches iteriert wird.
 */

    public static int getMaxIndex(float[] floatArray){
        int indexMax = 0;

        for (int i = 0; i < floatArray.length; i++) {
            indexMax = floatArray[i] > floatArray[indexMax] ? i : indexMax;
        }
        return indexMax;
    }

}
