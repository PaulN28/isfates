
/**
 * Klasse die die, durch Anonyme Klassen implementierten, Funktionen sum, substract, divide, swirl, divide testet.
 *
 * @author Nils Gamlin
 * @version 03.05.2019
 */

public class NumberCrusherTestAnonym
{
    public NumberCrusherTestAnonym()
    {
    }

 /**
 * Testet die Funktionen sum, substract, divide, swirl, divide.
 *
 * @param String[] Argumente
 */
    
    public static void main(String[] args)
    {   
        String[] operations = {"sum", "swirl", "divide", "substract", "average"};
        int groesse = 10;   
        NumberCrusherAnonym anonym = new NumberCrusherAnonym(groesse);    
        anonym.crush(operations);
    }
}
