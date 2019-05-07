package IteratorQueue;

/**
 * StringQueue ist eine implementierung des Interface Queue 
 *
 * @author Nils Gamlin
 * @version 26.01.2019
 */


public class StringQueue implements Queue
{

//--------------------------------Attribute--------------------------------

    private String[] stringQueue;
    private int STANDARD_ARRAY_GROESSE = 10;
    private int size = 0;
    
//--------------------------------Konstruktor--------------------------------
    
    /**
     * Konstruktor der Klasse StringQueue
     */
     
    public StringQueue()
    {
        stringQueue = new String[STANDARD_ARRAY_GROESSE];
    }
    
    
//--------------------------------Methoden--------------------------------    
    
    /**
    * Fuegt Objekt dem Queue hinten an
    *
    * @param o ist ein Objekt den man einer Queue hinzufuegen moechte (muss hier ein String Objekt sein)
    */
    
    @Override
    public void addLast(Object o){
        check(size() < STANDARD_ARRAY_GROESSE, "stringQueue ist voll !");
        check(o instanceof String, "Bitte geben Sie ein Object des Typs String ein !");
        for(int i = 0; i < STANDARD_ARRAY_GROESSE; i++){
            if(stringQueue[i] == null){
                stringQueue[i] = (String) o;
                break;
            }  
        }
        size += 1;
    }
    
    /**
    * Entfernt das erste Element und gibt eine Referenz darauf zurueck
    *
    * @return Referenz auf das geloeschte Element
    */
    
    @Override
    public Object removeFirst(){
        check(size() > 0, "stringQueue ist leer!");
        String deletedElement = stringQueue[0];
        for(int i = 0; i < size() - 1; i++){ 
            stringQueue[i] = stringQueue[i + 1];
        }
        stringQueue[size - 1] = null;
        size -= 1;
        return deletedElement;
    }  
    
    /**
    * Gibt das i-te Element zurueck
    *
    * @param  i: index 
    * @return Referenz auf das geloeschte Element
    */
    
    @Override                        
    public Object get(int i){
        return stringQueue[i];
    }      
    
    /**
    * Testet ob Elemente schon eingefuegt wurden
    *
    * @return boolean in Abhaegingkeit vom Ergebnis
    */
    
    @Override
    public boolean empty(){
        return size() == 0;
    } 
    
    /**
    * Testet ob Elemente noch eingefuegt werden koennen
    *
    * @return boolean in Abhaegingkeit vom Ergebnis
    */
    
    @Override
    public boolean full(){
        return size() == STANDARD_ARRAY_GROESSE;
    }         
    
    /**
    * Gibt Anzahl eingefuegter Elemente zurueck
    *
    * @return size Anzahl eingefuegter Elemente
    */
    
    @Override
    public int size(){
        return size;
    }            
    
    /**
    * Gibt den Inhalt einer Queue, mithilfe einer String, zurueck
    */
    
    public void print(){
        System.out.print("\n{") ;
        for(int i = 0; i < STANDARD_ARRAY_GROESSE; i++){
            
            if(i == STANDARD_ARRAY_GROESSE - 1){
                System.out.print(get(i));
            }
            else{
                System.out.print(get(i) + ", ");
            }
        }
        System.out.print("}\n") ;
    }
    
    public void check(boolean bedingung, String msg){
        if (!bedingung){
            throw new IllegalArgumentException(msg);
        }
    }
    
    
}
