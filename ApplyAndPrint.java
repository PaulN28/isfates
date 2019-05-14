import java.util.function.IntPredicate;
/**
 * Décrivez votre classe ueb17 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ApplyAndPrint
{
    private int x;

    /**
     * Constructeur d'objets de classe ueb17
     */
    public ApplyAndPrint()
    {

    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void applyAndPrint (int i, int j, MyFunction function){
            
        int wiederholung = Math.abs(i - j); 
        int[] result = new int[wiederholung];
            
            for (int n=0; n <= wiederholung; n++){
                
                result[n] = function.apply(n);
                
            }

            System.out.println(result);
    }
    
    IntPredicate even = x -> x % 2 == 0;

    IntPredicate odd = new IntPredicate(){
    public boolean test(int x){
    return x % 2 != 0;
}
};
}
