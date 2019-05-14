import java.util.function.IntPredicate;
/**
 * ConditionaleInterface der Uebung 17.
 *
 * @author Paul Nicolas u. Nils Gamlin
 * @version 12.05.2019
 */

public interface ConditionaleInterface extends MyFunction
{

    /**
     * Nimmt ein Prädikat als Argument entgegen und gibt einen Lambda-Ausdruck zurück
     * Der Lambda-Ausdruck prüft für einen gegebenen Integer-Wert, ob dieser das Prädikat erfüllt
     */
    default ConditionaleInterface conditionateInput (IntPredicate bedingung){
        return toTest -> bedingung.test(toTest) ? apply(toTest) : 0; 
    }

    /**
     * Diese Methode nimmt ein Prädikat als Argument entgegen und gibt einen Lambda-Ausdruck zurück. Der Lambda-Ausdruck prüft, ob das
     * Ergebnis der apply-Methode das Prädikat erfüllt. 
     */
    default ConditionaleInterface conditionateOutput (IntPredicate bedingung){
        return toTest -> bedingung.test(apply(toTest)) ? apply(toTest) : 0; 
    }
}

