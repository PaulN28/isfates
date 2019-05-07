package NumberCrusher;

import java.util.Random;
import java.util.Arrays;

/**
 * Write a description of class NumberCruncherTopClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NumberCrusherTopClass
{
    private int arrayGroesse;
    private static float[] floatArray; //meme probleme que la semaine dernière pourquoi faut tout mettre en static ?
    Random random;

    /**
     * Constructor for objects of class NumberCrusher
     */
    public NumberCrusherTopClass(int arrayGroesse)
    {
        this.arrayGroesse = arrayGroesse;
        floatArray = new float[arrayGroesse];

        Random random = new Random();

        for(int i = 0; i < arrayGroesse;  i++){
            floatArray[i] = random.nextFloat();
        }
        System.out.println(Arrays.toString(floatArray));
    }
    
    public static void crunch(String[] operations){
        for(String i : operations){
            switch(i){
                case "sum":
                Sum.sum(floatArray);
                break;

                case "divide":
                Divide.divide(floatArray);
                break;

                case "substract":
                Substract.substract(floatArray);
                break;

                case "average":
                Average.average(floatArray);
                break;

                case "swirl":
                Swirl.swirl(floatArray);
                break;
            }
        }
    }  
}
