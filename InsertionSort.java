
/**
 * Klasse der Methode InsertionSort 
 *
 * @author Nils Gamlin
 * @version v1.0
 */
public class InsertionSort
{
     /**
     * InsertionSort Algorithmus
     *
     * @param  int[] array ist eine unsortierte/sortierte Liste von Zahlen
     * @return array wo die Zahlen sortiert sind. (klein bis groß)
     */
    public static int[] InsertionSort(int[] array)
    {
        int aktuelleZahl; 
        int j;
        int arrayLength = array.length;
        
        for (int i = 1; i < arrayLength; i++) { 
            aktuelleZahl = array[i]; 
            j = i-1; 
   
            while (j >= 0 && array[j] > aktuelleZahl) { 
                array[j+1] = array[j]; 
                j = j-1; 
            } 
            array[j+1] = aktuelleZahl; 
        } 
        
        return array;
    }
    
    public static void main(String[] args){
        int[] array = {2, 8, 5, 7, 1, 3, 15, -9};
        int[] sorted = InsertionSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(sorted[i] + ", ");
        }
    }
    
}
