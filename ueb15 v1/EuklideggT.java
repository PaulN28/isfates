
/**
 * Write a description of class EuklideggT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EuklideggT
{
    // instance variables - replace the example below with your own
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
