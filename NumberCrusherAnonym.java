import java.util.Random;
import java.util.Arrays;

/**
 * Write a description of class NumberCrusher here.
 *
 * @author Nils Gamlin
 * @version 03.05.2019
 */
public class NumberCrusherAnonym
{
    public interface Funktion{
        public void funktion();
    }

    // instance variables - replace the example below with your own
    private int arrayGroesse;
    private float[] floatArray;
    Random random;

    /**
     * Constructor for objects of class NumberCrusher
     */
    public NumberCrusherAnonym(int arrayGroesse)
    {
        this.arrayGroesse = arrayGroesse;
        floatArray = new float[arrayGroesse];

        Random random = new Random();

        for(int i = 0; i < arrayGroesse;  i++){
            floatArray[i] = random.nextFloat();
        }
        System.out.println(Arrays.toString(floatArray));
    }

    public void crush(String[] operations){

        //---------------------Funktionen---------------------

        Funktion sum = new Funktion(){
                public void funktion(){
                    System.out.println("Before sum: " + Arrays.toString(floatArray));
                    for(int i = 1; i < arrayGroesse; i++){
                        floatArray[i] = floatArray[i] + floatArray[i - 1];
                    }
                    System.out.println("After sum" + Arrays.toString(floatArray));
                }
            };


        Funktion swirl = new Funktion(){
                public void funktion(){
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
            };

        Funktion divide = new Funktion(){
                public void funktion(){
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
            };

        Funktion substract = new Funktion(){
                public void funktion(){
                    System.out.println("Before substract: " + Arrays.toString(floatArray));
                    for(int i = 1; i < arrayGroesse; i++){
                        floatArray[i] = floatArray[i] - floatArray[i - 1];
                    }
                    System.out.println("After substract: " + Arrays.toString(floatArray));
                }
            };

        Funktion average = new Funktion(){
                public void funktion(){
                    System.out.println("Before average: " + Arrays.toString(floatArray));
                    float acc = 0;
                    float average;

                    for(float i : floatArray){
                        acc += i;
                    }

                    floatArray[getMaxIndex()] = acc / (float) arrayGroesse;
                    
                    System.out.println("After average: " + Arrays.toString(floatArray));
                }

                public int getMaxIndex(){
                    int indexMax = 0;

                    for (int i = 0; i < floatArray.length; i++) {
                        indexMax = floatArray[i] > floatArray[indexMax] ? i : indexMax;
                    }
                    return indexMax;
                }
            };
            


        //---------------------ausfuehren der Funtionen---------------------

        for(String i : operations){
            switch(i){
                case "sum":
                sum.funktion();
                break;

                case "divide":
                divide.funktion();
                break;

                case "substract":
                substract.funktion();
                break;

                case "average":
                average.funktion();
                break;

                case "swirl":
                swirl.funktion();
                break;
                
                default:
                System.out.println("Falsche Funktion");
                break;
            }
        }
    } 
    
          public String toString(){
        
        String inhalt = "Array :";
        
        for(int i = 0; i < arrayGroesse;  i++){
            inhalt += " " + floatArray[i];
        }
        return inhalt;
    }
}
