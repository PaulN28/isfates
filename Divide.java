package NumberCrusher;

import java.util.Arrays;

/**
 * Write a description of class Divide here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Divide
{
    /**
     * Constructor for objects of class Divide
     */
    public Divide()
    {
    }

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
