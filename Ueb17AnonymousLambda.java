import java.lang.Math;
import java.util.*;
import java.util.function.Predicate;

/**
 * Write a description of class Function here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ueb17AnonymousLambda
{
    private static Scanner input;

    public Ueb17AnonymousLambda(){
        input = new Scanner(System.in);
    }

    public interface MyFunction{
        public int apply(int i);
    }

    public interface Anonymous{
        public int function();
    }

    public interface conditionateInterface extends MyFunction
    {
        default public int conditionteInput(Predicate<Integer> condition, int a){
            return condition.test(a) ? apply(a) : 0;
        }

        default public int conditionteOutput(Predicate<Integer> condition, int b){
            return condition.test(apply(b)) ? apply(b) : 0;
        }
    }

    Predicate<Integer> odd = new Predicate<Integer>(){
            public boolean test(Integer x){ //utilisation de int pas possible car pas la même signature (pas le même type argument, int =/= Integer) voir docs java
                return x%2 !=0;
            }
    };

    Predicate<Integer> even = x -> x%2 == 0;

    public static void applyAndPrint(int i, int j, MyFunction function){
        for(int n = i; n <= j; n++){
            System.out.println(function.apply(n));
        }
    }

//-----------------------implementation Lambda-----------------------


    public static void mainLambda(String[] args){
        MyFunction quadrat = (int a) -> a * a;
        MyFunction factorial = (int a) -> {
                int x = 1;
                for(int i = 1; i<= a; i ++){
                    x = x * i;
                }
                return x;
            };//recursive method possible according to the internet
        MyFunction exponential = (int a) -> {
                int n = 1;
                for(int i = 0; i< a + 1; i++){ //on aurait aussi pu utiliser <=, mais a +1 plus clair
                    n = n * a;
                }
                return n; // Valeur max d'un int très rpaidement atteint, long pas possible a cause du typede a mettre un check ?
            };

        MyFunction fibonacci = (int a) -> {
                int aux;
                int[] lastNumbers = {1, 1};//stack parfait mis problème initilistion avec des valeurs, oligé d'utiliser un for.
                for(int i = 0; i <= a - 1; i++){
                    aux = lastNumbers[1];
                    lastNumbers[1] = lastNumbers[0] + lastNumbers[1];
                    lastNumbers[0] = aux;
                }

                return lastNumbers[1];
            };

        applyAndPrint(1, 9, quadrat);
        System.out.println("------------------------");
        applyAndPrint(1, 9, fibonacci);
        System.out.println("------------------------");
        applyAndPrint(1, 9, exponential);
        System.out.println("------------------------");
        applyAndPrint(1, 9, factorial);

    }

    //-----------------------Anonymous implementation-----------------------

    public static void mainAnonymous(String[] args){
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
//-----------------------NestedClass implementation----------------------
    public static class factorial{
        public int factorial(int a){
            int x = 1;
            for(int i = 1; i<= a; i ++){
                x = x * i;
            }
            return x;
        }
    }
}
