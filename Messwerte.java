import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Klasse der Methode messwerte
 *
 * @author Nils
 * @version 06.12.2018
 */
public class Messwerte
{
    public static void messwerte(double...values) //aendert int Werte zu double Werte
    {
        double mittelwert;
        double summe = 0;
        int anzahlWerte = values.length; //gibt wie viele Parameter der Methode uebergeben wurden zurück
        List<Double> werte = new ArrayList<Double>();
                
        for(double c: values){
            summe += c;
            werte.add(c);
            
        }
        mittelwert = summe / anzahlWerte;
        System.out.println("Mittelwert: " + mittelwert);
        System.out.println(werte);
        
        double entferntesterwert = werte.get(0);
        double naechsterwert = werte.get(0);
        
        for(int i = 1; i < anzahlWerte; i ++){
            if(abs(mittelwert - werte.get(i)) < abs(mittelwert - naechsterwert)) {
                naechsterwert = werte.get(i);
            }
            if(abs(mittelwert - werte.get(i)) > abs(mittelwert - entferntesterwert)) {
                entferntesterwert = werte.get(i);
            }
        }
            
      
        System.out.println("Naechsterwert vom Mittelwert: " + naechsterwert);
        System.out.println("Entferntesterwert vom Mittelwert: " + entferntesterwert);
    }
    
    
    public static void main(String[] args){
        messwerte(0.7, -8.6, -20, 0.8, 9); 
        System.out.println("*********** Naechster Messwert **********");
        messwerte(1.6, -8.6, -0.8, 8, 9.9); 
    
    }
    
}
