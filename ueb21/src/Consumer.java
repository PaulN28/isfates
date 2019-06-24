import java.util.*;

public class Consumer {

    public static LinkedList list = new LinkedList();
    private static TreeMap<Integer, LinkedList<Long>> dictionnary;

    public Consumer(){
        dictionnary = new TreeMap<Integer, LinkedList<Long>>();
    }

    public static void consume(int number){
        int sum = 0;
        while(number > 0){
            sum += number % 10;
            //System.out.println(number);
            number = number /10;
            //System.out.println(number);
        }
        long stamp = System.currentTimeMillis();
        if(dictionnary.containsKey(sum)){
            LinkedList<Long> cloneOfValues = dictionnary.get(sum);
            cloneOfValues.add(stamp);
            dictionnary.put(sum, cloneOfValues);
        }
        else{
            LinkedList<Long> values = new LinkedList<Long>(Arrays.asList(stamp));
            dictionnary.put(sum, values);
        }

        System.out.println(sum);
        System.out.println("Stamp: " + stamp);
    }

    public int numberOfDifferentResults(){
        return dictionnary.size();
    }

    public int numberOfOccurrences(int key){
        return dictionnary.get(key).size();
    }

    public static Set<Integer> getCrossTotalsAscending(){
        return dictionnary.keySet();
    }

    public static NavigableSet<Integer> getCrossTotalsDescending(){
        return dictionnary.descendingKeySet();
    }

    public static LinkedList<Long> getTimestampsForResult(int key){
        return dictionnary.get(key);
    }




    public static void main(String[] args){
        Consumer c = new Consumer();
        consume(58635);
        consume(526);
        consume(9);
        consume(333);
        consume(8548);
        consume(569326512);

        System.out.println(getCrossTotalsAscending());
        System.out.println(getCrossTotalsDescending());
        System.out.println(getTimestampsForResult(9));
    }
}
