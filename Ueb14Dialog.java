import java.util.*;

public class Ueb14Dialog {
    private Scanner input;
    
    private Mitarbeiter mitarbeiter;
    private Uhrzeit uhrzeit;
    private Raum raum;
    private String begin;
    private String ende;
    
    private static int beginStunden; //pas hyper propre
    private static int beginMinuten; //pas hyper propre
    private static int endeStunden;  //pas hyper propre
    private static int endeMinuten;  //pas hyper propre
    

    private static final int NEUER_MITARBEITER  = 1;
    private static final int RESERVIERE         = 2;
    private static final int ENDE               = 0;
    
    int intZahl = 0;
    
    //------------------Konstruktor------------------   

    public Ueb14Dialog(){
        input = new Scanner(System.in);
        
    }
    
    public void start(){
        int funktion = -1;
        while(funktion != 0){
            try{
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            }catch (IllegalArgumentException e) {
                System.out.println("Ausnahme gefangen: " + e);
            }catch (InputMismatchException e) {
                System.out.println(e);
                input.next();
            }catch (NullPointerException e) {
                System.out.println(e);
                input.next();
            }catch (Exception e) {
                System.out.println("Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);
            }
        }
    }
    
    //------------------Einlesen + AudfuehrenFunktion------------------   
    
    private int einlesenFunktion() {
        int funktion;
        System.out.print( 
                            NEUER_MITARBEITER   + ": Neuer Mitarbeiter; \n" +
                            RESERVIERE          + ": Reserviere ein Raum; \n" +
                            ENDE                + ": beenden \n" +
                            "->\n");

        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }
  
  
    private void ausfuehrenFunktion(int funktion) {
    String lagername;
    int lagergroesse;

        switch (funktion) {
            
            case NEUER_MITARBEITER :
            
                mitarbeiter = new Mitarbeiter(einlesenVorname(), einlesenName(), einlesenEmail());
            break;

            case RESERVIERE:
                mitarbeiter.reserviere( new Raum(einlesenGebaeude(), einlesenEtage(), einlesenRaum()), 
                                new Uhrzeit(einlesenStundenBegin(), einlesenMinutenBegin()),
                                new Uhrzeit(einlesenStundenEnde(), einlesenMinutenEnde()),
                                einlesenBeschreibung());
                               
                                
             break;

             case ENDE:
                System.out.println("Programmende");
             break;

             default:
                System.out.println("Falsche Funktion!");
        }
   }
  
//------------------Einlesen Mitarbeiter------------------
  
  public String einlesenVorname(){
      System.out.println("\nVorname :");
      return input.nextLine();
  }
  
  public String einlesenName(){
      System.out.println("\nName :");
      return input.nextLine();
  }
  
  public String einlesenEmail(){
      System.out.println("\nEmail :\n");
      return input.nextLine();
  }
    
//------------------Einlesen Uhrzeit------------------
  
  public int einlesenStundenBegin(){
     System.out.println("\nStunden Begin :");
     intZahl = input.nextInt();
     input.nextLine();
     beginStunden = intZahl;
     return intZahl;
  }
  
  public int einlesenMinutenBegin(){
     System.out.println("\nMinuten Begin :");
     intZahl = input.nextInt();
     input.nextLine();
     beginMinuten = intZahl;
     return intZahl;
  }
    
  public int einlesenStundenEnde(){
     System.out.println("\nStunden Ende :");
     intZahl = input.nextInt();
     input.nextLine();
     endeStunden = intZahl;
     return intZahl;
  }
  
  public int einlesenMinutenEnde(){
     System.out.println("\nMinuten Ende :");
     intZahl = input.nextInt();
     input.nextLine();
     endeMinuten = intZahl;
     return intZahl;
  }
    
//------------------Einlesen Raum------------------
    
  public int einlesenEtage(){
     System.out.println("\nEtage :");
     intZahl = input.nextInt();
     input.nextLine();
     return intZahl; 
  }
    
  public int einlesenGebaeude(){
     System.out.println("\nGebaeude :");
     intZahl = input.nextInt();
     input.nextLine();
     return intZahl; 
  }
    
    public int einlesenRaum(){
     System.out.println("\nRaum :");
     intZahl = input.nextInt();
     input.nextLine();
     return intZahl; 
  }
                               
  public String einlesenBeschreibung(){
      System.out.println("\nBeschreibung :");
      return input.nextLine();
  }
  
  public static String getBegin(){
      Uhrzeit begin = new Uhrzeit(beginStunden, beginMinuten);
      return begin.toString();
  }
    
  public static String getEnde(){
      Uhrzeit ende = new Uhrzeit(endeStunden, endeMinuten);
      return ende.toString();
  }
  
}
