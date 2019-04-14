public class Person {

    private static String vorname;
    private static String name;
    public Person(String vorname, String name){
        this.setVorname(vorname);
        this.setName(name);
    }
    public static String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public static String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
