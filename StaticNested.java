
/**
 * Décrivez votre classe StaticNested ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class StaticNested
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;

    /**
     * Constructeur d'objets de classe StaticNested
     */
    public StaticNested()
    {
        // initialisation des variables d'instance
        x = 0;
    }

    public static class Nested_ii{
     
        public static int ii (int x){
            
            int result = 1;
                for ( int i=1; i <=x; i++){
                    result = result * i;
                }
            return(result);
            
        
        
    }
}
}
