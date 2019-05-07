import java.util.Random;
import java.util.Arrays;

/**
 * Die Klasse Swirl ermöglicht es, ohne Anonyme Klasse, die Funktion swirl zu implementieren.
 *
 * @author Paul Nicolas u. Nils Gamlin
 * @version 03.05.2019
 */

public class Swirl
{
    public Swirl()
    {
    }

 /**
 *  Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch die Länge des
 *  float-Arrays gegeben.
 *
 * @param float[] Array durch den iteriert wird. 
 */
 
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
