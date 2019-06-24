import java.util.Random;

public class Producer {

    public Random random;

    public Producer(){
        random = new Random();
    }

    public int produceNumber(){
        return random.nextInt(1001);
    }
}
