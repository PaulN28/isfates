EVERYTHING MOVED TO Ueb17AnonymousLambda

/*import java.util.*;
import java.util.function.Predicate;

/**
 * Write a description of class Ueb17Anonymous here.
 *
 * @author (your name)
 * @version (a version number or a date)

public class Ueb17Anonymous
{
    private static Scanner input;

    public Ueb17Anonymous(){
        input = new Scanner(System.in);
    }

    public interface Anonymous{
        public int function();
    }

    Predicate<Integer> odd = new Predicate<Integer>(){
            public boolean test(Integer x){ //utilisation de int pas possible car pas la même signature (pas le même type argument, int =/= Integer) voir docs java
                return x%2 !=0;
            }
    };

    public static void main(String[] args){
        int b = 0;
        System.out.println("enter an integer:");
        b = input.nextInt();
        int a = b;

        Anonymous quadrat = new Anonymous(){
                public int function(){
                    return a * a;
                }
            };

        Anonymous factorial = new Anonymous(){
                public int function(){
                    int n = 1;
                    for(int i = 0; i< a + 1; i++){
                        n = n * a;
                    }
                    return n;
                }
            };

        Anonymous exponential = new Anonymous(){
                public int function(){
                    int n = 1;
                    for(int i = 0; i< a + 1; i++){
                        n = n * a;
                    }
                    return n;
                }
            };

        Anonymous fibonacci = new Anonymous(){
                public int function(){
                    int aux;
                    int[] lastNumbers = {1, 1};
                    for(int i = 0; i <= a - 1; i++){
                        aux = lastNumbers[1];
                        lastNumbers[1] = lastNumbers[0] + lastNumbers[1];
                        lastNumbers[0] = aux;
                    }

                    return lastNumbers[1];
                }
            };

    }
}

*/
