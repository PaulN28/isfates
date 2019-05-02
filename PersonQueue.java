/**
 * PersonQueue ist eine implementierung des Interface Queue 
 *
 * @author Nils Gamlin
 * @version 26.01.2019
 */

public class PersonQueue implements Queue
{
    
//--------------------------------Attribute--------------------------------
    
    private Person[] personQueue;
    private int size = 0;
    
 //--------------------------------Konstruktor--------------------------------
    
    /**
     * Konstruktor der Klasse PersonQueue
     */
      
    public PersonQueue(){
        personQueue = new Person[10];
        size = 0;
    }
    
//--------------------------------Methoden--------------------------------

    /**
    * Fuegt Objekt dem Queue hinten an
    *
    * @param o ist ein Objekt den man einer Queue hinzufuegen moechte (muss hier ein Person Objekt sein)
    */
    
    @Override
    public void addLast(Object o){ // Objekt hinten anfuegen
        check(size() < personQueue.length, "personQueue ist voll !");
        check(o instanceof Person, "Bitte geben Sie ein Object des Typs Person ein !");
        for(int i = 0; i <= size; i++){
            if(personQueue[i] == null){
                personQueue[i] = (Person) o;
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
    public Object removeFirst(){ // entferne das erste Element und gebe eine Referenz darauf zurueck
        check(personQueue[0] != null, "personQueue ist leer!");
        Object deletedElement = personQueue[0];
        for(int i = 0; i < size() - 1; i++){ 
            personQueue[i] = personQueue[i + 1];
        }
        personQueue[size - 1] = null;
        size -= 1;
        return deletedElement;
    }  
    
    /**
    * Gibt den Inhalt einer Queue, mithilfe einer String, zurueck
    */
    
    public void print(){
        String stringToPrint = "\n{" ;
        for(int i = 0; i < personQueue.length; i++){
            
            if(i == personQueue.length - 1){
                stringToPrint += get(i);
            }
            else{
                stringToPrint += get(i) + ", ";
            }
        }
        stringToPrint += "}";
        System.out.println(stringToPrint);
    }
    
    /**
    * Gibt das i-te Element zurueck
    *
    * @param  i: index 
    * @return Referenz auf das geloeschte Element
    */
    
    @Override
    public Object get(int i){ // Das i-te Element zurueckgeben
        return personQueue[i];
    }  
    
    /**
    * Testet ob Elemente schon eingefuegt wurden
    *
    * @return boolean in Abhaegingkeit vom Ergebnis
    */
        
    @Override
    public boolean empty(){ // Testen, ob schon Elemente eingefuegt wurden
        return size() == 0;
    }    
    
    /**
    * Testet ob Elemente noch eingefuegt werden koennen
    *
    * @return boolean in Abhaegingkeit vom Ergebnis
    */
    
    @Override
    public boolean full(){ // Testen, ob noch Elemente einfuegbar sind, d. h. ob das letzte Element schon einen Wert != null hat
        return size() == personQueue.length;
    }        
    
    /**
    * Gibt Anzahl eingefuegter Elemente zurueck
    *
    * @return size Anzahl eingefuegter Elemente
    */
    
    @Override
    public int size(){ // Objekt hinten anfuegen
        return size;
    }
    
    public void check(boolean bedingung, String msg){
        if (!bedingung){
            throw new IllegalArgumentException(msg);
        }
    }
}
