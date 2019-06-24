import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Set;

public class Consumer {


    private TreeMap<Integer, LinkedList<Long>> treemap;

    public Consumer(){
        treemap = new TreeMap<Integer, LinkedList<Long>>();
    }

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


    public int numberOfDifferentResult(){

        return treemap.keySet().size();
    }

    public int numberOfOccurrences(int n){
        //if (treemap.containsKey(n) ) {
            return treemap.get(n).size();
        //}
    //    return 0;
    }

    public Set<Integer> getCrossTotalsAscending(){
        return treemap.keySet();
    }

    public NavigableSet<Integer> getCrossTotalsDescending(){
        return treemap.descendingKeySet();
    }

    public LinkedList<Long> getTimestampsForResult(int n){
        return treemap.get(n);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

