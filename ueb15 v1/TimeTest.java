import java.io.*;
import java.lang.Math.*;

/**
 * Write a description of class TimeTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimeTest
{
    
    private static boolean ergIterative;
    private static boolean ergRecursive;

    public static PrintWriter createFile(String fileName){

        PrintWriter newFile = null;

        try{    
            newFile = new PrintWriter(fileName, "UTF-8");
        }
        catch(IOException ex){
            System.out.println(ex);
        }
        finally{
            return newFile;
        }
    }

    public static void writeFile(PrintWriter object, String content){
        object.println(content);
    }

    public static void saveFile(PrintWriter object){
        object.close();
    }

    public static double runIterativeFunction(String teststring){
        long startTime = System.nanoTime();
        ergIterative = PalindromeIterative.isPalindromeIterative(teststring);
        long endTime = System.nanoTime();
        double actualTimeInSeconds = (endTime - startTime) * Math.pow(10, -9);

        return actualTimeInSeconds;
    }

    public static double runRecursiveFunction(String teststring){

        long startTime = System.nanoTime();
        ergRecursive = PalindromeRecursive.isPalindromeRecursive(teststring);
        long endTime = System.nanoTime();
        double actualTimeInSeconds = (endTime - startTime) * Math.pow(10, -9);

        return actualTimeInSeconds;
    }

    public static void main(String[] args){
        PrintWriter file = createFile("Messungen2.txt");
        writeFile(  file, 
            "Teststring   |   Zeit Iterative Lösung   |   Zeit Recursive Lösung   |   Zeitunterschied");

        //3 caracters
        writeFile(file,
            ("SWS" + "   |   " +
                Double.toString(runIterativeFunction("SWS")) + String.format("(%s)", Boolean.toString(ergIterative)) + "   |   " +
                Double.toString(runRecursiveFunction("SWS")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("SWS"),
                        runRecursiveFunction("SWS")
                    ) - 
                    Math.min(   runIterativeFunction("SWS"), 
                        runRecursiveFunction("SWS"))) + "   |   "));

        //4 caracters
        writeFile(file,
            ("QWWQ" + "   |   " +
                Double.toString(runIterativeFunction("QWWQ")) + String.format("(%s)", Boolean.toString(ergIterative)) + "   |   " +
                Double.toString(runRecursiveFunction("QWWQ")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("QWWQ"),
                        runRecursiveFunction("QWWQ")
                    ) - 
                    Math.min(   runIterativeFunction("QWWQ"), 
                        runRecursiveFunction("QWWQ"))) + "   |   "));

        //5 caracters
        writeFile(file,
            ("xanax" + "   |   " +
                Double.toString(runIterativeFunction("xanax")) + String.format("(%s)", Boolean.toString(ergIterative)) + "   |   " +
                Double.toString(runRecursiveFunction("xanax")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("xanax"),
                        runRecursiveFunction("xanax")
                    ) - 
                    Math.min(   runIterativeFunction("xanax"), 
                        runRecursiveFunction("xanax"))) + "   |   "));

        //5 caracters
        writeFile(file,
            ("WESEW" + "   |   " +
                Double.toString(runIterativeFunction("WESEW")) + String.format("(%s)", Boolean.toString(ergIterative)) + "   |   " +
                Double.toString(runRecursiveFunction("WESEW")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("WESEW"),
                        runRecursiveFunction("WESEW")
                    ) - 
                    Math.min(   runIterativeFunction("WESEW"), 
                        runRecursiveFunction("WESEW"))) + "   |   "));

        //7 caracters
        writeFile(file,
            ("handnah" + "   |   " +
                Double.toString(runIterativeFunction("handnah")) + String.format("(%s)", Boolean.toString(ergIterative)) +"   |   " +
                Double.toString(runRecursiveFunction("handnah")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("handnah"),
                        runRecursiveFunction("handnah")
                    ) - 
                    Math.min(   runIterativeFunction("handnah"), 
                        runRecursiveFunction("handnah"))) + "   |   "));

        //8 caracters
        writeFile(file,
            ("HiHiiHiH" + "   |   " +
                Double.toString(runIterativeFunction("HiHiiHiH")) + String.format("(%s)", Boolean.toString(ergIterative)) +"   |   " +
                Double.toString(runRecursiveFunction("HiHiiHiH")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("HiHiiHiH"),
                        runRecursiveFunction("HiHiiHiH")
                    ) - 
                    Math.min(   runIterativeFunction("HiHiiHiH"), 
                        runRecursiveFunction("HiHiiHiH"))) + "   |   "));

        //9 caracters
        writeFile(file,
            ("HoHoHoHoH" + "   |   " +
                Double.toString(runIterativeFunction("HoHoHoHoH")) + String.format("(%s)", Boolean.toString(ergIterative)) +"   |   " +
                Double.toString(runRecursiveFunction("HoHoHoHoH")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("HoHoHoHoH"),
                        runRecursiveFunction("HoHoHoHoH")
                    ) - 
                    Math.min(   runIterativeFunction("HoHoHoHoH"), 
                        runRecursiveFunction("HoHoHoHoH"))) + "   |   "));

        //10 caracters
        writeFile(file,
            ("lagerregal" + "   |   " +
                Double.toString(runIterativeFunction("lagerregal")) + String.format("(%s)", Boolean.toString(ergIterative)) +"   |   " +
                Double.toString(runRecursiveFunction("lagerregal")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("lagerregal"),
                        runRecursiveFunction("lagerregal")
                    ) - 
                    Math.min(   runIterativeFunction("lagerregal"), 
                        runRecursiveFunction("lagerregal"))) + "   |   "));

        //11 caracters
        writeFile(file,
            ("detartrated" + "   |   " +
                Double.toString(runIterativeFunction("detartrated")) + String.format("(%s)", Boolean.toString(ergIterative)) + "   |   " +
                Double.toString(runRecursiveFunction("detartrated")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("detartrated"),
                        runRecursiveFunction("detartrated")
                    ) - 
                    Math.min(   runIterativeFunction("detartrated"), 
                        runRecursiveFunction("detartrated"))) + "   |   ")); 

        //15 caracters 
        writeFile(file,
            ("seegardedragees" + "   |   " +
                Double.toString(runIterativeFunction("seegardedragees")) + String.format("(%s)", Boolean.toString(ergIterative)) + "   |   " +
                Double.toString(runRecursiveFunction("seegardedragees")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("seegardedragees"),
                        runRecursiveFunction("seegardedragees")
                    ) - 
                    Math.min(   runIterativeFunction("seegardedragees"), 
                        runRecursiveFunction("seegardedragees"))) + "   |   "));

        //18 caracters 
        writeFile(file,
            ("dienstmannamtsneid" + "   |   " +
                Double.toString(runIterativeFunction("dienstmannamtsneid")) + String.format("(%s)", Boolean.toString(ergIterative)) +"   |   " +
                Double.toString(runRecursiveFunction("dienstmannamtsneid")) + String.format("(%s)", Boolean.toString(ergRecursive)) +"   |   " +
                Double.toString(Math.max(   runIterativeFunction("dienstmannamtsneid"),
                        runRecursiveFunction("dienstmannamtsneid")
                    ) - 
                    Math.min(   runIterativeFunction("dienstmannamtsneid"), 
                        runRecursiveFunction("dienstmannamtsneid"))) + "   |   "));

        //19 caracters finnish word 
        writeFile(file,
            ("SAIPPUAKIVIKAUPPIAS" + "   |   " +
                Double.toString(runIterativeFunction("SAIPPUAKIVIKAUPPIAS")) + String.format("(%s)", Boolean.toString(ergIterative)) + "   |   " +
                Double.toString(runRecursiveFunction("SAIPPUAKIVIKAUPPIAS")) + String.format("(%s)", Boolean.toString(ergRecursive)) +"   |   " +
                Double.toString(Math.max(   runIterativeFunction("SAIPPUAKIVIKAUPPIAS"),
                        runRecursiveFunction("SAIPPUAKIVIKAUPPIAS")
                    ) - 
                    Math.min(   runIterativeFunction("SAIPPUAKIVIKAUPPIAS"), 
                        runRecursiveFunction("SAIPPUAKIVIKAUPPIAS"))) + "   |   "));

        //23 caracters  
        writeFile(file,
            ("SASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASAS")) + String.format("(%s)", Boolean.toString(ergIterative)) +  "   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASAS")) + String.format("(%s)", Boolean.toString(ergRecursive)) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASAS"))) + "   |   "));

        //45 caracters 
        writeFile(file,
            ("SASASASASASASASASASASASASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", Boolean.toString(ergIterative)) +"   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", Boolean.toString(ergRecursive)) +"   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASAS"))) + "   |   "));

        //67 caracters  
        writeFile(file,
            ("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", Boolean.toString(ergIterative)) +"   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", Boolean.toString(ergRecursive)) +"   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"))) + "   |   "));

        //133 caracters 
        writeFile(file,
            ("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", String.format("(%s)", Boolean.toString(ergIterative))) + "   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", Boolean.toString(ergRecursive)) +"   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"))) + "   |   "));

        
       
       //200 caracters 
        writeFile(file,
            ("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", String.format("(%s)", Boolean.toString(ergIterative))) + "   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", Boolean.toString(ergRecursive)) +"   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"))) + "   |   "));

       
       
       //265 caracters 
        writeFile(file,
            ("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", String.format("(%s)", Boolean.toString(ergIterative))) + "   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + String.format("(%s)", Boolean.toString(ergRecursive)) +"   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"))) + "   |   "));

       
       
        saveFile(file);
    }
}
