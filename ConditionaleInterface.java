import java.util.function.IntPredicate;
/**
 * Décrivez votre interface ConditionaleInterface ici.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 */

public interface ConditionaleInterface extends MyFunction
{
    default ConditionaleInterface conditionateInput (IntPredicate bedingung){
        return toTest -> bedingung.test(toTest) ? apply(toTest) : 0; 
    }
    
    default ConditionaleInterface conditionateOutput (IntPredicate bedingung){
        return toTest -> bedingung.test(apply(toTest)) ? apply(toTest) : 0; 
    }
}

