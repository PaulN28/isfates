 

import java.util.Random;
import java.util.Arrays;

/**
 * Write a description of class Average here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Average
{
    public Average()
    {
    }
    
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

    public static int getMaxIndex(float[] floatArray){
        int indexMax = 0;

        for (int i = 0; i < floatArray.length; i++) {
            indexMax = floatArray[i] > floatArray[indexMax] ? i : indexMax;
        }
        return indexMax;
    }

}
