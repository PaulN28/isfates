package aufgabe3;


import java.util.function.IntPredicate;

/**
 * Klasse der Uebung 18
 *
 * @author Paul Nicolas u. Nils Gamlin
 * @version 12.05.2019
 */

public class Ueb18{

    public Ueb18()
    {
    }

    /**
     * Alle Werte die zwischen i und j sind, werden dank eines MyFunction Objekts getestet.
     *
     * @param int i kleinster Wert der getestet wird.
     * @param int j groesster Wert der getestet wird.
     * @param MyFunction function Objekt des Interface MyFunction.
     */

    public static void applyAndPrint(int i, int j, MyFunction function){
        for(int n = i; n <= j; n++){
            System.out.println(function.apply(n));
        }
    }

    //------------------------------Anonym------------------------------

    //i
    /**
     * Gibt das Quadrat von x aus.
     */
    MyFunction quadratAnonym = new MyFunction() {
            public int apply(int x) {          
                return x * x;
            }
        };

    //ii
    /**
     * Gibt x! aus.
     */
    MyFunction factorialAnonym = new MyFunction() {
            public int apply(int x) {          
                int result = 1;
                for ( int i=1; i <=x; i++){
                    result = result * i;
                }
                return(result);
            }
        };

    //iii
    /**
     * Gibt x^(x+1) aus.
     */
    MyFunction exponentialAnonym = new MyFunction() {
            public int apply(int x) { 
                return (int) Math.pow(x, x+1);
            }
        };

    //iv
    /**
     * Gibt die x. Nummer der Fibonacci Reihe aus.
     */
    MyFunction fibonacciAnonym = new MyFunction(){
            public int apply(int x){
                int aux;
                int[] lastNumbers = {1, 1};
                for(int i = 0; i <= x - 1; i++){
                    aux = lastNumbers[1];
                    lastNumbers[1] = lastNumbers[0] + lastNumbers[1];
                    lastNumbers[0] = aux;
                }

                return lastNumbers[1];
            }
        };

    //------------------------------Lambda------------------------------

    MyFunction quadratLambda = x -> x * x;

    MyFunction factorialLambda = x -> 
        {
            int result = 1;
            for ( int i=1; i <=x; i++){
                result = result * i;
            }
            return(result);
        };

    MyFunction exponentialLambda = x -> (int) Math.pow(x, x+1);

    // iv
    MyFunction fibonacciLambda = (int x) -> {
            int aux;
            int[] lastNumbers = {1, 1};
            for(int i = 0; i <= x - 1; i++){
                aux = lastNumbers[1];
                lastNumbers[1] = lastNumbers[0] + lastNumbers[1];
                lastNumbers[0] = aux;
            }

            return lastNumbers[1];
        }; 

    //------------------------------Predicate------------------------------    
    /**
     * Gibt True aus wenn x gerade ist. Als Lambda Ausdruck implementiert.
     */    
    IntPredicate even = x -> x % 2 == 0;

    /**
     * Gibt True aus wenn x ungerade ist. Als Anonyme Klasse implementiert.
     */
    IntPredicate odd = new IntPredicate(){
            public boolean test(int x){
                return x % 2 != 0;
            }
        };

    /**
     * Implementierung mithilfe der Klasse ConditionaleInterface
     */
    ConditionaleInterface  condiQuadrat = x -> x * x;

    ConditionaleInterface condiFactorial = x -> 
        {
            int result = 1;
            for ( int i=1; i <=x; i++){
                result = result * i;
            }
            return(result);
        };

    //------------------------------Nested------------------------------     

    public static class Nested{
        public static int factorialNested (int x){
            int result = 1;
            for ( int i=1; i <=x; i++){
                result = result * i;
            }
            return(result);

        }
    }

    /**
     * Methode die die die Funktionen (Lambda, Anonym, Nested, Top Class) testet.
     */
    public void start(){
        System.out.println("---------Anonyme Tests--------- \n");
        System.out.println(" \nTest Quadrat \n");
        applyAndPrint(1, 5, quadratAnonym);
        System.out.println(" \nTest Factorial \n");
        applyAndPrint(1, 5, factorialAnonym);
        System.out.println(" \nTest Exponential \n");
        applyAndPrint(1, 5, exponentialAnonym);
        System.out.println(" \nTest Fibonacci \n");
        applyAndPrint(1, 5, fibonacciAnonym);

        System.out.println("---------Lambda Tests--------- \n");
        System.out.println(" \nTest Quadrat \n");
        applyAndPrint(1, 5, quadratLambda);
        System.out.println(" \nTest Factorial \n");
        applyAndPrint(1, 5, factorialLambda);
        System.out.println(" \nTest Exponential \n");
        applyAndPrint(1, 5, exponentialLambda);
        System.out.println(" \nTest Fibonacci \n");
        applyAndPrint(1, 5, fibonacciLambda);

        System.out.println("---------Static Nested Test--------- \n");

        Nested testerNested = new Nested();

        System.out.println(" \nTest Factorial \n");
        System.out.println(testerNested.factorialNested(4));
        System.out.println("---------Top Class Test--------- \n");

        TopLevelKlasse testerTopLevel = new TopLevelKlasse();

        System.out.println(" \nTest Factorial \n");
        System.out.println(testerTopLevel.factorialTopLevel(4));

    }

    /**
     * Methode die die Funktionen (ConditionaleInterface) testet.
     */
    public void run()
    {

        //
        //1.e
        System.out.println( "\n Test Quadrat x = even \n");
        applyAndPrint(1, 10, condiQuadrat.conditionateInput(even) );

        //
        //1.f
        System.out.println( "\n Test factorial f(x) = odd \n");
        applyAndPrint( 1, 10,condiFactorial.conditionateOutput(odd) );
    }
    
    public void run_ueb18()
    {
        TopLevelKlasse testerTopLevel18 = new TopLevelKlasse();
        
        System.out.println("\n TopLevel Klasse Fakultaet ");
        applyAndPrint(1, 5, testerTopLevel18::factorialTopLevel);
        System.out.println("\n Nested Klasse Fakultaet ");
        applyAndPrint(1, 5, Nested::factorialNested);
    }

    /**
     * Startet die Tests
     */

    public static void main(String[] args){
        Ueb18 ueb18test = new Ueb18();
        ueb18test.run_ueb18();
    }

}

