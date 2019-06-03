import java.util.Random;

public class Ueb181 {
   
   /**
   * Die Methode soll die Funktion wiederholt (n-Iterationen) auf dem vorherigen Ergebnis anwenden.
   *
   * @param double Startwert.
   * @param int Anzahl an Iterationen.
   * @param MyFunction Funktion die angewendet werden soll.
   *
   * @return Double Wert der letzten Iteration.
   */
    
    public static double iterate(double start, int iterations, MyFunction function){
        double aux = start;
        for(int i = 0; i < iterations; i++){
            aux = function.iterate(aux);
            System.out.printf("Iteration %d: %.3f \n", i+1, aux);
        }
        return aux;
    }
    
    /**
   * Diese Methode soll die  Methode Iterate testen.
   *
   * @param String[] beliebige Argumente. 
   */

    public static void main(String[] args){
        System.out.println("########## f(x) = 2x ##########\n");
        iterate(3.6, 4, x -> 2*x);
        System.out.println("\n########## f(x) = 0,5x ##########\n");
        iterate(3.6, 4, x -> x * 0.5);
        System.out.println("\n########## f(x) = ax(x - 1) ##########\n");
        double a = Math.random();
        System.out.printf("a: %.3f\n\n", a);
        iterate(3.6, 4, x -> a * x * (x - 1));
    }
}
