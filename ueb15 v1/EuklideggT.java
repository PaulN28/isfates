/**
 * Klasse der Methode ggT. 
 *
 * @author Paul Nicolas, Nils Gamlin
 * @version 20.04.2019
 */
public class EuklideggT
{
    
    
    /**
     * Methode die es ermoeglicht den groeßten gemeinsamen Teiler von zwei long Zahlen zu berechnen.
     *
     * @param a long Zahl. 
     * @param b long Zahl.
     * @return a long Zahl falls b = 0, sonst wird a weiter reduziert.
     */
    
    public static long ggT(long a, long b)
    {
        if(b == 0){
            return a;
        }
        return ggT(b, a % b);
    }
    
    public static void main(String[] args){
        System.out.println("ggT(15, 3) = " + ggT(15, 3));
        System.out.println("ggT(5, 3) = " + ggT(5, 3));
        System.out.println("ggT(9, 81) = " + ggT(9, 81));
        System.out.println("ggT(5, 5) = " + ggT(5, 5));
        System.out.println("ggT(20, 4) = " + ggT(20, 4));
    }
    
}
