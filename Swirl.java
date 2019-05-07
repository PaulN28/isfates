package NumberCrusher;

import java.util.Random;
import java.util.Arrays;

/**
 * Write a description of class Swirl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Swirl
{
    /**
     * Constructor for objects of class Swirl
     */
    public Swirl()
    {
    }

    public static void swirl(float[] floatArray){
        int arrayGroesse = floatArray.length;
        System.out.println("Before swirl: " + Arrays.toString(floatArray));
        Random random = new Random();
        float aux;

        for(int i = 0; i <= arrayGroesse; i++){ //traiter s par hasard ils tombent sur le meme index ?

            int firstRandomIndex = random.nextInt(arrayGroesse);
            int secondRandomIndex = random.nextInt(arrayGroesse);

            aux = floatArray[firstRandomIndex];
            floatArray[firstRandomIndex] = floatArray[secondRandomIndex];
            floatArray[secondRandomIndex] = aux;
            i++;
        }
        System.out.println("After swirl: " + Arrays.toString(floatArray));
    }
}
