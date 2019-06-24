import java.util.Random;

/**
 * @author NICOLAS Paul / GAMLIN Nils
 * @version 21/06/2019
 */

public class Producer {

    private Random ran;

    public Producer()
    {
        this.ran = new Random();
    }

    /**
     * Erzeugt einen zufaelligen Integer zwischen 0 und 1000. Und gibt diesen zurueck.
     *
     * @return int produzierte Zahl.
     */

    public int produce() {
        int product = ran.nextInt(100);
        return product;
    }
}