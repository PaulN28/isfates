
/**
 * Décrivez votre classe Anonyme ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Anonyme
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;

    /**
     * Constructeur d'objets de classe Anonyme
     */
    public Anonyme()
    {
        // initialisation des variables d'instance
        x = 0;
    }

        //i
        
        MyFunction i = new MyFunction() {
            public int apply(int x) {          
                return x * x;
            }
        };
        
        
        //ii
        
        MyFunction ii = new MyFunction() {
            public int apply(int x) {          
                int result = 1;
                for ( int i=1; i <=x; i++){
                    result = result * i;
                }
                return(result);
            }
        };
        
        //iii
        
        MyFunction iii = new MyFunction() {
            public int apply(int x) { 
                return (int) Math.pow(x, x+1);
            }
        };
        
        //iv
        
        MyFunction iv = new MyFunction() {
            public int apply(int x) { 
                return 0;
            }
        };
        
        
        
}

