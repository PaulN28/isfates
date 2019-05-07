 

import java.util.Arrays;

/**
 * Write a description of class Sum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sum
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Sum
     */
    public Sum()
    {
    }

    public static void sum(float[] floatArray){

        int arrayGroesse = floatArray.length;
        System.out.println("Before sum: " + Arrays.toString(floatArray));
        for(int i = 1; i < arrayGroesse; i++){
            floatArray[i] = floatArray[i] + floatArray[i - 1];
        }
        System.out.println("After sum" + Arrays.toString(floatArray));
    }
}
