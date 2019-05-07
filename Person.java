 


/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String name;
    private String vorname;

    /**
     * Konstruktor der Klasse Person, mit 2 Argumenten
     * @param name 
     * @param vorname
     */
    
    public Person(String name, String vorname)
    {
        check(name != "" || name != null, "Geben Sie ien gueltigen Namen ein !");
        check(vorname != "" || vorname != null, "Geben Sie ein gueltigen Vornamen ein !");
        this.name = name;
        this.vorname = vorname;
    }
    
    public String getVorname(){
        return vorname;
    }
 
    public void check(boolean bedingung, String msg){
        if (!bedingung){
            throw new IllegalArgumentException(msg);
        }
    }
    
    /**
     * Ueberschreibt die standard Methode toString, damit Namen und Vornamen der Ojekte Person 
     * ausgegeben werden, und nicht die Referenzen zu den Objekten
     */
    
    @Override
    public String toString() {
        return "(" + name + ", " + vorname + ")";
    }
}
