/**
 * Klasse die die, als Überklassen implementierten, Funktionen sum, substract, divide, swirl, divide testet.
 *
 * @author Nils Gamlin
 * @version 03.05.2019
 */

public class NumberCrusherTestTopClass
{
    public NumberCrusherTestTopClass()
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
        NumberCrusherTopClass topclass = new NumberCrusherTopClass(groesse);    
        topclass.crush(operations);
    }
}
