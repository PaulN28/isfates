import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Implementierung eines MinHeaps mithilfe des Queues Interface
 * @author NICOLAS Paul & GAMLIN Nils
 * @date 15/06/2019
 * @param <E> Objekt das die Klasse Comparable extends
 */

public class MinHeap<E extends Comparable<E>> implements Queue<E> {

    private E[] minHeap;
    private int currentSize;

    private static MinHeap<Integer> minHeapTest;

    /**
     * Konstruktor der Klasse MinHeap.
     * @param klasse Typ der Elemente die in den Array gespeichert werden sollen.
     * @param size Groesse des Arrays
     */

    public MinHeap(Class<E> klasse, int size) {
        minHeap = (E[]) Array.newInstance(klasse, size);
        currentSize = 0;
    }

    /**
     * Fuegt das angegebene Element in den Queue ein, wenn dies ohne Verletzung der Kapazitaetsbeschrankungen sofort moeglich ist.
     * @param e das einzufuegene Element.
     * @return boolean
     */

    @Override
    public boolean offer(E e) {
        boolean offer = false;
        if (!(currentSize + 1 > minHeap.length)) {
            minHeap[currentSize] = e;
            currentSize++;
            int current_node = currentSize - 1;
            while (true) {
                int parent_node = parent(current_node);

                if (minHeap[current_node].compareTo(minHeap[parent_node]) < 0) {
                    swap(current_node, parent_node);
                    current_node = parent_node;
                    offer = true;
                }
                else
                {
                    break;
                }
            }
        }
        return offer;
    }

    /**
     * Vertauscht 2 Elemente
     * @param current_node
     * @param parent_node
     */
    public void swap(int current_node, int parent_node) {
        E swap_value = minHeap[current_node];
        minHeap[current_node] = minHeap[parent_node];
        minHeap[parent_node] = swap_value;
    }


    /**
     * Ruft den Head des Queues ab und entfernt ihn.
     * Gibt null zurueck, wenn der Queue leer ist.
     * @return E
     */

    @Override
    public E poll() {

        E first_element = peek();
        minHeap[0] = null;
        swap(0, currentSize - 1);
        currentSize--;

        int current_position = 0;
        while (right_node(current_position) < currentSize) {

            int left = left_node(current_position);
            int right = right_node(current_position);
            int current_node = left;

            if (minHeap[right].compareTo(minHeap[left]) < 0) {
                current_node = right;
            }
            if (minHeap[current_node].compareTo(minHeap[current_position]) < 0) {
                swap(current_node, current_position);
                current_position = current_node;
            }
            else {
                break;
            }
        }
        return first_element;
    }

    /**
     * Ruft den Head des Queues ab, entfernt ihn aber nicht.
     * Gibt Null zurueck, wenn diese Warteschlange leer ist.
     * @return E
     */

    @Override
    public E peek() {
        return minHeap[0];
    }

    /**
     * Gibt den Index des parents zurueck
     * @param current_position
     * @return Index des parents
     */

    private int parent(int current_position)
    {
        return (current_position - 1) / 2;
    }

    /**
     * Gibt den Index des left nodes zurueck
     * @param current_position
     * @return Index des left nodes
     */

    private int left_node(int current_position)
    {
        return 2 * current_position + 1;
    }

    /**
     *  Gibt den Index des right nodes zurueck
     * @param current_position
     * @return Index des right nodes
     */

    private int right_node(int current_position)
    {
        return 2 * current_position + 2;
    }

    /**
     * ToString Methode
     * @return String
     */

    public String toString() {
        String result = "";
        for (int i = 0; i < currentSize; i++) {
            result += minHeap[i] + " ";
        }
        return result;
    }

    //-------------- Nicht implementierte Methoden --------------


    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E element() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /**
     * Test-Methode
     * @param args
     */

    public static void main(String[] args) {
        minHeapTest = new MinHeap<Integer>(Integer.class, 20);
        minHeapTest.offer(2);
        minHeapTest.offer(4);
        minHeapTest.offer(3);
        minHeapTest.offer(1);
        minHeapTest.offer(6);
        System.out.println(minHeapTest.toString());
        System.out.println(minHeapTest.peek());
        minHeapTest.poll();
        System.out.println(minHeapTest.toString());
    }
}

