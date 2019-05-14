
/**
 * Décrivez votre classe LambdaAusdruck ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class LambdaAusdruck
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;

    /**
     * Constructeur d'objets de classe LambdaAusdruck
     */
    public LambdaAusdruck()
    {
        // initialisation des variables d'instance
        x = 0;
    }

    MyFunction i = x -> x * x;
    
    MyFunction ii = x -> 
       {
            int result = 1;
                for ( int i=1; i <=x; i++){
                    result = result * i;
                }
                return(result);
       };
       
    MyFunction iii = x -> (int) Math.pow(x, x+1);
    
    //MyFunction iv
}
