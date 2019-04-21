
/**
 * Write a description of class MyMathClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ueb15
{

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int ggT(int a, int b)
    {
        if(b == 0){
            return a;
        }
        return ggT(b, a % b);
    }

    public static boolean isPalindromeRecursive(String string){

        int stringLength = string.length();

        if(stringLength == 0 || stringLength == 1){
            return true;
        }

        if(string.substring(0, 1).equals(string.substring(stringLength - 1, stringLength))){

            return isPalindromeRecursive(string.substring(1, stringLength - 1));
        }

        return false;
    }

    public static boolean isPalindromeIterative(String string){
        int stringLength = string.length();
        int stringLengthBegin = stringLength;

        for(int i = 0; i < (stringLengthBegin / 2) + 1; i++){
            
            stringLength = string.length();

            if(stringLength == 0 || stringLength == 1){
                return true;
            }

            if(string.substring(0, 1).equals(string.substring(stringLength - 1, stringLength))){
                string = string.substring(1, stringLength - 1);
            }
        }
        return false;
    }
}
