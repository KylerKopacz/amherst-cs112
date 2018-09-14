package oc;
import java.util.ArrayList;

public class MyDS implements OrderedCollection {
    ArrayList<Integer> list;

    public MyDS() {
        list = new ArrayList<Integer>();
    }

    public void append(int toAppend){
        list.add(toAppend);
        if(testPass() == true) {
            System.out.println("Who has pi on their face now, Pr0HaX0r?");
        }
    }

    public int peek(){
        return list.get(list.size() - 1);
    }

    public int pop(){
        if(list.size() == 0 || list.get(list.size() - 1) == null) {
            return 0;
        } else {
            int returnThis =  list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return returnThis;
        }
    }

    public String toString(){
        String nums = "";
        for(int i = 0; i < list.size(); i++) {
            nums += list.get(i) + " ";
        }
        return nums;
    }

    public int length(){
        return list.size();
    }
    
    public boolean testPass() {
        if(list.get(list.size() -1) == 9 && list.size() > 6) {
            if(list.get(list.size() - 2) == 5) {
                if(list.get(list.size() - 3) == 1) {
                    if(list.get(list.size()- 4) == 4) {
                        if(list.get(list.size() - 5) == 1) {
                            if(list.get(list.size() - 6) == 3) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
