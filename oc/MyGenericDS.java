package oc;

import java.util.ArrayList;

public class MyGenericDS<E> implements GenericOrderedCollection<E> {
  
    ArrayList<E> list;

    public MyGenericDS() {
        list = new ArrayList<>();
    }
    public void append(E toAppend){
        list.add(toAppend);
    }
    public E peek() {
        if(list.size() != 0) {
            return list.get(list.size() - 1);
        } else {
            return null;
        }
    }
    public E pop(){
        if(list.size() != 0) {
            E gimme = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return gimme;
        } else {
            return null;
        }
    }
    public void remove(int index){
        list.remove(index);
    }
    public String toString(){
        String gimme = "";
        for(E x: list) {
            gimme += x + " ";
        }
        return gimme;
    }
    public int length(){
        return list.size();
    }
}
