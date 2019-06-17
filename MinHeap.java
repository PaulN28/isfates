import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public class MinHeap<E extends Comparable> implements java.util.Queue<E>{

    private E[] heap;
    private int currentSize;

    /**
     * Konstruktor der Klasse MinHeap.
     * @param klasse Typ der Elemente die in den Array gespeichert werden sollen.
     * @param arraySize Groesse des Arrays
     */

    public MinHeap(Class<E> klasse, int arraySize){
        heap = (E[]) Array.newInstance(klasse, arraySize);
        currentSize = 0;
    }

    /**
     * Fügt das angegebene Element in den Queue ein, wenn dies ohne Verletzung der Kapazitätsbeschränkungen sofort möglich ist.
     * @param element das einzufügene Element.
     * @return boolean
     */
    public boolean offer(E element){
        if(currentSize <= heap.length){
            int currentIndex = currentSize + 1;
            heap[currentSize] = element;
            currentSize ++;

            int indexParent = getParent(currentIndex);
            while((heap[currentIndex]).compareTo(heap[indexParent]) < 0){
                swap(currentIndex, indexParent);
                currentIndex = indexParent;
            }
            return true;
        }
        return false;
    }

    /**
     * Ruft den Head des Queues ab und entfernt ihn.
     * Gibt null zurück, wenn der Queue leer ist.
     * @return E
     */

    public E poll(){
        if (currentSize != 0) {
            E firstElement = heap[0];
            heap[0] = null;
            swap(0, currentSize - 1);

            int acc = 0;
            int biggestVal = 0;
            while(acc < currentSize){
                if(heap[getRightChild(acc)].compareTo(heap[getLeftChild(acc)]) < 0){
                    biggestVal = getRightChild(currentSize);
                }

                if(heap[biggestVal].compareTo(heap[acc]) < 0){
                    swap(biggestVal, acc);
                    acc = biggestVal;
                }

            }

            return firstElement;
        }
        return null;
    }

    /**
     * Ruft den Head des Queues ab, entfernt ihn aber nicht.
     * Gibt Null zurück, wenn diese Warteschlange leer ist.
     * @return E
     */

    public E peek(){
        if(currentSize > 0){
            return heap[0];
        }
        return null;
    }

    private int getParent(int index){
        return index / 2;
    }

    private int getLeftChild(int index){
        return 2 * index;
    }

    private int getRightChild(int index){
        return (2 * index) + 1;
    }

    private void swap(int i, int j){
        E aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    //-------------- Nicht implementierte Methoden --------------

    public boolean add(E e){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public E remove(){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public E element(){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public int size(){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public int hashCode(){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    @Override
    public boolean equals(Object o) {
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public void clear(){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public boolean addAll(Collection<? extends E> c) {
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public boolean containsAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public boolean remove(Object o) {
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public boolean isEmpty(){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public <T> T[] toArray(T[] a){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public Object[] toArray(){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public Iterator<E> iterator(){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }

    public boolean contains(Object o){
        throw new java.lang.UnsupportedOperationException("Nicht implementierte Methode !");
    }


    //-------------- Test --------------
    public static void main(String[] args){
        System.out.println(Integer.class);
    }

}
