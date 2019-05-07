package NumberCrusher;

import java.util.Random;
import java.util.Arrays;

/**
 * Write a description of class Substract here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Substract
{
    /**
     * Constructor for objects of class Substract
     */
    public Substract()
    {
    }

    public static void substract(float[] floatArray){
        int arrayGroesse = floatArray.length;
        System.out.println("Before substract: " + Arrays.toString(floatArray));
        for(int i = 1; i < arrayGroesse; i++){
            floatArray[i] = floatArray[i] - floatArray[i - 1];
        }
        System.out.println("After substract: " + Arrays.toString(floatArray));
    }
}
