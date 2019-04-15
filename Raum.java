package src.ub14;

import java.io.*;
import java.util.*;

public class Raum {

    // Attribute

    private Reservierung [] reservierungen;
    private int anzReservierungen;

    private int geb;
    private int etage;
    private int raum;


    //Konstruktor

    public Raum(int geb, int etage, int raum) {
        setGeb(geb);
        setEtage(etage);
        setRaum(raum);
        reservierungen = new Reservierung[24];
        anzReservierungen = 0;
    }

        public void addReservierung(Reservierung reservierung){
        reservierungen[anzReservierungen] = reservierung;
        anzReservierungen++;

       }

    //geb

        public void setGeb(int geb) {
            check( geb > 0,
            "Gebaude darf groesser als 0 sein");
            this.geb = geb;
        }

        public int getGeb() {
            return geb;
        }

        //etage

        public void setEtage(int etage) {
            check( etage >= 0,
            "Etage darf groesser/gleich 0 sein");
            this.etage = etage;
        }

        public int getEtage() {
            return etage;
        }

        //raum

        public void setRaum(int raum) {
            check( raum > 0 ,
            "Raum darf groesser als 0 sein");
            this.raum = raum;
        }

        public int getRaum() {
            return raum;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb);

            formatter.format("%d-%d.%d", geb, etage, raum);
            for (int i=0; i <= anzReservierungen-1; i++) {
              sb.append(reservierungen[i]);
            }
            return sb.toString();

         }

        public static void check(boolean bedingung, String msg) {
            if (!bedingung)
            throw new IllegalArgumentException(msg);
          }

}
