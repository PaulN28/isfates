import java.util.*;

/**
 * Testklasse der Klasse PersonQueue
 *
 * @author Nils Gamlin
 * @version 26.01.2019
 */

public class PersonQueueDialog
{
    
//--------------------------------Attribute--------------------------------
    
    private Scanner input;
    private boolean personqueue_existiert;
    private PersonQueue personQueue;
    String vorname;
    String name;
    
    private String MSG_PERSONQUEUE_EXISTIERT_SCHON = "\nSie haben PersonQueue schon hergestellt !";
    private String MSG_PERSONQUEUE_EXISTIERT_NICHT = "\nSie haben noch keinen PersonQueue erstellt !";
        
    private static final int PERSONQUEUE_ANLEGEN = 1;
    private static final int ADD_LAST = 2;
    private static final int REMOVE_FIRST = 3;
    private static final int PRINT = 4; 
    private static final int SMALLEST = 5; 
    private static final int ENDE = 0;
    
    
//--------------------------------Konstruktor--------------------------------
    
    /**
     * Konstruktor der Klasse PersonQueueDialog
     */
    
    public PersonQueueDialog()
    {
        input = new Scanner(System.in);
        personqueue_existiert = false;
    }

//--------------------------------Start--------------------------------    
    
    /**
     * Fuehrt die Methode einlesenFunktion und ausfuehrenFunktion aus
     * bis der Benutzer entscheidet die MEthode zu beenden
     * Beinhaltet auch die Fehlerbehandlung
     */
    
    public void start()
    {
        int funktion = -1;
            
        while (funktion != ENDE){
            try {
                funktion = einleseFunktion();
                ausfuehrenFunktion(funktion);
            }
            catch (IllegalArgumentException e) {
                System.out.println("\nAusnahme gefangen: " + e);
            } 
            catch (InputMismatchException e) {
                System.out.println(e);
                input.next();
            }  
            catch (NullPointerException e) {
                System.out.println(e);
                input.next();
            }
            catch (Exception e) {
                System.out.println("\nAusnahme gefangen: " + e);
                e.printStackTrace(System.out);
            }
        }
    }
  
//--------------------------------Einlesen + ausfuehren Funktion--------------------------------
    
     /**
     * Dient dazu ein Menue im Terminal anzuzeigen
     * Fraegt den Benutzer welche Methoden ausgefuehrt werden sollen
     *
     * @return Auswahl des Benutzers
     */
    
    private int einleseFunktion(){
        int funktion;
        System.out.print("\n" + PERSONQUEUE_ANLEGEN + ": PersonQueue anlegen\n" +
                         ADD_LAST + ": Add last\n" +
                         REMOVE_FIRST + ": Remove first\n" +
                         PRINT + ": Print\n" + 
                         SMALLEST + ": Smallest\n" + 
                         ENDE + ": Ende\n"
                         );
        funktion = input.nextInt();
        input.nextLine();
        return funktion;                  
    }
    
    /**
     * Dient dazu die Methode auszufuehren, die vom Benutzer gewaehlt wurde
     */
    
    public void ausfuehrenFunktion(int funktion){
        switch(funktion){
            case PERSONQUEUE_ANLEGEN:
                if(!personqueue_existiert){
                    personQueue = new PersonQueue();
                    System.out.println("Sie koennen 10 Personnen hinzufügen");
                    personqueue_existiert = true;
                }
                else{
                    System.out.println(MSG_PERSONQUEUE_EXISTIERT_SCHON);
                }
                break;
            case ADD_LAST:
                if(personqueue_existiert){
                    personQueue.addLast(einlese_addLast());
                }
                else{
                    System.out.println(MSG_PERSONQUEUE_EXISTIERT_NICHT);
                }
                break;
            case REMOVE_FIRST:
                if(personqueue_existiert){
                    personQueue.removeFirst();
                }
                else{
                    System.out.println(MSG_PERSONQUEUE_EXISTIERT_NICHT);
                }
                break;
                
            case PRINT:
                if(personqueue_existiert){
                    personQueue.print();
                }
                else{
                    System.out.println(MSG_PERSONQUEUE_EXISTIERT_NICHT);
                }
            case SMALLEST:
                if(personqueue_existiert){
                    System.out.println(personQueue.smallest());
                }
                else{
                    System.out.println(MSG_PERSONQUEUE_EXISTIERT_NICHT);
                }    
        
                break;
            case ENDE:
                System.out.println("Programmende");
                break;

            default:
                System.out.println("Falsche Funktion!");
        }
    }
    
    public Object einlese_addLast(){
        System.out.println("\nVorname: ");
        vorname = input.nextLine();
        System.out.println("\nName: ");
        name = input.nextLine();
        System.out.println("\n" + vorname + " " + name);
        return new Person(name, vorname);
    }
    
    /**
     * Main Methode zum Erzeugen des StringQueueDialog-Objektes
     * und zum starten der Testschleife
     */
    
    public static void main(String[] args) {
        try{
            new PersonQueueDialog().start();
        }
        catch (Throwable e){
            System.out.println("\nmain: Ausnahme gefangen: " + e);
        }
    }
}
