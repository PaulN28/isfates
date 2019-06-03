package aufgabe1;

import java.util.Random;


/**
 * Décrivez votre classe Aufgabe1 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Aufgabe1
{
    public double a  = Math.random();
    
    /**
     * Constructeur d'objets de classe Aufgabe1
     */
    public Aufgabe1()
    {
    }
    
    
    /**
     * 
     */
    
    public double iterate(double x0, int n, Aufgabe1Interface auf1int){
        
        double xi = x0;
        
        for (int i = 1; i <=n; i++){  
            System.out.println(i + " : " + xi);
            xi = auf1int.apply(xi);
        }
        return xi;
    }
    
    
    Aufgabe1Interface i = x -> 2 * x;
    
    Aufgabe1Interface ii = x -> 0.5 * x;
    
    Aufgabe1Interface iii = x -> a * x * (x - 1);
    
    
    public void run(){
        
        System.out.println( iterate(1.0, 10, i));
        System.out.println( iterate(1.0, 10, ii));
        System.out.println( iterate(2.3, 10, iii));
        
    }
    
    public static void main (String args[]){
        
        Aufgabe1 tester = new Aufgabe1();
        tester.run();
        
    }

}
