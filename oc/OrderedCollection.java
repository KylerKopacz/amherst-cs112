package oc;

public interface OrderedCollection {
    void append(int toAppend);
    int peek();
    int pop();
    String toString();
    int length();
}
