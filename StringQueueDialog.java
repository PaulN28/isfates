import java.util.*;


/**
 * Testklasse der Klasse StringQueue
 *
 * @author Nils Gamlin
 * @version 26.01.2019
 */

public class StringQueueDialog
{
    
//--------------------------------Attribute--------------------------------
    
    private Scanner input;
    private boolean stringqueue_existiert;
    private StringQueue stringQueue;
    
    private String MSG_STRINGQUEUE_EXISTIERT_SCHON = "\nSie haben StringQueue schon hergestellt !";
    private String MSG_STRINGQUEUE_EXISTIERT_NICHT = "\nSie haben noch keinen StringQueue erstellt !";
        
    private static final int STRINGQUEUE_ANLEGEN = 1;
    private static final int ADD_LAST = 2;
    private static final int REMOVE_FIRST = 3;
    private static final int PRINT = 4; 
    private static final int ENDE = 0;
    
//--------------------------------Konstruktor--------------------------------

    /**
     * Konstruktor der Klasse StringQueueDialog
     */
    
    public StringQueueDialog(){
        input = new Scanner(System.in);
        stringqueue_existiert = false;
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
        System.out.print("\n" + STRINGQUEUE_ANLEGEN + ": StringQueue anlegen\n" +
                         ADD_LAST + ": Add last\n" +
                         REMOVE_FIRST + ": Remove first\n" +
                         PRINT + ": Print\n" +
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
            case STRINGQUEUE_ANLEGEN:
                if(!stringqueue_existiert){
                    stringQueue = new StringQueue();
                    stringqueue_existiert = true;
                }
                else{
                    System.out.println(MSG_STRINGQUEUE_EXISTIERT_SCHON);
                }
                break;
            case ADD_LAST:
                if(stringqueue_existiert){
                    stringQueue.addLast(einlese_addLast());
                }
                else{
                    System.out.println(MSG_STRINGQUEUE_EXISTIERT_NICHT);
                }
                break;
            case REMOVE_FIRST:
                if(stringqueue_existiert){
                    stringQueue.removeFirst();
                }
                else{
                    System.out.println(MSG_STRINGQUEUE_EXISTIERT_NICHT);
                }
                break;
                
            case PRINT:
                if(stringqueue_existiert){
                    stringQueue.print();
                }
                else{
                    System.out.println(MSG_STRINGQUEUE_EXISTIERT_NICHT);
                }
                break;
            case ENDE:
                System.out.println("\nProgrammende");
                break;

            default:
                System.out.println("\nFalsche Funktion!");
        }
    }
    
    public String einlese_addLast(){
        System.out.println("\nEinzufuegende String: ");
        return input.nextLine();
    }
    
    /**
     * Main Methode zum Erzeugen des StringQueueDialog-Objektes
     * und zum starten der Testschleife
     */
    
    public static void main(String[] args) {
        try{
            new StringQueueDialog().start();
        }
        catch (Throwable e){
            System.out.println("\nmain: Ausnahme gefangen: " + e);
        }
    }
    
}
