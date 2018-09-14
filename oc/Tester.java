import oc.*;
public class Tester{
    public static void main(String args[]){
        MyGenericDS<String> ds = new MyGenericDS<String>();
        testDS(ds);
    }
    public static void testDS(GenericOrderedCollection<String> ds){
        //append some ints to ds, pop from ds, peek, and print it
        ds.pop();
        System.out.println(ds);
        ds.append("General");
        ds.append("Kenobi");
        System.out.println(ds.peek());
        ds.append("Hello");
        System.out.println(ds);
        ds.pop();
        ds.append("There");
        System.out.println(ds);
        ds.append("Chosen_One");
        System.out.println(ds);
        ds.pop();
        System.out.println(ds.peek());
        ds.append("Execute");ds.append("Order");ds.append("66");ds.append("Yes_M'Lord");
        System.out.println(ds);
        ds.append("Remember_the_younglings");
        System.out.println(ds);
    }
}