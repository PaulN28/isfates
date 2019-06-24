import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Set;

public class Consumer {


    private TreeMap<Integer, LinkedList<Long>> treemap;
    
    /**
    * Konstruktor des Consumers
    */

    public Consumer(){
        treemap = new TreeMap<Integer, LinkedList<Long>>();
    }

    /**
    * Diese Methode nimmt einen Integer entgegen und berechnet die Quersumme.
    * Für jede Berechnung wird außerdem der Zeitstempel der Berechnung gespeichert werden.
    * Die Methode System.currentTimeMillis(), um den Zeitstempel zu erhalten.
    * 
    * @param int Nummer.
    */
    
    public void consume (int n){

    System.out.println("Initial number: " + n + "/n");

    int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

    long timestamp = System.currentTimeMillis();

    System.out.println("Quersumme: " + sum + "/n");
    System.out.println("Timestamp: " + timestamp + "/n");

    if ( numberOfOccurrences(sum) > 0)
        {
            treemap.get(sum).add(timestamp);
        }
        else
        {
            LinkedList<Long> linkedList = new LinkedList<>();
            linkedList.add(timestamp);
            treemap.put(sum, linkedList);
        }
    }

    /**
    * Gibt an, wie viele unterschiedliche Quersummen berechnet wurden
    * 
    * @return int Anzahl an malle er ihn Berechnungen aufkam.
    */

    public int numberOfDifferentResult(){

        return treemap.keySet().size();
    }
    
    /**
    * Gibt für einen gegebenen Integer an, wie häufig dieser als Ergebnis einer Berechnung vorkam
    *
    * @ param int n
    * @return int Anzahl an malle er ihn Berechnungen aufkam.
    */

    public int numberOfOccurrences(int n){
        //if (treemap.containsKey(n) ) {
            return treemap.get(n).size();
        //}
    //    return 0;
    }
    
    /**
    * Gibt eine Collection zurück, welche die berechneten Quersummen in aufsteigender Reihenfolge enthält
    *
    * @return Set<Integer> Collection mit den Quersummen in aufsteigender Form.
    */

    public Set<Integer> getCrossTotalsAscending(){
        return treemap.keySet();
    }
    
     /**
    * Gibt eine Collection zurück, welche die berechneten Quersummen in absteigender Reihenfolge enthält.
    * 
    * @return NavigableSet<Integer> Collection mit den Quersummen in absteigender Form.
    */

    public NavigableSet<Integer> getCrossTotalsDescending(){
        return treemap.descendingKeySet();
    }
    
    /**
    * nimmt einen Integer entgegen und gibt eine Collection zurück,
    * welche alle zugehörigen Zeitstempel enthält. D.h. die Zeitstempel der Berechnungen, die
    * zu dem gegebenen Ergebnis geführt haben.
    * 
    * @param int n
    * @return LinkedList<Long>
    */

    public LinkedList<Long> getTimestampsForResult(int n){
        return treemap.get(n);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

