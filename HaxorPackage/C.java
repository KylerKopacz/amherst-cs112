package HaxorPackage;
import java.util.Random;

public class C extends P{
    protected int x;
    private int y;
    private static int z;

    public C(){
        super();
        Random rand = new Random();

        y = rand.nextInt(100);
        x = rand.nextInt(100);
    }
    protected void setY(int newY){
        this.y = newY;
        Random rand = new Random();
        z = rand.nextInt(100);

    }

    public Boolean zIs(int target){
        if (z == target){
            return true;
        }
        else{
            return false;
        }
    }

    //this doesnt do anything
    private static void frustrateUser(){
        try{
            for (int i = 0; i < 50; i ++){
                System.out.print(".");
                Thread.sleep(5);
            }
        }
        catch(Exception e){}
        System.out.println("");
    }

    public static void checkPermissions(C c, int x, int superX, int y, int z){
        System.out.print("Checking: ");
        System.out.println(superX + " " + x + " " + y + " " + z);
        System.out.print("Checking x");
        frustrateUser();
        int numGood = 0;
        if (c.x == x){
            numGood += 1;
            System.out.println("\tx: match");
        }
        System.out.print("Checking super x");
        frustrateUser();
        if (P.x == superX){
            numGood += 1;
            System.out.println("\tsuper x: match");
        }
        System.out.print("Checking y");
        frustrateUser();
        if (c.y == y){
            numGood += 1;
            System.out.println("\ty: match");
        }
        System.out.print("Checking z");
        frustrateUser();
        if (C.z == z){
            numGood += 1;
            System.out.println("\tz: match");
        }
        if (numGood == 4){
            System.out.println("You're in!");
            //Note from instructor: sadly we do not have the code of this method:
            //Pr0HaX0rSystem.unlock()
        }
        else{
            System.out.println("You think you can beat me?");
            try{Thread.sleep(1000);}catch(Exception e){}

            System.out.println("One or more of what you entered was WRONG!.");
            System.out.println("But I'm not going to tell you which....");
            System.out.println("HAHAH! You'll never best Pr0HaX0r!");
            frustrateUser();
            System.out.println("Goodbye");
            System.exit(-1);
        }
    }

}


