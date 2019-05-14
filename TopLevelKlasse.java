/**
 * Top Level Klasse der Uebung 17
 *
 * @author Paul Nicolas u. Nils Gamlin
 * @version 12.05.2019
 */
public class TopLevelKlasse
{

    public TopLevelKlasse()
    {
    }

    /**
     * Gibt x! aus.
     *
     * @param  int   x
     * @return  int   x!
     */
    public int factorialTopLevel(int x)
    {
        int result = 1;
        for ( int i=1; i <=x; i++){
            result = result * i;
        }
        return(result);
    }
}
