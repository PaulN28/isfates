/**
 * Ein Raum befindet sich in einem Gebaeude, auf einer Etage, und besitzt eine Raumnummer.
 *
 * @author Paul Nicolas und Nils Gamlin
 * @date 13/04/2019
 */

package src.ub14;

import java.io.*;
import java.util.*;

public class Raum {

    //----------------Attribute----------------   

    private Reservierung [] reservierungen;
    private int anzReservierungen;

    private int geb;
    private int etage;
    private int raum;

    //----------------Kontruktor----------------   
    /**
     * Konstrukor der Klasse Raum.
     *
     * @param geb (int) die Gebaeudenummer.
     * @param etage (int) die Etage.
     * @param raum (int) die Raumnummer.
     */  

    public Raum(int geb, int etage, int raum) {
        setGeb(geb);
        setEtage(etage);
        setRaum(raum);
        reservierungen = new Reservierung[24];
        anzReservierungen = 0;
    }

    /**
     * Ermoeglicht es die Reservierungen eines Raumes zum speicher (Array) hinzuzufuegen.
     *
     * @param reservierung (Reservierung) die Reservierung eines Raumes.
     */	

    public void addReservierung(Reservierung reservierung){
        check(anzReservierungen <= 24, "Es gibt zu viele Reservierungen");
        reservierungen[anzReservierungen] = reservierung;
        anzReservierungen++;

    }

    //----------------Gebaeude----------------   

    public void setGeb(int geb) {
        check( geb > 0,
            "Gebaude darf groesser als 0 sein");
        this.geb = geb;
    }

    public int getGeb() {
        return geb;
    }

    //----------------Etage----------------   

    public void setEtage(int etage) {
        check( etage >= 0,
            "Etage darf groesser/gleich 0 sein");
        this.etage = etage;
    }

    public int getEtage() {
        return etage;
    }

    //----------------Raum----------------   

    public void setRaum(int raum) {
        check( raum > 0 ,
            "Raum darf groesser als 0 sein");
        this.raum = raum;
    }

    public int getRaum() {
        return raum;
    }

    /**
     * Gibt die Informationen zur Reservierung eines Raumes, als String zurueck.
     *
     * @return String 
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Raum" + geb + "-" +  etage + "." + raum + "\n");

        if(anzReservierungen != 0){
            for (int i=0; i <= anzReservierungen-1; i++) {
                sb.append(reservierungen[i].toString());
            }
        }
        else {
            sb.append("Es gibt im Moment keine Reservierungen");
        }
        return sb.toString();

    }

    public static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }

}
