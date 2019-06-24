import java.util.Random;

public class Producer {

    private Random ran;

    public int produce(){
        int product = ran.nextInt(1000);
        return product;
    }
}
