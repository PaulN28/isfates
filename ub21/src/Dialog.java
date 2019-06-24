import java.util.*;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

    /**
     * @author NICOLAS Paul / GAMLIN Nils
     * @version 21/06/2019
     */

    public class Dialog {
        Queue<Integer> queue;
        Consumer consumer;
        Producer producer;
        Random random;

        /**
         * Konstruktor der Klasse Dialog
         * @param choice fifo oder prio
         */

        public Dialog(String choice) {
            if(choice.equals("fifo")) {

                queue = new ArrayDeque<Integer>();

            }else if(choice.equals("prio")) {

                queue = new PriorityQueue<Integer>();

            }else {
                System.out.println("Bitte wählen sie zwischen fifo und prio");
                System.exit(1);
            }

            consumer =  new Consumer();
            producer = new Producer();
            random = new Random();
        }

        /**
         * startet die Tests
         */

        public void start() {

            for(int i = 0; i < 50000; i++) {
                if(random.nextInt(2) > 0) {
                    queue.add(producer.produce());
                } else {
                    try {
                        consumer.consume(queue.remove());
                    } catch(NoSuchElementException e) { }
                }
            }

            System.out.println("\nNumberOfDifferentResult: \n"+ consumer.numberOfDifferentResult());
            System.out.println("GetCrossTotalsAscending: \n"+ consumer.getCrossTotalsAscending());
            System.out.println("GetCrossTotalsDescending: \n"+ consumer.getCrossTotalsDescending());
            System.out.println("numberOfOccurrences of 500:\t\t\t"+ consumer.numberOfOccurrences(500));
            System.out.println("getTimestampsForResult 500:\t\t\t"+ consumer.getTimestampsForResult(500));
        }

        /**
         * main Methode
         * @param args fifo oder prio
         */
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your choice : fifo or prio");
            String choice = input.nextLine();
            Dialog tester = new Dialog(choice);
            tester.start();
        }
    }
