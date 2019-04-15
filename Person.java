package src.ub14;

public class Person {

// Attribute    
    
    private String vorname;
    private String name;

// Konstruktor
    
    public Person (String vorname, String name) {       
        setVorname(vorname);
        setName(name);
        
    }
    
//Vorname   
    
    public void setVorname(String vorname) {    
        check( vorname != null, 
        "Vorname darf nicht leer sein");
        this.vorname = vorname;
    }
    
    public String getVorname() {
        return vorname;
    }
    
//Name
    
    public void setName(String name) {  
        check( name != null, 
        "Name darf nicht leer sein");
        this.name = name;
    }
        
    public String getName() {
        return name;
    }   
//
    
    public String toString() {
        return String.format("%s %s",
        vorname, name);
     }
    
    public static void check(boolean bedingung, String msg) {
        if (!bedingung)
        throw new IllegalArgumentException(msg);
      }
    
    
}
