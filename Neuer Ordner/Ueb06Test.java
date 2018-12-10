import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Ueb06Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Ueb06Test
{
    private static final double MITTELWERT_PRAEZISION = 0.000001;
    /**
     * Default constructor for test class Ueb06Test
     */
    public Ueb06Test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /************************************ Messwert Tests ****************************************************/
    
    @Test
    public void test1Messwerte()
    {
        assertArrayEquals(new double[]{0.7, -3.62, -20}, Ueb06.messwerte(new double[]{0.7, -8.6, -20, 0.8, 9}), MITTELWERT_PRAEZISION);
    }
    
    @Test
    public void test2Messwerte()
    {
        assertArrayEquals(new double[]{3.5, 4.16, 9}, Ueb06.messwerte(new double[]{0.1, 0.2, 8, 3.5, 9}), MITTELWERT_PRAEZISION);
    }
    
    @Test
    public void test3Messwerte()
    {
        assertArrayEquals(new double[]{-4, -4.1, -8}, Ueb06.messwerte(new double[]{-4, -3, -4.8, -8, -0.7}), MITTELWERT_PRAEZISION);
    }
    
    @Test
    public void test4Messwerte()
    {
        assertArrayEquals(new double[]{-0.01, 0.061666667, -0.8}, Ueb06.messwerte(new double[]{0.7, 0.4, -0.01, -0.8, -0.25, 0.33}), MITTELWERT_PRAEZISION);
    }
    
    /************************************** StringZaehler Tests **************************************************/
    
    @Test
    public void test1stringZaehler()
    {
        assertTrue(Ueb06.stringZaehler(new String[]{"  dddd  ", "kdkdkfkd  dfk", "dd5", "§d!?", "SnSu"}) == 1);
    }
    
    
    @Test
    public void test2stringZaehler()
    {
        assertFalse(Ueb06.stringZaehler(new String[]{"BvB", "Meisterschaft", "gewinnen", "MR10", "Sancho"}) == 5);
    }
    
    @Test
    public void test3stringZaehler()
    {
        assertTrue(Ueb06.stringZaehler(new String[]{"______", "      ", "§$%&/()", "854245", "MiaSanMia"}) == 1);
    }
    
    @Test
    public void test4stringZaehler()
    {
        assertFalse(Ueb06.stringZaehler(new String[]{"dk:W", "...g", "4öüüöüö", "öüöüäüö", "Götze"}) == 2);
    }
    
    /************************************** InsertionSort Tests **************************************************/
    
    @Test
    public void test1InsertionSort()
    {
        assertArrayEquals(new int[]{1, 2, 3, 4}, Ueb06.insertionSort(new int[]{1, 2, 3, 4}));
    }
                                                                 
    @Test
    public void test2InsertionSort()
    {
        assertArrayEquals(new int[]{-1, 2, 15, 16}, Ueb06.insertionSort(new int[]{-1, 15, 16, 2}));
    }
    
    @Test
    public void test3InsertionSort()
    {
        assertArrayEquals(new int[]{-20, -16, -15, -1}, Ueb06.insertionSort(new int[]{-1, -15, -16, -20}));
    }
    
    @Test
    public void test4InsertionSort()
    {
        assertArrayEquals(new int[]{-100, 7, 10, 20, 560}, Ueb06.insertionSort(new int[]{20, 10, -100, 7, 560}));
    }
}