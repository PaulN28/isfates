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

    public PrintWriter createFile(String fileName){

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

    public void writeFile(PrintWriter object, String content){
        object.println(content);
    }

    public void saveFile(PrintWriter object){
        object.close();
    }

    public double runIterativeFunction(String teststring){
        long startTime = System.nanoTime();
        Ueb15.isPalindromeIterative(teststring);
        long endTime = System.nanoTime();
        double actualTimeInSeconds = (endTime - startTime) * Math.pow(10, -9);

        return actualTimeInSeconds;
    }

    public double runRecursiveFunction(String teststring){

        long startTime = System.nanoTime();
        Ueb15.isPalindromeRecursive(teststring);
        long endTime = System.nanoTime();
        double actualTimeInSeconds = (endTime - startTime) * Math.pow(10, -9);

        return actualTimeInSeconds;
    }

    public void main(){
        PrintWriter file = createFile("Messungen.txt");
        writeFile(  file, 
            "Teststring   |   Zeit Iterative Lösung   |   Zeit Recursive Lösung   |   Zeitunterschied");

        //3 caracters
        writeFile(file,
            ("SWS" + "   |   " +
                Double.toString(runIterativeFunction("SWS")) + "   |   " +
                Double.toString(runRecursiveFunction("SWS")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("SWS"),
                        runRecursiveFunction("SWS")
                    ) - 
                    Math.min(   runIterativeFunction("SWS"), 
                        runRecursiveFunction("SWS"))) + "   |   "));

        //4 caracters
        writeFile(file,
            ("QWWQ" + "   |   " +
                Double.toString(runIterativeFunction("QWWQ")) + "   |   " +
                Double.toString(runRecursiveFunction("QWWQ")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("QWWQ"),
                        runRecursiveFunction("QWWQ")
                    ) - 
                    Math.min(   runIterativeFunction("QWWQ"), 
                        runRecursiveFunction("QWWQ"))) + "   |   "));

        //5 caracters
        writeFile(file,
            ("xanax" + "   |   " +
                Double.toString(runIterativeFunction("xanax")) + "   |   " +
                Double.toString(runRecursiveFunction("xanax")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("xanax"),
                        runRecursiveFunction("xanax")
                    ) - 
                    Math.min(   runIterativeFunction("xanax"), 
                        runRecursiveFunction("xanax"))) + "   |   "));

        //6 caracters
        writeFile(file,
            ("WESEW" + "   |   " +
                Double.toString(runIterativeFunction("WESEW")) + "   |   " +
                Double.toString(runRecursiveFunction("WESEW")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("WESEW"),
                        runRecursiveFunction("WESEW")
                    ) - 
                    Math.min(   runIterativeFunction("WESEW"), 
                        runRecursiveFunction("WESEW"))) + "   |   "));

        //7 caracters
        writeFile(file,
            ("handnah" + "   |   " +
                Double.toString(runIterativeFunction("handnah")) + "   |   " +
                Double.toString(runRecursiveFunction("handnah")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("handnah"),
                        runRecursiveFunction("handnah")
                    ) - 
                    Math.min(   runIterativeFunction("handnah"), 
                        runRecursiveFunction("handnah"))) + "   |   "));

        //8 caracters
        writeFile(file,
            ("HiHiiHiH" + "   |   " +
                Double.toString(runIterativeFunction("HiHiiHiH")) + "   |   " +
                Double.toString(runRecursiveFunction("HiHiiHiH")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("HiHiiHiH"),
                        runRecursiveFunction("HiHiiHiH")
                    ) - 
                    Math.min(   runIterativeFunction("HiHiiHiH"), 
                        runRecursiveFunction("HiHiiHiH"))) + "   |   "));

        //9 caracters
        writeFile(file,
            ("HoHoHoHoH" + "   |   " +
                Double.toString(runIterativeFunction("HoHoHoHoH")) + "   |   " +
                Double.toString(runRecursiveFunction("HoHoHoHoH")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("HoHoHoHoH"),
                        runRecursiveFunction("HoHoHoHoH")
                    ) - 
                    Math.min(   runIterativeFunction("HoHoHoHoH"), 
                        runRecursiveFunction("HoHoHoHoH"))) + "   |   "));

        //10 caracters
        writeFile(file,
            ("lagerregal" + "   |   " +
                Double.toString(runIterativeFunction("lagerregal")) + "   |   " +
                Double.toString(runRecursiveFunction("lagerregal")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("lagerregal"),
                        runRecursiveFunction("lagerregal")
                    ) - 
                    Math.min(   runIterativeFunction("lagerregal"), 
                        runRecursiveFunction("lagerregal"))) + "   |   "));

        //11 caracters
        writeFile(file,
            ("detartrated" + "   |   " +
                Double.toString(runIterativeFunction("detartrated")) + "   |   " +
                Double.toString(runRecursiveFunction("detartrated")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("detartrated"),
                        runRecursiveFunction("detartrated")
                    ) - 
                    Math.min(   runIterativeFunction("detartrated"), 
                        runRecursiveFunction("detartrated"))) + "   |   ")); 

        //15 caracters 
        writeFile(file,
            ("seegardedragees" + "   |   " +
                Double.toString(runIterativeFunction("seegardedragees")) + "   |   " +
                Double.toString(runRecursiveFunction("seegardedragees")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("seegardedragees"),
                        runRecursiveFunction("seegardedragees")
                    ) - 
                    Math.min(   runIterativeFunction("seegardedragees"), 
                        runRecursiveFunction("seegardedragees"))) + "   |   "));

        //18 caracters 
        writeFile(file,
            ("dienstmannamtsneid" + "   |   " +
                Double.toString(runIterativeFunction("dienstmannamtsneid")) + "   |   " +
                Double.toString(runRecursiveFunction("dienstmannamtsneid")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("dienstmannamtsneid"),
                        runRecursiveFunction("dienstmannamtsneid")
                    ) - 
                    Math.min(   runIterativeFunction("dienstmannamtsneid"), 
                        runRecursiveFunction("dienstmannamtsneid"))) + "   |   "));

        //19 caracters finnish word 
        writeFile(file,
            ("SAIPPUAKIVIKAUPPIAS" + "   |   " +
                Double.toString(runIterativeFunction("SAIPPUAKIVIKAUPPIAS")) + "   |   " +
                Double.toString(runRecursiveFunction("SAIPPUAKIVIKAUPPIAS")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("SAIPPUAKIVIKAUPPIAS"),
                        runRecursiveFunction("SAIPPUAKIVIKAUPPIAS")
                    ) - 
                    Math.min(   runIterativeFunction("SAIPPUAKIVIKAUPPIAS"), 
                        runRecursiveFunction("SAIPPUAKIVIKAUPPIAS"))) + "   |   "));

        //23 caracters  
        writeFile(file,
            ("SASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASAS")) + "   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASAS")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASAS"))) + "   |   "));

        //45 caracters 
        writeFile(file,
            ("SASASASASASASASASASASASASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASAS")) + "   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASAS")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASAS"))) + "   |   "));

                        
        //67 caracters  
        writeFile(file,
            ("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + "   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"))) + "   |   "));

        //133 caracters 
        writeFile(file,
            ("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS" + "   |   " +
                Double.toString(runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + "   |   " +
                Double.toString(runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")) + "   |   " +
                Double.toString(Math.max(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"),
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS")
                    ) - 
                    Math.min(   runIterativeFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"), 
                        runRecursiveFunction("SASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASASAS"))) + "   |   "));

        
                        

        saveFile(file);
    }
}
