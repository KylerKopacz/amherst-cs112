import HaxorPackage.P;
import HaxorPackage.C;

public class Password {
    public static void main(String args[]){
        M pass = new M();
        pass.checkPermissions(pass, pass.findX(), pass.findSuperX(), pass.findY(), pass.findZ());
    }
}

class M extends C {
    public M() {
        super();
    }

    public int findZ() {
        int zee = 0;
        for(int i = 0; i < 100; i++) {
            if(super.zIs(i)) {
                zee = i;
                break;
            }
        }
        return zee;
    }

    public int findX() {
        return super.x;
    }

    public int findY() {
        super.setY(10);
        return 10;
    }

    public int findSuperX() {
        return P.x;
    }
}