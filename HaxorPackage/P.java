package HaxorPackage;
import java.util.Random;
public class P{
    protected static int x;
    public P(){
        Random rand = new Random();
        P.x = rand.nextInt(100); //random number
    }

}
